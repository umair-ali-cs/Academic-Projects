import javax.swing.*;
import java.awt.*;

public class Label extends JLabel {

    Label(String str, int x, int y, int width, int height) {
        setText(str);
        setBounds(x, y, width, height);
        setFont(new Font("Calibri", Font.BOLD, 20));
        setForeground(Color.BLACK);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    }

}
