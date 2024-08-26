import java.util.ArrayList;
import java.util.Scanner;

class Run {
    private String date;
    private double distance; // distance in kilometers
    private String description;

    public Run(String date, double distance, String description) {
        this.date = date;
        this.distance = distance;
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public double getDistance() {
        return distance;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Date: " + date + ", Distance: " + distance + " km, Description: " + description;
    }
}

public class RunnerApp {
    private ArrayList<Run> runLog;

    public RunnerApp() {
        runLog = new ArrayList<>();
    }

    public void addRun(String date, double distance, String description) {
        Run run = new Run(date, distance, description);
        runLog.add(run);
    }

    public void viewRuns() {
        if (runLog.isEmpty()) {
            System.out.println("No runs logged yet.");
        } else {
            for (Run run : runLog) {
                System.out.println(run);
            }
        }
    }

    public double totalDistance() {
        double total = 0;
        for (Run run : runLog) {
            total += run.getDistance();
        }
        return total;
    }

    public static void main(String[] args) {
        RunnerApp app = new RunnerApp();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nRunner's Routine App");
            System.out.println("1. Log a new run");
            System.out.println("2. View run history");
            System.out.println("3. Calculate total distance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the date (e.g., 2024-08-25): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter the distance (in km): ");
                    double distance = scanner.nextDouble();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter a description: ");
                    String description = scanner.nextLine();
                    app.addRun(date, distance, description);
                    System.out.println("Run logged successfully.");
                    break;

                case 2:
                    System.out.println("\nYour Run History:");
                    app.viewRuns();
                    break;

                case 3:
                    System.out.println("\nTotal Distance Run: " + app.totalDistance() + " km");
                    break;

                case 4:
                    System.out.println("Exiting the app. Happy running!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 4);

        scanner.close();
    }
}
