package graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.geom.Line2D;

public class AppGraficos2D extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


        Path2D estrella = new Path2D.Double();
        estrella.moveTo(100, 20);
        estrella.lineTo(120, 70);
        estrella.lineTo(180, 70);
        estrella.lineTo(135, 100);
        estrella.lineTo(150, 150);
        estrella.lineTo(100, 120);
        estrella.lineTo(50, 150);
        estrella.lineTo(65, 100);
        estrella.lineTo(20, 70);
        estrella.lineTo(80, 70);
        estrella.closePath();

        g2.setColor(new Color(255, 200, 0));
        g2.fill(estrella);


        Path2D rayo = new Path2D.Double();
        rayo.moveTo(250, 20);
        rayo.lineTo(230, 80);
        rayo.lineTo(270, 80);
        rayo.lineTo(240, 150);
        rayo.lineTo(310, 90);
        rayo.lineTo(260, 90);
        rayo.closePath();

        g2.setColor(Color.YELLOW);
        g2.fill(rayo);

        
        Path2D corazon = new Path2D.Double();
        corazon.moveTo(150, 200);
        corazon.curveTo(130, 170, 80, 170, 80, 210);
        corazon.curveTo(80, 250, 150, 280, 150, 320);
        corazon.curveTo(150, 280, 220, 250, 220, 210);
        corazon.curveTo(220, 170, 170, 170, 150, 200);

        g2.setColor(Color.PINK);
        g2.fill(corazon);

   

        Path2D poligono = new Path2D.Double();
        poligono.moveTo(300, 330);
        poligono.lineTo(340, 350);
        poligono.lineTo(380, 340);
        poligono.lineTo(400, 380);
        poligono.lineTo(350, 410);
        poligono.lineTo(310, 380);
        poligono.closePath();

        g2.setColor(new Color(120, 200, 120));
        g2.fill(poligono);

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("GráficoS)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 550);
        frame.add(new AppGraficos2D());
        frame.setVisible(true);
    }
}

