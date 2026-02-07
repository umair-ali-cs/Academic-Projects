import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.html.HTMLDocument.HTMLReader.BlockAction;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import net.objecthunter.exp4j.*;

public class Frame extends JFrame implements ActionListener {
    // A panel with BorderLayout
    JPanel background = new JPanel();
    JPanel fInterface = new JPanel();

    // Interface components
    Label mainLogo1, mainLogo2;
    Img graphsImg;
    Button start;

    // Equation Pane Variables
    Box equationPane, equation[];
    Button showHideToggler[], delete[], add;
    Input equationInput[];
    int equationCount = -1, equationYOffset = 0;

    // Cartesian Plane Variables
    GraphPanel graphPanel;
    Button zoomIn, zoomOut;

    // Supporting variables for Action Performing
    Random rand = new Random();
    Color borderColor, mainBG, innerBG, fontColor;

    Frame() {
        // setting The Frame

        // FavIcon
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("assets/icon.png"));
                setIconImage(icon);
        this.setTitle("2-Dimensional VisualMath");

        // Layout 
        this.setLayout(new BorderLayout());
        this.setSize(1340, 720);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Theme Colors
        borderColor = new Color(80, 80, 129);
        mainBG = new Color(5, 4, 31);
        innerBG = new Color(9, 9, 37);
        fontColor = new Color(134, 134, 172);

        // Front Interface
        fInterface = new JPanel();
        fInterface.setLayout(null);
        fInterface.setBorder(BorderFactory.createLineBorder(borderColor, 2));
        fInterface.setBackground(mainBG);

        graphsImg = new Img(1000, 20, 300, 300, "assets/img.jpg", borderColor);
        fInterface.add(graphsImg);

        mainLogo1 = new Label("2D", 170, 130, 1000, 400);
        mainLogo1.setFont(new Font("Bauhaus 93", Font.BOLD, 250));
        mainLogo1.setForeground(fontColor);
        mainLogo1.setBorder(BorderFactory.createLineBorder(mainBG, 2));
        fInterface.add(mainLogo1);

        mainLogo2 = new Label(" VisualMath", 155, 330, 1050, 300);
        mainLogo2.setFont(new Font("Bauhaus 93", Font.BOLD, 180));
        mainLogo2.setForeground(fontColor);
        mainLogo2.setBorder(BorderFactory.createLineBorder(null, 0));
        fInterface.add(mainLogo2);

        start = new Button("Open Graphing Calculator", 820, 550, 300, 50, this, 2);
        start.setBorder(BorderFactory.createLineBorder(borderColor, 2));
        start.setForeground(fontColor);
        start.setBackground(innerBG);
        fInterface.add(start);

        // Second Interface
        background = new JPanel();
        background.setLayout(null);
        background.setBackground(mainBG);
        background.setBorder(BorderFactory.createLineBorder(borderColor, 2));

        int noOfEq = 10;
        equation = new Box[noOfEq];
        delete = new Button[noOfEq];
        equationInput = new Input[noOfEq];
        showHideToggler = new Button[noOfEq];

        equationPane = new Box(30, 40, 400, 610, borderColor);
        equationPane.setBorder(BorderFactory.createLineBorder(borderColor, 2));
        equationPane.setBackground(innerBG);
        background.add(equationPane);

        add = new Button("+", 350, equationYOffset + 10, 40, 40, this, 2);
        add.setForeground(Color.WHITE);
        add.setBackground(new Color(40, 160, 40));
        add.setBorder(BorderFactory.createLineBorder(new Color(30, 210, 40), 2));
        equationPane.add(add);

