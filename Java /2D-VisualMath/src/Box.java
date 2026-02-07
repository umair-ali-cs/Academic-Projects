import javax.swing.*;
import java.awt.*;

public class Box extends JPanel {
    float x_Cordinate;
    float y_Cordinate;

    Box(int x, int y, int width, int height, Color c) {
        setLayout(null);
        setBounds(x, y, width, height);
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(c, 1));
    }

}
