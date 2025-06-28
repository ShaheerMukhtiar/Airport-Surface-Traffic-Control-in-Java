package Task_queue;

import Global_Class.Global_clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class Task_Queue extends Task_Engine implements Runnable {
    private static final ArrayList<Task> queue = new ArrayList<>();
    private static long timeMark = 0;
    private static final Object queueLock = new Object(); // Lock for synchronization

    public Task_Queue() {
    }

    // Appending task to Task Q Based on their priority
    public static void addTask(Task x) {
        try {
            if (x.priority_data < 0)
                throw new IllegalArgumentException("Priority data cannot be less than zero");

            synchronized (queueLock) {
            	
                int index = getIndex(x);
                x.setExecutionTime(Modify_Queue_Time(x, index));
                queue.add(index, x);
            }

        } catch (IllegalArgumentException e) {
            // Handle the exception (print an error message, log, etc.)
            System.err.println("Error: " + e.getMessage());
        }

    }

    private static int getIndex(Task x) {
        synchronized (queueLock) {
            if (queue.size() >= 1) {
                for (int i = 0; i < queue.size(); i++) {
                    if (x.priority_data < queue.get(i).priority_data) {
                        return i;
                    }
                }
            }
            return 0;
        }
    }

    // Dispatcher
    private void dispatcher() {
        while (true) {
            synchronized (queueLock) {
                Iterator<Task> iterator = queue.iterator();
                while (iterator.hasNext()) {
                    Task currentTask = iterator.next();

                    if (timeMark == currentTask.getExecutionTime()) {
                        dispatch(currentTask);
                        iterator.remove(); // Remove the dispatched task from the queue
                    }
                }
            }

            // You may want to introduce a small delay to avoid excessive looping
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Dispatch
    private void dispatch(Task task) {
        // Add your dispatch logic here
        System.out.println("Dispatching task: " + task.primary_label);
    }

    public static long Modify_Queue_Time(Task x, int index) {
        long exeTime = 0;
        synchronized (queueLock) {
            if (queue.isEmpty()) {
                return x.process_time;
            }
            exeTime = queue.get(index - 1).getExecutionTime() + x.process_time;

            for (int i = index; i < queue.size(); i++) {
                queue.get(i).setExecutionTime(queue.get(i).getExecutionTime() + x.process_time);
            }
            return exeTime;
        }
    }

    public void Display_Queue() {
        synchronized (queueLock) {
            for (int i = 0; i < queue.size(); i++) {
                System.out.println(queue.get(i).primary_label);
            }
        }
    }

    @Override
    public void run() {
        Global_clock.tick();
        while (true) {
            timeMark = Global_clock.getTime();
            System.out.println(timeMark);
        }
    }

    public static void main(String[] args) {
        Task_Queue obj = new Task_Queue();
        Thread queueThread = new Thread(obj);

        Thread clockThread = new Thread(new Global_clock());

        queueThread.start();
        clockThread.start();

        // Wait for the threads to finish
        try {
            queueThread.join();
            clockThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
