import java.awt.*;
import javax.swing.*;

public class Img extends JLabel {
    ImageIcon img;
    Image scaledImage;

    Img(int x, int y, int width, int height, String imagePath, Color c) {
        img = new ImageIcon(imagePath);
        scaledImage = img.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        img = new ImageIcon(scaledImage);

        this.setLayout(new FlowLayout());
        this.setBounds(x, y, height, width);
        this.setBorder(BorderFactory.createLineBorder(c, 2));

        this.setIcon(img);
    }
}