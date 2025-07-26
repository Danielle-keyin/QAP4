import db.PatientDatabaseHandler;
import entities.Drug;
import entities.Patient;
import io.DrugFileHandler;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Persistence Playground ---");
            System.out.println("1. Save Drug to file");
            System.out.println("2. Read Drugs from file");
            System.out.println("3. Save Patient to database");
            System.out.println("4. Read Patients from database");
            System.out.println("0. Exit");
            System.out.print("Pick your poison: ");
if (scanner.hasNextInt()) {
    choice = scanner.nextInt();
    scanner.nextLine();
} else {
    System.out.println("Invalid input! Numbers only please.");
    scanner.nextLine();
    choice = -1;
}

            switch (choice) {
                case 1 -> {
                    System.out.print("Drug ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Cost: ");
                    double cost = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Dosage: ");
                    String dosage = scanner.nextLine();

                    DrugFileHandler.saveDrug(new Drug(id, name, cost, dosage));
                }
                case 2 -> {
                    List<Drug> drugs = DrugFileHandler.readDrugs();
                    System.out.println("--- All Drugs ---");
                    drugs.forEach(System.out::println);
                }
                case 3 -> {
                    System.out.print("Patient ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("First Name: ");
                    String first = scanner.nextLine();
                    System.out.print("Last Name: ");
                    String last = scanner.nextLine();
                    System.out.print("DOB (YYYY-MM-DD): ");
                    String dobStr = scanner.nextLine();
                    Date dob = Date.valueOf(dobStr);

                    PatientDatabaseHandler.savePatient(new Patient(id, first, last, dob));
                }
                case 4 -> {
                    List<Patient> patients = PatientDatabaseHandler.readPatients();
                    System.out.println("--- All Patients ---");
                    patients.forEach(System.out::println);
                }
                case 0 -> System.out.println("Peace out.");
                default -> System.out.println("Invalid option! Try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
