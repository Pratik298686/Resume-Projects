
package com.hospital.scheduler.scheduler;

import com.hospital.scheduler.doctor.Doctor;
import com.hospital.scheduler.patient.Patient;
import java.util.ArrayList;
import java.util.List;
public class Scheduler {
    private List<Doctor> doctors;
    public Scheduler(){
        this.doctors = new ArrayList<>();
    }
    public void addDoctor(Doctor doctor){
        doctors.add(doctor);
    }
    public boolean schedulePatientToDoctor(Patient patient, String doctorName){
        for(Doctor doctor : doctors){
            if(doctor.getName().equalsIgnoreCase(doctorName)){
                return doctor.schedulepatients(patient);
            }
        }
        System.out.println("Doctor"+doctorName+" not found");
        return false;
    }
    public void printDoctorSchedules(){
        for(Doctor doctor : doctors){
            doctor.printSchedule();
            System.out.println();
        }
    }
}
