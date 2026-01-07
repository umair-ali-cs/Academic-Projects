import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MainLogo extends JLabel {
    ImageIcon SIBAlogo;
    Image scaledImage;

    MainLogo() {
        SIBAlogo = new ImageIcon("images/IBAlogo.png");
        scaledImage = SIBAlogo.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        SIBAlogo = new ImageIcon(scaledImage);
        
        this.setLayout(new FlowLayout());
        this.setBounds(250, 10, 500, 500);
        this.setBackground(Color.BLACK);
        // this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        this.setIcon(SIBAlogo);
        this.setText("TRANSCRIPT GENERATOR");
        this.setIconTextGap(-70);
        this.setHorizontalTextPosition(JLabel.CENTER);
        this.setVerticalTextPosition(JLabel.BOTTOM);
        this.setForeground(new Color(46, 48, 145));
        this.setFont(new Font("Bahnschrift", Font.PLAIN, 40));
    }
}
