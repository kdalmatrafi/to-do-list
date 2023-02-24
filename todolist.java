import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<Task>();
        Scanner scanner = new Scanner(System.in);
        boolean secondTimeRun = false;
        while (true) {
            if (secondTimeRun) {
                System.out.println("\n------------------------------------------------------\n");
            }
            displayOptions();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("\nEnter task description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter task importance level (1-very important, 2-important, 3-normal, 4-not important): ");
                    int importance = scanner.nextInt();
                    scanner.nextLine();
                    Task task = new Task(description, importance);
                    tasks.add(task);
                    System.out.println("Task added successfully.");
                    secondTimeRun = true;
                    break;
                case 2:
                    System.out.print("\nEnter task number to mark as completed: ");
                    int taskNumber = scanner.nextInt();
                    scanner.nextLine();
                    if (taskNumber < 1 || taskNumber > tasks.size()) {
                        System.out.println("Invalid task number.");
                    } else {
                        Task completedTask = tasks.get(taskNumber - 1);
                        completedTask.setCompleted(true);
                        System.out.println("Task marked as completed.");
                    }
                    secondTimeRun = true;
                    break;
                case 3:
                    System.out.println("\nIncomplete Tasks:");
                    for (int i = 0; i < tasks.size(); i++) {
                        Task task1 = tasks.get(i);
                        if (!task1.isCompleted()) {
                            System.out.println((i + 1) + ". " + task1.getDescription() + " - Importance Level: " + task1.getImportanceLevel() + "\n");
                        }
                    }
                    secondTimeRun = true;
                    break;
                case 4:
                    System.out.println("\nCompleted Tasks:");
                    for (int i = 0; i < tasks.size(); i++) {
                        Task task2 = tasks.get(i);
                        if (task2.isCompleted()) {
                            System.out.println((i + 1) + ". " + task2.getDescription() + " - Importance Level: " + task2.getImportanceLevel() + "\n");
                        }
                    }
                    secondTimeRun = true;
                    break;
                case 5:
                    System.out.println("\nExiting program.");
                    secondTimeRun = true;
                    return;
                default:
                    System.out.println("Invalid option.");
                    secondTimeRun = true;
                    break;
            }
        }
    }

    private static void displayOptions() {
        System.out.println("Options:");
        System.out.println("\t1. Enter a new task");
        System.out.println("\t2. Mark a task as completed");
        System.out.println("\t3. View incomplete tasks");
        System.out.println("\t4. View completed tasks");
        System.out.println("\t5. Exit program");
        System.out.print("Enter your choice: ");
    }
}

class Task {
    private String description;
    private int importanceLevel;
    private boolean completed;

    public Task(String description, int importanceLevel) {
        this.description = description;
        this.importanceLevel = importanceLevel;
        this.completed = false;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImportanceLevel(int importanceLevel) {
        this.importanceLevel = importanceLevel;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getDescription() {
        return this.description;
    }

    public int getImportanceLevel() {
        return this.importanceLevel;
    }

    public boolean isCompleted() {
        return this.completed;
    }
}
