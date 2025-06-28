package Task_queue;

import java.util.Scanner;

import Global_Class.Global_clock;

public class ControllTask extends Task {
    protected int originalLink;
    protected int nextLink;
    protected long startingTime;
    protected long endingTime;
    private Scanner input = new Scanner(System.in);

    public ControllTask() {

    }

    public ControllTask(String label1, String label2) {
        super(label1, label2);
        originalLink = getOriginalLinkFromUser();
        nextLink = getNextLinkFromUser();
        startingTime = calculateStartingTime();
        endingTime = calculateEndingTime();
    }

    public int getOriginalLinkFromUser() {
        System.out.print("\nEnter Starting Link: ");
        return input.nextInt();
    }

    public int getNextLinkFromUser() {
        System.out.print("\nEnter Next Link: ");
        return input.nextInt();
    }

    public long calculateStartingTime() {
        return Global_clock.getTime();
    }

    public long calculateEndingTime() {
        return Global_clock.getTime() + 10;
    }

    // Close the Scanner when it's no longer needed
    public void closeScanner() {
        input.close();
    }
}
