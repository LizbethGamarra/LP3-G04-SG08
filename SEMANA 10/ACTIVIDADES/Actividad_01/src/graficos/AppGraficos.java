package graficos;

import javax.swing.*;
import java.awt.*;

public class AppGraficos extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLUE);
        g.drawLine(20, 20, 200, 20);

        g.setColor(Color.RED);
        g.drawRect(50, 50, 120, 60);

        g.setColor(Color.GREEN);
        g.fillOval(200, 100, 80, 80);

        g.setColor(Color.BLACK);
        g.drawString("Gráficos simples", 20, 180);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gráficos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 250);
        frame.add(new AppGraficos());
        frame.setVisible(true);
    }
}

