package com.hospital.scheduler.scheduler;

import com.hospital.scheduler.db.DBConnection;
import com.hospital.scheduler.doctor.Doctor;
import com.hospital.scheduler.patient.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class Scheduler {
    private List<Doctor> doctors;
    public Scheduler(){
        this.doctors = new ArrayList<>();
    }
    public void addDoctor(Doctor doctor){
        doctors.add(doctor);

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO doctors (name, specialty) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, doctor.getName());
                stmt.setString(2, doctor.getSpecialty());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean schedulePatientToDoctor(Patient patient, String doctorName){
        for(Doctor doctor : doctors){
            if(doctor.getName().equalsIgnoreCase(doctorName)){
                boolean success = doctor.schedulepatients(patient);
                if(success){
                    try (Connection conn = DBConnection.getConnection()) {
                        // Fetch doctor ID from DB
                        String getIdSql = "SELECT id FROM doctors WHERE name = ?";
                        int doctorId = -1;
                        try (PreparedStatement stmt = conn.prepareStatement(getIdSql)) {
                            stmt.setString(1, doctorName);
                            ResultSet rs = stmt.executeQuery();
                            if (rs.next()) {
                                doctorId = rs.getInt("id");
                            }
                        }

                        // Insert patient into DB
                        if (doctorId != -1) {
                            String insertPatient = "INSERT INTO patients (name, age, doctor_id) VALUES (?, ?, ?)";
                            try (PreparedStatement stmt = conn.prepareStatement(insertPatient)) {
                                stmt.setString(1, patient.getName());
                                stmt.setInt(2, patient.getAge());
                                stmt.setInt(3, doctorId);
                                stmt.executeUpdate();
                            }
                        }

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                return success;
            }
        }
        System.out.println("Doctor " + doctorName + " not found");
        return false;
    }

    public void printDoctorSchedules(){
        for(Doctor doctor : doctors){
            doctor.printSchedule();
            System.out.println();
        }
    }
}