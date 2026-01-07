import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ThirdInterface extends JPanel implements MouseListener {
    Box containers[];

    Label subjects[], lastSemGPA, Title, Mssg;
    Label totalMarks[];
    Label headings[];

    DropDownLists gradeLists[];
    Input obtMarks[];
    String Grade[];
    Input gpaInput;

    Button back, contBtn;
    Logo siba;

    ThirdInterface(Info studentInfo) {
        containers = new Box[3];
        containers[0] = new Box(100, 100, 400, 460, Color.WHITE);
        containers[1] = new Box(500, 100, 200, 460, Color.WHITE);
        containers[2] = new Box(700, 100, 200, 460, Color.WHITE);

        int size = studentInfo.s_name.length;
        subjects = new Label[size];
        totalMarks = new Label[size];
        gradeLists = new DropDownLists[size];
        obtMarks = new Input[size];

        headings = new Label[4];

        setBackground(Color.WHITE);
        setLayout(null);
        setPreferredSize(new Dimension(1000, 690));

        siba = new Logo(20, 20, 150, 160);
        add(siba);

        if (studentInfo.transcript_type == "Grades") {
            Title = new Label("SELECT YOUR GRADES", 400, 50);
            Mssg = new Label("Select \"W\" for Withdrawn Course", 100, 560);
        } else {
            Title = new Label("INSERT YOUR MARKS", 400, 50);
            Mssg = new Label("Insert \"W\" for Withdrawn Course", 100, 560);
        }

        Title.setFont(new Font("Calibri", Font.BOLD, 30));
        add(Title);
        Mssg.setFont(new Font("Calibri", Font.BOLD, 18));
        add(Mssg);

        headings[0] = new Label("SUBJECTS", 175, 30);
        containers[0].add(headings[0]);
        headings[1] = new Label("TOTAL MARKS", 37, 30);
        containers[1].add(headings[1]);

        if (studentInfo.transcript_type == "Grades") {
            headings[2] = new Label("GRADES", 60, 30);
            containers[2].add(headings[2]);
        } else {
            headings[3] = new Label("OBTAINED MARKS", 20, 30);
            containers[2].add(headings[3]);
        }

        int y = 100;
        for (int a = 0; a < size; a++) {
            subjects[a] = new Label(studentInfo.s_name[a], 10, y);
            containers[0].add(subjects[a]);
            y += 45;
        }

        y = 100;
        for (int a = 0; a < size; a++) {
            totalMarks[a] = new Label(studentInfo.tot_marks[a] + "", 0, 0);
            totalMarks[a].setBounds(80, y, 40, 50);
            containers[1].add(totalMarks[a]);
            y += 45;
        }

        y = 100;
        for (int a = 0; a < size; a++) {
            String[] gradeItem = { "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "F", "W" };
            if (studentInfo.transcript_type == "Grades") {
                gradeLists[a] = new DropDownLists(0, 0, gradeItem);
                gradeLists[a].setBounds(40, y, 120, 40);
                containers[2].add(gradeLists[a]);
            } else {
                obtMarks[a] = new Input(20, 0);
                obtMarks[a].setBounds(30, y, 140, 40);
                obtMarks[a].setText("0.00");
                obtMarks[a].setHorizontalAlignment(JTextField.CENTER);
                containers[2].add(obtMarks[a]);
            }
            y += 45;
        }

        add(containers[0]);
        add(containers[1]);
        add(containers[2]);

        if (studentInfo.semester > 1) {
            lastSemGPA = new Label("Last Semester's GPA", 110, 600);
            gpaInput = new Input(0, 0);
            gpaInput.setHorizontalAlignment(JTextField.CENTER);
            gpaInput.setBounds(310, 600, 200, 45);
            gpaInput.setText("0.00");
            add(lastSemGPA);
            add(gpaInput);
        }

        back = new Button("BACK", 650, 620);
        back.addMouseListener(this);
        add(back);

        contBtn = new Button("CONTINUE", 800, 620);
        contBtn.addMouseListener(this);
        add(contBtn);

    }

    public void mouseClicked(MouseEvent me) {
    }

    public void mousePressed(MouseEvent me) {
    }

    public void mouseReleased(MouseEvent me) {
        if (me.getSource() == contBtn) {
            contBtn.setBackground(new Color(46, 48, 145));
            contBtn.setForeground(Color.WHITE);
        } else if (me.getSource() == back) {
            back.setBackground(new Color(46, 48, 145));
            back.setForeground(Color.WHITE);
        }
    }

    public void mouseEntered(MouseEvent me) {
        if (me.getSource() == contBtn) {
            contBtn.setBackground(new Color(46, 48, 145));
            contBtn.setForeground(Color.WHITE);
        } else if (me.getSource() == back) {
            back.setBackground(new Color(46, 48, 145));
            back.setForeground(Color.WHITE);
        }

    }

    public void mouseExited(MouseEvent me) {
        if (me.getSource() == contBtn) {
            contBtn.setForeground(new Color(46, 48, 145));
            contBtn.setBackground(Color.WHITE);
        } else if (me.getSource() == back) {
            back.setForeground(new Color(46, 48, 145));
            back.setBackground(Color.WHITE);
        }
    }
}
