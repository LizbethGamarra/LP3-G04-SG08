package graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class AppGraficos2D extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        AffineTransform original = g2.getTransform();

        g2.setColor(Color.GRAY);
        g2.fillRect(20, 20, 100, 50);

        g2.translate(150, 0);
        g2.setColor(Color.BLUE);
        g2.fillRect(20, 20, 100, 50);
        g2.setTransform(original);

        g2.translate(0, 120);
        g2.rotate(Math.toRadians(45), 70, 45);
        g2.setColor(Color.GREEN);
        g2.fillRect(20, 20, 100, 50);
        g2.setTransform(original);

        g2.translate(150, 120);
        g2.scale(1.5, 0.5);
        g2.setColor(Color.ORANGE);
        g2.fillRect(20, 20, 100, 50);
        g2.setTransform(original);

        g2.translate(0, 240);
        g2.shear(0.5, 0);
        g2.setColor(Color.MAGENTA);
        g2.fillRect(20, 20, 100, 50);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gráficos Avanzados");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 450);
        frame.add(new AppGraficos2D());
        frame.setVisible(true);
    }
}
