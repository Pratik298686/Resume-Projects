Hospital Scheduler Application
Overview
The Hospital Scheduler is a Java-based application designed to manage doctors and patients effectively. It enables hospitals to efficiently assign patients to doctors based on availability, ensuring optimal scheduling and reducing manual effort.

Features
* Add Doctors: Register new doctors with their specialties.
* Add Patients: Add patients with their name and age.
* Schedule Patients to Doctors: Assign patients to doctors, ensuring doctors are not overbooked (maximum of 16 patients per day).
* View Doctor Schedules: Display the schedule of each doctor, including their assigned patients.

Key Functionalities
1. Dynamic Scheduling: Automatically handles patient assignments based on doctor availability.
2. Simple Interface: Command-line interface for easy interaction.
3. Real-time Feedback: Notifies if a doctor is fully booked or if scheduling fails due to invalid input.

Project Structure
src/
├── com/hospital/scheduler/
│   ├── Main.java
│   ├── doctor/
│   │   └── Doctor.java
│   ├── patient/
│   │   └── Patient.java
│   └── scheduler/
│       └── Scheduler.java

Requirements
* Java 8 or later

Usage
1. Compile the application:
javac -d . Main.java doctor/Doctor.java patient/Patient.java scheduler/Scheduler.java

2. Run the application:
java com.hospital.scheduler.Main

3. Follow the menu options to add doctors, patients, schedule appointments, and view schedules.

How It Works
1. Adding Doctors:
* Each doctor is registered with a name and specialty.
Doctors can handle up to 16 patients per day.

2. Adding Patients:
* Patients are registered with their name and age.

3. Scheduling Patients:
* Assign a patient to a doctor by specifying the doctor's name.
* If a doctor is fully booked, the scheduling fails with an appropriate message.

4. Viewing Schedules:
* Lists all doctors and their assigned patients in an organized format.

Example
===== Hospital Scheduler Menu =====
1. Add Doctor
2. Add Patient
3. Schedule Patient to Doctor
4. View Doctor Schedules
5. Exit
Enter your choice: 1
Enter doctor's name: John Smith
Enter doctor's specialty: Cardiologist
Doctor added successfully!

Future Enhancements
* Implement a graphical user interface (GUI).
* Add persistence with database integration.
* Include advanced scheduling algorithms.

