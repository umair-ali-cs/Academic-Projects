import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.*;
import java.awt.print.*;

public class FirstFrame extends JFrame implements ActionListener {
    FirstInterface first;
    SecondInterface second;
    ThirdInterface third;
    FourthInterface fourth;

    JPanel background;
    ImageIcon SIBAlogo;

    GetDepartments depts;

    Info student = new Info();
    Logo siba;

    FirstFrame() {
        first = new FirstInterface();
        second = new SecondInterface();
        depts = new GetDepartments();
        SIBAlogo = new ImageIcon("Images/IBALogo.png");

        background = new JPanel();
        background.setLayout(new FlowLayout());
        background.setBorder(BorderFactory.createLineBorder(new Color(46, 48, 145), 2));
        background.setBackground(new Color(210, 210, 210));
        background.setBackground(Color.white);

        setLayout(new BorderLayout());
        setSize(1030, 743);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("SIBA Transcript Generator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.WHITE);
        setIconImage(SIBAlogo.getImage());

        add(background);

        // Center Workplace Panel
        second.setVisible(false);
        background.add(first); // adding panel in a Background Panel
        background.add(second); // adding panel in a Background Panel

        setVisible(true);

        // adding action listeners to Buttons
        first.generate.addActionListener(this);
        second.contBtn.addActionListener(this);
        second.back.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == first.generate) {
            first.setVisible(false);
            second.setVisible(true);
        } else if (e.getSource() == second.back) {
            second.setVisible(false);
            first.setVisible(true);
        } else if (e.getSource() == second.contBtn) {
            if (second.fnameInput.getText().equals("")
                    || second.lnameInput.getText().equals("")
                    || second.idInput.getText().equals("")) {
                Label error = new Label("*Empty Field", 100, 600);
                error.setForeground(Color.red);
                second.add(error);
                second.revalidate();
                second.repaint();
            } else {
                second.setVisible(false);
                student.semester = (int) second.semList.getSelectedItem();
                student.department = (String) second.deptList.getSelectedItem();
                student.transcript_type = (String) second.typeList.getSelectedItem();

                student.prev_Credits = depts.getPrevCredits(student.department, student.semester); // previous Credits
                depts.getDept(student.department, student.semester); // to get subject Array

                student.name = second.fnameInput.getText() + " " + second.lnameInput.getText(); // Name
                student.cms_id = second.idInput.getText(); // CMS - ID

                student.s_name = depts.subject; // subjects
                student.c_hours = depts.credit; // credits
                student.tot_marks = depts.total; // Total Marks
                student.courseState = new String[student.s_name.length];

                third = new ThirdInterface(student);
                third.back.addActionListener(this);
                third.contBtn.addActionListener(this);
                background.add(third);
            }
        } else if (e.getSource() == third.back) {
            third.setVisible(false);
            second.setVisible(true);
        } else if (e.getSource() == third.contBtn) {
            boolean flag = true; // For Validations
            if (student.transcript_type == "Grades") {
                for (int a = 0; a < third.gradeLists.length; a++) {
                    if (third.gradeLists[a].getSelectedItem().equals("W")) {
                        student.courseState[a] = "Withdrawn";
                    } else {
                        student.courseState[a] = "Completed";
                    }
                }
            } else {
                // Checking whether all inputs in marks are in number format and in a range...
                // (>= 0 and <= totalmarks) Or Withdrawn
                for (int a = 0; a < third.obtMarks.length; a++) {
                    if (third.obtMarks[a].getText().toUpperCase().equals("W")) {
                        student.courseState[a] = "Withdrawn";
                    } else {
                        student.courseState[a] = "Completed";
                    }

                    if (student.courseState[a].equals("Completed")) {
                        double x = 0;
                        try {
                            x = Double.parseDouble(third.obtMarks[a].getText());
                        } catch (Exception error_e) {
                            flag = false;
                        }
                        if (x < 0 || x > student.tot_marks[a]) {
                            flag = false;
                        }
                    }
                }
            }

            // Checking if last semester GPA input is valid or not
            if (student.semester > 1) {
                try {
                    student.lastsemgpa = Double.parseDouble(third.gpaInput.getText());
                } catch (Exception error_e) {
                    flag = false;
                }
                if (student.lastsemgpa < 0 || student.lastsemgpa > 4) {
                    flag = false;
                }
            }

            // If everything is Correct
            if (flag) {
                int size = student.s_name.length;
                student.std_grades = new String[size];
                student.sub_cgpa = new double[size];

                if (student.transcript_type == "Grades") {
                    for (int a = 0; a < size; a++) {
                        student.std_grades[a] = (String) third.gradeLists[a].getSelectedItem();
                    }
                } else {
                    for (int a = 0; a < size; a++) {
                        if (student.courseState[a].equals("Completed")) {
                            double obt = Double.parseDouble(third.obtMarks[a].getText());
                            obt = RoundOFF(obt);
                            int tot = student.tot_marks[a];
                            student.std_grades[a] = getSubGrade(tot, obt);
                        } else {
                            student.std_grades[a] = "W";
                        }
                    }
                }

                for (int a = 0; a < size; a++) {
                    if (student.courseState[a].equals("Completed"))
                        student.sub_cgpa[a] = getSubGPA(student.std_grades[a]);
                }

                student.totalgpa = getTotalGPA(student.c_hours, student.sub_cgpa, student.semester, student.lastsemgpa,
                        student.prev_Credits, student.courseState);

                fourth = new FourthInterface(student);
                background.add(fourth);
                fourth.back.addActionListener(this);
                fourth.print.addActionListener(this);
                third.setVisible(false);
                fourth.setVisible(true);
            } else {
                Label error = new Label("Error: *Invalid Input Detected", 110, 640);
                error.setForeground(Color.red);
                third.add(error);
                third.revalidate();
                third.repaint();
            }
        } else if (e.getSource() == fourth.back) {
            fourth.setVisible(false);
            third.setVisible(true);
        } else if (e.getSource() == fourth.print) {

            fourth.cover.setVisible(false);

            PrinterJob job = PrinterJob.getPrinterJob();
            job.setPrintable(fourth);
            if (job.printDialog()) {
                try {
                    job.print();
                    Label success = new Label("Transcript sent to printer", 100, 640);
                    success.setForeground(Color.green);
                    fourth.add(success);
                    fourth.revalidate();
                    fourth.repaint();
                } catch (PrinterException ex) {
                    Label error = new Label("Error: Unable to print", 110, 640);
                    error.setForeground(Color.red);
                    fourth.add(error);
                    fourth.revalidate();
                    fourth.repaint();
                }
            }
            fourth.cover.setVisible(true);
        }
    }

