import java.util.PriorityQueue;
import java.util.Scanner;

class Patient implements Comparable<Patient> {
    private String name;
    private int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    public String getName() {
        return name;
    }

    public int getSeverity() {
        return severity;
    }

    @Override
    public int compareTo(Patient other) {
        return Integer.compare(this.severity, other.severity); // Min-Heap: Least severity first
    }

    @Override
    public String toString() {
        return "Patient{name='" + name + "', severity=" + severity + "}";
    }
}

public class PatientPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Patient> patientQueue = new PriorityQueue<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hospital Patient Priority Queue");

        while (true) {
            System.out.println("\n1. Add Patient");
            System.out.println("2. View Next Patient");
            System.out.println("3. Attend to Patient");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter patient name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter severity level (1=Critical, 5=Mild):");
                    int severity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    patientQueue.add(new Patient(name, severity));
                    System.out.println("Patient added to the queue.");
                    break;
                case 2:
                    if (patientQueue.isEmpty()) {
                        System.out.println("No patients in the queue.");
                    } else {
                        System.out.println("Next Patient: " + patientQueue.peek());
                    }
                    break;
                case 3:
                    if (patientQueue.isEmpty()) {
                        System.out.println("No patients to attend to.");
                    } else {
                        System.out.println("Attending to: " + patientQueue.poll());
                    }
                    break;
                case 4:
                    System.out.println("Exiting Patient Priority Queue. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}