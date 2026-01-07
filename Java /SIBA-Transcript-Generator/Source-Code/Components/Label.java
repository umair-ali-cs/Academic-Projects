import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

public class Label extends JLabel {

    Label(String str, int x, int y) {
        setText(str);
        setBounds(x, y, 450, 50);
        setFont(new Font("Calibri", Font.BOLD, 20));
        setForeground(new Color(0, 0, 0));
    }

}
