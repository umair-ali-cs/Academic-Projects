import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;

public class DropDownLists extends JComboBox {
    @SuppressWarnings("unchecked")
    DropDownLists(int x, int y, String item[]) {
        for (int a = 0; a < item.length; a++) {
            addItem(item[a]);
        }
        setBounds(x, y, 430, 50);
        setFont(new Font("Calibri", Font.PLAIN, 20));
        setForeground(Color.BLACK);
        setBackground(Color.white);
        setBorder(BorderFactory.createLineBorder(new Color(46, 48, 145), 1));
    }
    
    @SuppressWarnings("unchecked")
    DropDownLists(int x, int y, int item[]) {
        for (int a = 0; a < item.length; a++) {
            addItem(item[a]);
        }
        setBounds(x, y, 430, 50);
        setFont(new Font("Calibri", Font.PLAIN, 20));
        setForeground(Color.BLACK);
        setBackground(Color.white);
        setBorder(BorderFactory.createLineBorder(new Color(46, 48, 145), 1));
    }

}
