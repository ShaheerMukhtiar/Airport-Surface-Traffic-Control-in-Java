package Global_Class;

import java.util.concurrent.TimeUnit;
import java.time.LocalTime;

public class Global_clock implements Runnable {
    protected static int hours;
    protected static int minutes;
    protected static int seconds;

    private static volatile boolean running = true; // Flag to control the clock's execution

    public Global_clock() {
    	LocalTime currentTime = LocalTime.now();
        Global_clock.hours = currentTime.getHour();
        Global_clock.minutes = currentTime.getMinute();
        Global_clock.seconds = currentTime.getSecond();
    }
 // Constructor with exception handling for input validation
    public Global_clock(int hours, int minutes, int seconds) {
        if (isValidTime(hours, minutes, seconds)) {
            Global_clock.hours = hours;
            Global_clock.minutes = minutes;
            Global_clock.seconds = seconds;
        } else {
            throw new IllegalArgumentException("Invalid time values provided.");
        }
    }
    
    public int getHours() {
    	return hours;
    }
    public int getMinutes() {
    	return minutes;
    }
    public int getSeconds() {
    	return seconds;
    }
    
    
    // Helper method for input validation
    private boolean isValidTime(int hours, int minutes, int seconds) {
        return hours >= 0 && hours < 24 && minutes >= 0 && minutes < 60 && seconds >= 0 && seconds < 60;
    }

    // Method to display the current time
    public void displayTime() {
        System.out.printf("%02d:%02d:%02d%n", hours, minutes, seconds);
    }

    // Method to update the time
    private void updateTime() {
        seconds++;
        if (seconds == 60) {
            seconds = 0;
            minutes++;
            if (minutes == 60) {
                minutes = 0;
                hours = (hours + 1) % 24;
            }
        }
    }

    // Method to stop the clock
    public static void stopClock() {
        running = false;
    }
    public static void tick() {
    	running = true;
    }
    public static void setClock(int x,int y, int z) {
        Global_clock.hours = x;
        Global_clock.minutes = y;
        Global_clock.seconds = z;
    }

    // Implementation of the run method for Runnable interface
    @Override
    public void run() {
    	Global_clock.tick();
    	do {
        while (running) {
            try {
            	
                updateTime();
                displayTime();
                TimeUnit.SECONDS.sleep(1);
                if(!running)
                	break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } 
        }
        while(!running) {
        	try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    	}while(true);
    }
    //Getting Time in Seconds
    public static long getTime() {
    	int time_in_seconds=(hours * 3600) +(minutes*60)+seconds;
    	return time_in_seconds;
    }
    
    //Getting time with delta
    public static long getTime(long delta,long time) {
    	long time_in_seconds=delta + time;
    	return time_in_seconds;
    }

//    // Main method for testing
//    public static void main(String[] args) {
//        // Creating an instance of the Clock class
//    	Global_clock clock = new Global_clock(12, 0, 0);
//
//        // Creating a thread for the clock
//        Thread clockThread = new Thread(clock);
//
//        // Starting the clock thread
//        clockThread.start();
//
//        // Run the clock for 10 seconds (for testing purposes)
//        try {
//            TimeUnit.SECONDS.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        // Stopping the clock
//        stopClock();
//    }
}
