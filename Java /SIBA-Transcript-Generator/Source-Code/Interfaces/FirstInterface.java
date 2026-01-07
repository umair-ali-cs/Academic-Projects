import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class FirstInterface extends JPanel {
    MainLogo logo = new MainLogo();
    MainButtons generate = new MainButtons("GENERATE", 435, 520, "images/GenerateIcon.png", 180, 120);

    FirstInterface() {
        setBackground(Color.WHITE);
        setLayout(null);
        setPreferredSize(new Dimension(1000, 690));
        add(logo);

        generate.setIconTextGap(-55);
        add(generate);
    }
}
