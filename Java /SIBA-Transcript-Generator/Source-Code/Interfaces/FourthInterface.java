import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;

public class FourthInterface extends JPanel implements MouseListener, Printable {
    Box containers[], cover;
    Label name, id, sem, dept, subjects[], credits[], gpa[], grades[], Title;
    Label headings[], Total_Gpa;
    Button print, back;
    Logo siba;
    Info studentInfo;

    FourthInterface(Info studentInfo) {
        this.studentInfo = studentInfo;
        containers = new Box[7];
        containers[0] = new Box(100, 100, 400, 90, Color.white);
        containers[1] = new Box(600, 100, 350, 90, Color.white);
        containers[2] = new Box(3, 5, 500, 360, Color.white);
        containers[3] = new Box(503, 5, 100, 360, Color.white);
        containers[4] = new Box(603, 5, 100, 360, Color.white);
        containers[5] = new Box(703, 5, 100, 360, Color.white);
        containers[6] = new Box(98, 220, 805, 370, Color.black);

        headings = new Label[4];

        int size = studentInfo.s_name.length;
        subjects = new Label[size];
        credits = new Label[size];
        gpa = new Label[size];
        grades = new Label[size];

        setBackground(Color.WHITE);
        setLayout(null);
        setPreferredSize(new Dimension(1000, 690));

        siba = new Logo(10, 0, 100, 107);
        add(siba);

        Title = new Label("TRANSCRIPT", 420, 40);
        Title.setFont(new Font("Calibri", Font.BOLD, 30));
        add(Title);

        name = new Label("Name    : " + studentInfo.name, 10, 5);
        name.setFont(new Font("Calibri", Font.BOLD, 18));
        containers[0].add(name);
        id = new Label("CMS-ID : " + studentInfo.cms_id, 10, 45);
        id.setFont(new Font("Calibri", Font.BOLD, 18));
        containers[0].add(id);

        dept = new Label("Department : " + studentInfo.department, 10, 5);
        dept.setFont(new Font("Calibri", Font.BOLD, 18));
        containers[1].add(dept);
        sem = new Label("Semester      : " + studentInfo.semester, 10, 45);
        sem.setFont(new Font("Calibri", Font.BOLD, 18));
        containers[1].add(sem);

        headings[0] = new Label("SUBJECTS", 215, 0);
        containers[2].add(headings[0]);
        headings[1] = new Label("CREDITS", 15, 0);
        containers[3].add(headings[1]);
        headings[2] = new Label("GPA", 35, 0);
        containers[4].add(headings[2]);
        headings[3] = new Label("GRADES", 15, 0);
        containers[5].add(headings[3]);

        int y = 40;
        for (int a = 0; a < size; a++) {
            subjects[a] = new Label(studentInfo.s_name[a], 10, y);
            subjects[a].setFont(new Font("Calibri", Font.PLAIN, 18));
            containers[2].add(subjects[a]);
            y += 40;
        }

        y = 40;
        for (int a = 0; a < size; a++) {
            credits[a] = new Label(studentInfo.c_hours[a] + "", 43, y);
            credits[a].setFont(new Font("Calibri", Font.PLAIN, 18));
            containers[3].add(credits[a]);
            y += 40;
        }

        y = 40;
        for (int a = 0; a < size; a++) {
            if (studentInfo.courseState[a].equals("Withdrawn")) {
                gpa[a] = new Label("-", 40, y);
            } else {
                gpa[a] = new Label(studentInfo.sub_cgpa[a] + "", 40, y);
            }
            gpa[a].setFont(new Font("Calibri", Font.PLAIN, 18));
            containers[4].add(gpa[a]);
            y += 40;
        }

        y = 40;
        for (int a = 0; a < size; a++) {
            grades[a] = new Label(studentInfo.std_grades[a], 43, y);
            grades[a].setFont(new Font("Calibri", Font.PLAIN, 18));
            containers[5].add(grades[a]);
            y += 40;
        }

        Total_Gpa = new Label("Total CGPA: " + studentInfo.totalgpa, 100, 600);
        Total_Gpa.setFont(new Font("Calibri", Font.BOLD, 18));
        add(Total_Gpa);

        cover = new Box(650, 620, 300, 50, Color.WHITE);
        add(cover);

        back = new Button("BACK", 0, 0);
        back.addMouseListener(this);
        cover.add(back);

        print = new Button("PRINT", 150, 0);
        print.addMouseListener(this);
        cover.add(print);

        for (int a = 2; a < 6; a++) {
            containers[6].add(containers[a]);
        }
        add(containers[0]);
        add(containers[1]);
        add(containers[6]);
    }

    public void mouseClicked(MouseEvent me) {
    }

    public void mousePressed(MouseEvent me) {
    }

    public void mouseReleased(MouseEvent me) {
        if (me.getSource() == back) {
            back.setBackground(new Color(46, 48, 145));
            back.setForeground(Color.WHITE);
        } else if (me.getSource() == print) {
            print.setBackground(new Color(46, 48, 145));
            print.setForeground(Color.WHITE);
        }
    }

    public void mouseEntered(MouseEvent me) {
        if (me.getSource() == back) {
            back.setBackground(new Color(46, 48, 145));
            back.setForeground(Color.WHITE);
        } else if (me.getSource() == print) {
            print.setBackground(new Color(46, 48, 145));
            print.setForeground(Color.WHITE);
        }
    }

    public void mouseExited(MouseEvent me) {
        if (me.getSource() == back) {
            back.setForeground(new Color(46, 48, 145));
            back.setBackground(Color.WHITE);
        } else if (me.getSource() == print) {
            print.setForeground(new Color(46, 48, 145));
            print.setBackground(Color.WHITE);
        }
    }

    public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
        if (page > 0) {
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());

        // Scale content to fit page
        double scaleX = pf.getImageableWidth() / getWidth();
        double scaleY = pf.getImageableHeight() / getHeight();
        double scale = Math.min(scaleX, scaleY);
        g2d.scale(scale, scale);

        paint(g2d);

        return PAGE_EXISTS;
    }
}
