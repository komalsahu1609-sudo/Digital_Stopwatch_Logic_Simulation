import java.util.Scanner;

class Stopwatch {

    // Private variables (Encapsulation)
    private long startTime;
    private long elapsedTime;
    private boolean isRunning;

    // Constructor
    public Stopwatch() {
        startTime = 0;
        elapsedTime = 0;
        isRunning = false;
    }

    // Start or Resume
    public void start() {
        if (!isRunning) {
            startTime = System.currentTimeMillis() - elapsedTime;
            isRunning = true;
            System.out.println("Stopwatch Started...");
        } else {
            System.out.println("Stopwatch is already running!");
        }
    }

    // Pause
    public void pause() {
        if (isRunning) {
            elapsedTime = System.currentTimeMillis() - startTime;
            isRunning = false;
            System.out.println("Stopwatch Paused...");
        } else {
            System.out.println("Stopwatch is not running!");
        }
    }

    // Reset
    public void reset() {
        startTime = 0;
        elapsedTime = 0;
        isRunning = false;
        System.out.println("Stopwatch Reset.");
    }

    // Get elapsed time
    public long getTime() {
        if (isRunning) {
            return System.currentTimeMillis() - startTime;
        } else {
            return elapsedTime;
        }
    }

    // Display time
    public void display() {
        long time = getTime();
        System.out.println("Elapsed Time: " + time + " ms (" + (time / 1000.0) + " sec)");
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Stopwatch sw = new Stopwatch();
        int choice;

        do {
            System.out.println("\n--- Stopwatch Menu ---");
            System.out.println("1. Start");
            System.out.println("2. Pause");
            System.out.println("3. Reset");
            System.out.println("4. Display Time");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sw.start();
                    break;

                case 2:
                    sw.pause();
                    break;

                case 3:
                    sw.reset();
                    break;

                case 4:
                    sw.display();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}