        graphPanel = new GraphPanel(20);
        graphPanel.setBounds(450, 45, 800, 600);
        graphPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(borderColor, 2),
                BorderFactory.createLineBorder(innerBG, 4)));
        background.add(graphPanel);

        zoomIn = new Button("Z-in", 1255, 45, 50, 40, this, 2);
        zoomIn.setFont(new Font("Calibri", Font.BOLD, 15));
        zoomIn.setBorder(BorderFactory.createLineBorder(borderColor, 2));
        zoomIn.setBackground(innerBG);
        zoomIn.setForeground(fontColor);
        background.add(zoomIn);

        zoomOut = new Button("Z-out", 1255, 90, 50, 40, this, 2);
        zoomOut.setFont(new Font("Calibri", Font.BOLD, 15));
        zoomOut.setBorder(BorderFactory.createLineBorder(borderColor, 2));
        zoomOut.setBackground(innerBG);
        zoomOut.setForeground(fontColor);
        background.add(zoomOut);

        this.add(fInterface);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // First Starting Button
        if (e.getSource().equals(start)) {
            fInterface.setVisible(false);
            add(background);
        }
        // Add Button Functionality
        else if (e.getSource().equals(add)) {
            if (equationCount == 9) {
                return;
            }

            ++equationCount;

            equation[equationCount] = new Box(2, equationYOffset + 5, 396, 58, innerBG);
            equation[equationCount].setBackground(innerBG);

            equationYOffset += 60;

            showHideToggler[equationCount] = new Button("Show", 5, 5, 70, 50, this, 0);
            showHideToggler[equationCount].setBackground(innerBG);
            showHideToggler[equationCount].setBorder(BorderFactory.createLineBorder(borderColor, 2));
            showHideToggler[equationCount].setForeground(fontColor);

            equationInput[equationCount] = new Input(80, 5, 271, 50);
            equationInput[equationCount].setFont(new Font("Cambria", Font.PLAIN, 22));
            equationInput[equationCount].setBackground(innerBG);
            equationInput[equationCount].setBorder(BorderFactory.createLineBorder(borderColor, 2));
            equationInput[equationCount].setForeground(fontColor);

            delete[equationCount] = new Button("x", 356, 15, 30, 30, this, 1);
            delete[equationCount].setBackground(new Color(160, 40, 40));
            delete[equationCount].setForeground(Color.WHITE);
            delete[equationCount].setBorder(BorderFactory.createLineBorder(new Color(216, 32, 39), 1));

            equation[equationCount].add(showHideToggler[equationCount]);
            equation[equationCount].add(equationInput[equationCount]);
            equation[equationCount].add(delete[equationCount]);
            equationPane.add(equation[equationCount]);

            add.setBounds(350, equationYOffset + 10, 40, 40);

            background.revalidate();
            background.repaint();
        }
        // Zoom In Functionality
        else if (e.getSource().equals(zoomIn)) {
            graphPanel.zoomIn();
        }
        // Zoom out Functionality
        else if (e.getSource().equals(zoomOut)) {
            graphPanel.zoomOut();
        }

        // Loops for Arrays of Buttons
        for (int i = 0; i <= equationCount; i++) {
            // delete Buttons Functionality
            if (delete[i] != null && e.getSource().equals(delete[i])) {
                String raw = unstyleEquation(equationInput[i].getText());
                graphPanel.removeEquation(raw);
                moveUpward(i);
                break;
            }

            // Show, Hide, Re-Write Button Functionality
            if (showHideToggler[i] != null && e.getSource().equals(showHideToggler[i])) {
                // Check if the equation available contains error
                if (showHideToggler[i].getText().equals("Re-Write")) {
                    equationInput[i].setText("");
                    equationInput[i].setEditable(true);
                    equationInput[i].setForeground(fontColor);
                    showHideToggler[i].setText("Show");
                    break;
                }

                // trying to Check if the text is a valid equation otherwise it will jump to
                try {
                    // If the toggler was pressed to show the graph of equation
                    if (showHideToggler[i].getText().equals("Show")) {
                        new ExpressionBuilder(equationInput[i].getText()).variable("x").build();
                        // Generate a random Color
                        int r = rand.nextInt(100) + 50;
                        int g = rand.nextInt(100) + 50;
                        int b = rand.nextInt(100) + 50;

                        Color c = new Color(r, g, b);

                        graphPanel.addEquation(equationInput[i].getText(), c);
                        equationInput[i].setText(styleEquation(equationInput[i].getText()));
                        equationInput[i].setEditable(false);
                        showHideToggler[i].setText("Hide");
                        showHideToggler[i].setForeground(c);
                        showHideToggler[i].setBorder(BorderFactory.createLineBorder(c, 4));
                    }
                    // If the toggler was pressed to hide the graph
                    else {
                        equationInput[i].setEditable(true);
                        equationInput[i].setText(unstyleEquation(equationInput[i].getText()));
                        graphPanel.removeEquation(equationInput[i].getText());
                        showHideToggler[i].setText("Show");
                        showHideToggler[i].setForeground(fontColor);
                        showHideToggler[i].setBorder(BorderFactory.createLineBorder(borderColor, 2));
                    }
                }
                // catch block
                catch (Exception ex) {
                    showHideToggler[i].setText("Re-Write");
                    equationInput[i].setForeground(Color.RED);
                    equationInput[i].setText(equationInput[i].getText() + " -- Invalid");
                    equationInput[i].setEditable(false);
                }

                background.repaint();
                background.revalidate();
                break;
            }
        }

        background.repaint();
        background.revalidate();
    }

    // Used For Deletion
    public void moveUpward(int idx) {

        if (idx < 0 || idx > equationCount)
            return;

        if (equation[idx] != null) {
            equationPane.remove(equation[idx]);
        }

        for (int i = idx; i < equationCount; i++) {
            equation[i] = equation[i + 1];
            equationInput[i] = equationInput[i + 1];
            delete[i] = delete[i + 1];
            showHideToggler[i] = showHideToggler[i + 1];
        }

        equation[equationCount] = null;
        equationInput[equationCount] = null;
        delete[equationCount] = null;
        showHideToggler[equationCount] = null;

        equationCount--;

        equationYOffset = (equationCount + 1) * 60;
        equationPane.removeAll();

        int y = 5;
        for (int i = 0; i <= equationCount; i++) {
            if (equation[i] != null) {
                equation[i].setBounds(2, y, 396, 58);
                equationPane.add(equation[i]);
                y += 60;
            }
        }

        add.setBounds(350, y + 5, 40, 40);
        equationPane.add(add);

        equationPane.revalidate();
        equationPane.repaint();
    }

    // The method will Style the equation
    public String styleEquation(String eq) {

        // Special trig shortcuts
        if (eq.equals("1/tanx"))
            return "cotx";
        if (eq.equals("1/sinx"))
            return "cscx";
        if (eq.equals("1/cosx"))
            return "secx";

        Map<Character, String> sup = new HashMap<>();
        sup.put('0', "⁰");
        sup.put('1', "¹");
        sup.put('2', "²");
        sup.put('3', "³");
        sup.put('4', "⁴");
        sup.put('5', "⁵");
        sup.put('6', "⁶");
        sup.put('7', "⁷");
        sup.put('8', "⁸");
        sup.put('9', "⁹");
        sup.put('+', "⁺");
        sup.put('-', "⁻");
        sup.put('(', "⁽");
        sup.put(')', "⁾");
        sup.put('x', "ˣ"); // only exponent x, NOT base x

        StringBuilder out = new StringBuilder();
        int i = 0;

        while (i < eq.length()) {
            char c = eq.charAt(i);

            if (c == '^') {
                i++;
                StringBuilder exp = new StringBuilder();

                // read full exponent: digits, +, -, x, parentheses
                int parenCount = 0;
                while (i < eq.length()) {
                    char e = eq.charAt(i);

                    if (e == '(')
                        parenCount++;
                    if (e == ')')
                        parenCount--;

                    if (Character.isDigit(e) || e == '+' || e == '-' || e == 'x'
                            || e == '(' || e == ')') {
                        exp.append(e);
                        i++;
                        if (parenCount == 0 && (e != '(' && e != ')'))
                            break;
                    } else
                        break;
                }

                // convert exponent characters
                for (char e : exp.toString().toCharArray()) {
                    String s = sup.get(e);
                    out.append(s != null ? s : e);
                }
                continue;
            }

            out.append(c);
            i++;
        }
        return out.toString();
    }

    // The method will UnStyle the equation
    public String unstyleEquation(String styled) {

        if (styled.equals("cotx"))
            return "1/tanx";
        if (styled.equals("cscx"))
            return "1/sinx";
        if (styled.equals("secx"))
            return "1/cosx";

        Map<Character, Character> normal = new HashMap<>();
        normal.put('⁰', '0');
        normal.put('¹', '1');
        normal.put('²', '2');
        normal.put('³', '3');
        normal.put('⁴', '4');
        normal.put('⁵', '5');
        normal.put('⁶', '6');
        normal.put('⁷', '7');
        normal.put('⁸', '8');
        normal.put('⁹', '9');

        normal.put('⁺', '+');
        normal.put('⁻', '-');
        normal.put('⁽', '(');
        normal.put('⁾', ')');
        normal.put('ˣ', 'x');

        StringBuilder out = new StringBuilder();
        int i = 0;

        while (i < styled.length()) {
            char c = styled.charAt(i);

            if (normal.containsKey(c)) {
                out.append("^");

                StringBuilder exp = new StringBuilder();
                while (i < styled.length() && normal.containsKey(styled.charAt(i))) {
                    exp.append(normal.get(styled.charAt(i)));
                    i++;
                }

                // if exponent contains +, -, or multiple chars, wrap in parentheses
                if (exp.length() > 1 && !exp.toString().matches("[0-9x]")) {
                    out.append("(").append(exp).append(")");
                } else {
                    out.append(exp);
                }
                continue;
            }

            out.append(c);
            i++;
        }

        return out.toString();
    }
}
