import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class SecondInterface extends JPanel implements MouseListener {

    Box textfields, lists; // Panels
    Label Title, fname, lname, id, dept, sem, type; // Labels
    Input fnameInput, lnameInput, idInput; // TextFields
    DropDownLists deptList, semList, typeList; // ComboBoxes
    Button contBtn, back; // Buttons
    Logo siba;

    SecondInterface() {
        String departments[] = { "Computer Science", "Software Engineering", "Artificial Intelligence",
                "Accounting and Finance", "Business Administration", "Education", "Media and Communication",
                "Mathematics", "Electrical Engineering" };
        int semesters[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        String transcriptypes[] = { "Grades", "Marks" };

        setBackground(Color.WHITE);
        setLayout(null);
        setPreferredSize(new Dimension(1000, 690));
        // setBorder(BorderFactory.createLineBorder(new Color(46, 48, 145), 3));

        siba = new Logo(20, 20, 150, 160);
        add(siba);

        Title = new Label("INSERT DATA", 430, 50);
        Title.setFont(new Font("Calibri", Font.BOLD, 30));
        add(Title);

        textfields = new Box(40, 200, 450, 350, Color.white);
        lists = new Box(510, 200, 450, 350, Color.white);
        add(textfields);
        add(lists);

        fname = new Label("FIRST NAME", 10, 20);
        fnameInput = new Input(10, 60);
        fnameInput.setText("");
        textfields.add(fname);
        textfields.add(fnameInput);

        lname = new Label("LAST NAME", 10, 120);
        lnameInput = new Input(10, 160);
        lnameInput.setText("");
        textfields.add(lname);
        textfields.add(lnameInput);

        idInput = new Input(10, 260);
        idInput.setText("");
        id = new Label("CMS-ID", 10, 220);
        textfields.add(id);
        textfields.add(idInput);

        dept = new Label("DEGREE PROGRAM", 10, 20);
        deptList = new DropDownLists(10, 60, departments);
        lists.add(dept);
        lists.add(deptList);

        sem = new Label("SEMESTER", 10, 120);
        semList = new DropDownLists(10, 160, semesters);
        lists.add(sem);
        lists.add(semList);

        type = new Label("TRANSCRIPT TYPE", 10, 220);
        typeList = new DropDownLists(10, 260, transcriptypes);
        lists.add(type);
        lists.add(typeList);

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
