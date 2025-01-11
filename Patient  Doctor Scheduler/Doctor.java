package com.hospital.scheduler.doctor;

import com.hospital.scheduler.patient.Patient;
// import com.hospital.scheduler.scheduler.Appointment;

import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private String name;
    private String specialty;
    private List<Patient> scheduledPatients;

    public Doctor(String name, String specialty)
    {
        this.name = name;
        this.specialty = specialty;
        this.scheduledPatients = new ArrayList<>();
    }
    public String getName(){
        return name;
    }
    public String getSpecialty(){
        return specialty;
    }
    public List<Patient> getScheduledPatients(){
        return scheduledPatients;
    }
    public boolean schedulepatients(Patient patient){
        if(scheduledPatients.size() < 16){
            scheduledPatients.add(patient);
            return true;
        }else{
            System.out.println("Doctor "+name+" is fully booked for the day");
            return false;
        }
    }
    public void printSchedule(){
        System.out.println("Doctor: "+ name + " ("+specialty+")");
        System.out.println("Scheduled Patients: ");
        for(Patient patient : scheduledPatients){
            System.out.println("-   "+patient);
        }
        System.out.println("Total Patients Scheduled: "+scheduledPatients);
    }
}
