package graficos;
import javax.swing.*;
import java.awt.*;

public class AppGraficos extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int[] xTri = {40, 100, 10};
        int[] yTri = {30, 120, 120};
        g.setColor(Color.RED);
        g.fillPolygon(xTri, yTri, 3);


        int[] xRombo = {160, 200, 160, 120};
        int[] yRombo = {40, 80, 120, 80};
        g.setColor(Color.BLUE);
        g.fillPolygon(xRombo, yRombo, 4);


        g.setColor(Color.GREEN);
        g.drawLine(40, 160, 80, 180);
        g.drawLine(80, 180, 40, 200);
        g.drawLine(40, 200, 80, 220);

        g.setColor(Color.MAGENTA);
        g.drawArc(150, 150, 100, 80, 0, 180);


        g.setColor(Color.BLACK);
        g.drawString("Gráficos simples", 120, 260);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gráficos Simples");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 330);
        frame.add(new AppGraficos());
        frame.setVisible(true);
    }
}


