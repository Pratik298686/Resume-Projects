package com.hospital.scheduler.main;

import java.util.Scanner;

import com.hospital.scheduler.doctor.Doctor;
import com.hospital.scheduler.patient.Patient;
import com.hospital.scheduler.scheduler.Scheduler;

public class Main {
    public static void main(String[] args) {
        // Create the scheduler
        // Scheduler scheduler = new Scheduler();
        // // Add doctors
        // Doctor doctor1 = new Doctor("John Smith", "Cardiologist");
        // Doctor doctor2 = new Doctor("Emily Davis", "Dermatologist");
        // scheduler.addDoctor(doctor1);
        // scheduler.addDoctor(doctor2);
        // // Create patients
        // Patient patient1 = new Patient("Alice Johnson", 30);
        // Patient patient2 = new Patient("Bob Brown", 45);
        // Patient patient3 = new Patient("Cathy White", 50);
        // // Schedule patients to doctors
        // scheduler.schedulePatientToDoctor(patient1, "John Smith");
        // scheduler.schedulePatientToDoctor(patient2, "John Smith");
        // scheduler.schedulePatientToDoctor(patient3, "Emily Davis");
        // // Print schedules
        // scheduler.printDoctorSchedules();
        Scanner sc = new Scanner(System.in);
        Scheduler scheduler = new Scheduler();

        while (true) {
            System.out.println();
            System.out.println("\n===== Hospital Scheduler Menu =====");
            System.out.println("1. Add Doctor");
            System.out.println("2. Add Patient");
            System.out.println("3. Schedule Patient to Doctor");
            System.out.println("4. View Doctor Schedules");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:// Add Doctor
                    System.out.println("Enter doctor's name: ");
                    String doctorName = sc.nextLine();
                    System.out.println("Enter doctor's specialty: ");
                    String specialty = sc.nextLine();
                    Doctor doctor = new Doctor(doctorName, specialty);
                    scheduler.addDoctor(doctor);
                    System.out.println("Doctor added successfully!");
                    break;

                case 2: // Add Patient
                    System.out.println("Enter patient's name: ");
                    String patientName = sc.nextLine();
                    System.out.println("Enter patient's age: ");
                    int age = sc.nextInt();
                    sc.nextLine(); // Consume newLine
                    Patient patient = new Patient(patientName, age);
                    System.out.println("Patient created: " + patient);
                    break;
                case 3: // Schedule Patient to Doctor
                    System.out.println("Enter patient's name: ");
                    String patientNameForScheduling = sc.nextLine();
                    System.out.println("Enter patient's age: ");
                    int patientAgeForScheduling = sc.nextInt();
                    sc.nextLine();
                    Patient patientToSchedule = new Patient(patientNameForScheduling, patientAgeForScheduling);

                    System.out.println("Enter doctor's name: ");
                    String doctorNameForScheduling = sc.nextLine();
                    boolean success = scheduler.schedulePatientToDoctor(patientToSchedule, doctorNameForScheduling);
                    if (success) {
                        System.out.println("Patient scheduled successfully!");
                    } else {
                        System.out.println("Failed to schedule patient.");
                    }
                    break;
                case 4: // View Doctor Schedule
                    scheduler.printDoctorSchedules();
                    break;
                case 5: // Exit
                    System.out.println("Exiting the scheduler. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        }
    }
}

