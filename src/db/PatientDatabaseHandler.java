package db;

import entities.Patient;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDatabaseHandler {
    private static final String URL = "jdbc:postgresql://localhost:5432/your_db_name";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void savePatient(Patient patient) {
        String sql = "INSERT INTO patients (patient_id, first_name, last_name, date_of_birth) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, patient.getPatientId());
            stmt.setString(2, patient.getPatientFirstName());
            stmt.setString(3, patient.getPatientLastName());
            stmt.setDate(4, patient.getPatientDOB());

            stmt.executeUpdate();
            System.out.println("Patient saved to database.");

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    public static List<Patient> readPatients() {
        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT * FROM patients";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                patients.add(new Patient(
                    rs.getInt("patient_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getDate("date_of_birth")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
        return patients;
    }
}
