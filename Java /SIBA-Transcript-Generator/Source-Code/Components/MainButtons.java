import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MainButtons extends JButton {
    ImageIcon icon;
    Image scaledIcon;

    MainButtons(String Text, int x, int y, String address, int height, int width) {
        icon = new ImageIcon(address);
        scaledIcon = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaledIcon);

        setText(Text);
        setBounds(x, y, 130, 130);
        setIcon(icon);
        setFocusable(false);
        setBorder(BorderFactory.createLineBorder(new Color(46, 48, 145),3));
        setBackground(Color.WHITE);
        setFont(new Font("Calibri", Font.BOLD, 20));
        setForeground(new Color(46, 48, 145));

        setVerticalTextPosition(JButton.BOTTOM);
        setHorizontalTextPosition(JButton.CENTER);

    }
}
