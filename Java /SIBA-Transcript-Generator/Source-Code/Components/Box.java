import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Box extends JPanel {
    Box(int x, int y, int width, int height, Color color) {
        setLayout(null);
        setBounds(x, y, width, height);
        setBorder(BorderFactory.createLineBorder(color, 2));
        setBackground(Color.white);
    }
}
