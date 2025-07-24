package entities;

import java.sql.Date;

public class Patient {
    private int patientId;
    private String patientFirstName;
    private String patientLastName;
    private Date patientDOB; // java.sql.Date for JDBC

    public Patient(int patientId, String patientFirstName, String patientLastName, Date patientDOB) {
        this.patientId = patientId;
        this.patientFirstName = patientFirstName;
        this.patientLastName = patientLastName;
        this.patientDOB = patientDOB;
    }

    public int getPatientId() { return patientId; }
    public String getPatientFirstName() { return patientFirstName; }
    public String getPatientLastName() { return patientLastName; }
    public Date getPatientDOB() { return patientDOB; }

    @Override
    public String toString() {
        return patientId + " - " + patientFirstName + " " + patientLastName + " (" + patientDOB + ")";
    }
}
