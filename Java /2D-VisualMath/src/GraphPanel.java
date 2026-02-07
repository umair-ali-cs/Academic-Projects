import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.*;
import net.objecthunter.exp4j.*;

public class GraphPanel extends JPanel {
    int boxSize;
    int width = 800;
    int height = 600;
    int scalingMultiplier = 1;

    static class Equation {
        String expr;
        Color color;

        Equation(String expr, Color color) {
            this.expr = expr;
            this.color = color;
        }
    }

    java.util.List<Equation> equations = new ArrayList<>();

    GraphPanel(int boxSize) {
        this.boxSize = boxSize;
        setPreferredSize(new Dimension(width, height)); // panel size fixed
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        // Enable smoothing
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

        // Background
        g2.setColor(new Color(215,215,215));
        g2.fillRect(0, 0, width, height);

        drawGrid(g2, boxSize);

        // Plot all equations
        for (Equation eq : equations) {
            plotEquation(g2, eq.expr, eq.color);
        }
    }

    public void drawGrid(Graphics2D g2, int boxSize) {

        // Each unit = 2 boxes * scaling
        int pixelsPerUnit = boxSize * 2 * scalingMultiplier;

        // Light grid
        g2.setColor(new Color(190,190,190));
        for (int x = 0; x <= width; x += boxSize)
            g2.drawLine(x, 0, x, height);
        for (int y = 0; y <= height; y += boxSize)
            g2.drawLine(0, y, width, y);

        // Axes
        int originX = width / 2;
        int originY = height / 2;

        g2.setColor(Color.BLACK);
        g2.drawLine(originX, 0, originX, height); // Y-axis
        g2.drawLine(0, originY, width, originY); // X-axis

        // Axis labels
        g2.setFont(g2.getFont().deriveFont(12f));

        // X-axis positive
        for (int x = originX + pixelsPerUnit, val = 1; x < width; x += pixelsPerUnit, val++)
            g2.drawString(String.valueOf(val), x - 5, originY + 14);

        // X-axis negative
        for (int x = originX - pixelsPerUnit, val = -1; x > 0; x -= pixelsPerUnit, val--)
            g2.drawString(String.valueOf(val), x - 8, originY + 14);

        // Y-axis positive (up)
        for (int y = originY - pixelsPerUnit, val = 1; y > 0; y -= pixelsPerUnit, val++)
            g2.drawString(String.valueOf(val), originX + 6, y + 4);

        // Y-axis negative (down)
        for (int y = originY + pixelsPerUnit, val = -1; y < height; y += pixelsPerUnit, val--)
            g2.drawString(String.valueOf(val), originX + 6, y + 4);

        // Origin label
        g2.setColor(Color.RED);
        g2.drawString("(0,0)", originX + 6, originY - 6);
    }

   private void plotEquation(Graphics2D g2, String eq, Color c) {
    try {
        Expression e = new ExpressionBuilder(eq).variable("x").build();

        g2.setColor(c);
        g2.setStroke(new BasicStroke(2f)); // smoother line

        int originX = width / 2;
        int originY = height / 2;

        double pixelsPerUnit = boxSize * 2.0 * scalingMultiplier;
        double maxX = width / 2.0 / pixelsPerUnit;   // half screen in math units
        double step = 1.0 / pixelsPerUnit;           // one pixel in math units

        Double prevSX = null, prevSY = null;

        for (double x = -maxX; x <= maxX; x += step) {
            e.setVariable("x", x);
            double y;

            try {
                y = e.evaluate();
            } catch (ArithmeticException ex) {
                prevSX = prevSY = null; // reset at division by zero, etc
                continue;
            }

            if (!Double.isFinite(y) || Math.abs(y) > 1e6) {
                prevSX = prevSY = null; // reset at vertical asymptotes
                continue;
            }

            double sx = originX + x * pixelsPerUnit;
            double sy = originY - y * pixelsPerUnit;

            // Detect large jumps (asymptotes) to break line
            if (prevSY != null && Math.abs(sy - prevSY) > height) {
                prevSX = prevSY = null;
            }

            if (prevSX != null && prevSY != null) {
                g2.draw(new Line2D.Double(prevSX, prevSY, sx, sy));
            }

            prevSX = sx;
            prevSY = sy;
        }

    } catch (Exception ex) {
        System.err.println("Failed to plot: " + eq + " -> " + ex.getMessage());
    }
}
 
    public void addEquation(String expr, Color c) {
        equations.add(new Equation(expr, c));
        repaint();
    }

    public void removeEquation(String expr) {
        equations.removeIf(e -> e.expr.equals(expr));
        repaint();
    }

    public void zoomIn() {
        if (scalingMultiplier < 8) {
            scalingMultiplier *= 2;
            repaint();
        }
    }

    public void zoomOut() {
        if (scalingMultiplier > 1) {
            scalingMultiplier /= 2;
            repaint();
        }
    }
}
