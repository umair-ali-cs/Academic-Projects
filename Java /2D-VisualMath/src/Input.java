import java.awt.*;
import javax.swing.*;

public class Input extends JTextField {

    Input(int x, int y, int width, int height) {
        setBounds(x, y, width, height);
        setFont(new Font("Calibri", Font.PLAIN, 22));
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);
    }
}
