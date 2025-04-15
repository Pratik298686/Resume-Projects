🏥 Hospital Scheduler System (Java Console + MySQL)

A simple console-based hospital scheduling system that helps in managing doctors and scheduling patients using Java and MySQL. Designed with modular classes and a focus on clarity and future expandability.

📋 Features

➕ Add new doctors with specialty
➕ Add new patients
📅 Schedule patients to available doctors
📃 View doctor schedules
💾 Store doctors and scheduled patients in a MySQL database
✅ Prevent scheduling beyond a doctor's daily limit (16 patients)

🧱 Project Structure

com.hospital.scheduler
├── main/         → Entry point (`Main.java`)
├── doctor/       → Doctor model and schedule logic
├── patient/      → Patient model
├── scheduler/    → Scheduling logic and database handling
└── db/           → MySQL connection utility (`DBConnection`)

🛠️ Technologies Used

- Java 8+
- MySQL Database
- JDBC for database interaction

🧑‍💻 Getting Started

1️⃣ Prerequisites

- Java JDK installed
- MySQL server running
- MySQL JDBC Driver (add to your classpath or `lib/` folder)
- MySQL database named `hospital_scheduler`

2️⃣ Database Setup

Run the following SQL in your MySQL client:

CREATE DATABASE hospital_scheduler;

USE hospital_scheduler;

CREATE TABLE doctors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    specialty VARCHAR(100)
);

CREATE TABLE patients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    doctor_id INT,
    FOREIGN KEY (doctor_id) REFERENCES doctors(id)
);

3️⃣ Configuration

Check the `DBConnection.java` file and update:

private static final String URL = "jdbc:mysql://localhost:3306/hospital_scheduler";
private static final String USER = "your_mysql_user";
private static final String PASSWORD = "your_mysql_password";

4️⃣ Running the Project

Compile

javac -cp .;path_to_mysql_connector.jar com/hospital/scheduler/main/Main.java

Run

java -cp .;path_to_mysql_connector.jar com.hospital.scheduler.main.Main


