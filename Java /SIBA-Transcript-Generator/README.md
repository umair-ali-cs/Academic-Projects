# SIBA Transcript Generator

## Overview
SIBA Transcript Generator is a Java-based desktop application developed as an academic project for the **Object Oriented Programming** course. The application automates the generation of student academic transcripts for **Sukkur IBA University**, allowing users to input student details, academic information, and generate a formatted transcript that can be printed or exported as a PDF using the system print dialog.

The project focuses on applying **Object-Oriented Programming principles**, GUI development using **Java Swing**, and accurate **GPA calculation logic**.

---

## Features
- GUI-based multi-step transcript generation workflow
- Input of student details (Name, CMS ID, Department, Semester)
- Support for grade-based and marks-based transcripts
- Dynamic subject loading based on department and semester
- Accurate GPA and CGPA calculation (including previous semester GPA)
- Input validation for marks and required fields
- Printable transcript with structured formatting
- PDF export via system print dialog (e.g., Microsoft Print to PDF)

---

## Technologies Used
- Language: Java (JDK 17)
- GUI Framework: Java Swing
- IDE: Visual Studio Code
- Platform: Windows
- Concepts Applied: Object-Oriented Programming (Encapsulation, Inheritance, Modularity)

---

## Project Structure
```
Project/
│
├── Source code/
│   ├── Main.java
│   ├── FirstFrame.java
│   ├── GetDepartments.java
│   ├── Interfaces/
│   │   ├── FirstInterface.java
│   │   ├── SecondInterface.java
│   │   ├── ThirdInterface.java
│   │   └── FourthInterface.java
│   └── Components/
│       ├── Box.java
│       ├── Button.java
│       ├── DropDownLists.java
│       ├── Input.java
│       ├── Label.java
│       ├── Logo.java
│       ├── MainButtons.java
│       ├── MainLogo.java
│       └── Images/
│           ├── GenerateIcon.png
│           └── IBALogo.png
├── Sample Transcripts/
├── Final Report.pdf
└── README.md
```

---

## How It Works
1. User starts the application and selects transcript generation.
2. Student details and academic information are entered.
3. Subjects are loaded dynamically based on department and semester.
4. Grades or marks are entered with validation.
5. GPA and CGPA are calculated according to predefined rules.
6. A transcript preview is displayed.
7. The transcript can be printed or exported as a PDF using the system print dialog.

---

## Limitations
- Academic data is statically defined (no database integration).
- PDF generation relies on the operating system’s print services.
- Designed for academic and learning purposes, not production deployment.

---

## Author
**Umair Ali**  
BS Computer Science  
Sukkur IBA University  

---

## License
This project is developed for academic and educational purposes.