    public static String getSubGrade(int totalmarks, double obt_marks) {
        double per = (obt_marks / totalmarks) * 100;
        if (per >= 93 && per <= 100) {
            return "A";
        } else if (per >= 87) {
            return "A-";
        } else if (per >= 82) {
            return "B+";
        } else if (per >= 77) {
            return "B";
        } else if (per >= 72) {
            return "B-";
        } else if (per >= 68) {
            return "C+";
        } else if (per >= 64) {
            return "C";
        } else if (per >= 60) {
            return "C-";
        } else {
            return "F";
        }
    }

    public static double getSubGPA(String grade) {
        if (grade == "A") {
            return 4.0;
        } else if (grade == "A-") {
            return 3.67;
        } else if (grade == "B+") {
            return 3.33;
        } else if (grade == "B") {
            return 3.00;
        } else if (grade == "B-") {
            return 2.67;
        } else if (grade == "C+") {
            return 2.30;
        } else if (grade == "C") {
            return 2.00;
        } else if (grade == "C-") {
            return 1.67;
        } else {
            return 0.00;
        }
    }

    public static int RoundOFF(double num) {
        int x = (int) num;
        if (num - x > 0.4444444) {
            return x + 1;
        } else {
            return x;
        }
    }

    public static double getTotalGPA(int credit[], double s_gpa[], int semester, double lastsemgpa, int prev_cr,
            String courseState[]) {
        int sum = 0;
        double gpa = 0, cgpa = 0;

        for (int a = 0; a < credit.length; a++) {
            if (courseState[a].equals("Completed")) {
                sum += credit[a];
                gpa += credit[a] * s_gpa[a];
            }
        }
        gpa/=sum;
        if (semester > 1) {
            cgpa = ((lastsemgpa * prev_cr) + (gpa * sum)) / (sum + prev_cr);
        } else {
            cgpa = gpa;
        }

        BigDecimal num = new BigDecimal(cgpa);
        BigDecimal rounded = num.setScale(2, RoundingMode.HALF_UP);
        String str = rounded + "";
        cgpa = Double.parseDouble(str);
        return cgpa;
    }
}
