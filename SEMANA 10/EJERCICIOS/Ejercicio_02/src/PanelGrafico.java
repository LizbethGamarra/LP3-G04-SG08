import javax.swing.*;
import java.awt.*;

public class PanelGrafico extends JPanel {

    private int[] temperaturas;

    public PanelGrafico() {
        temperaturas = null;
    }

    public void setTemperaturas(int[] temperaturas) {
        this.temperaturas = temperaturas;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (temperaturas == null)
            return;

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int ancho = getWidth();
        int alto = getHeight();
        int margen = 50;

        // Ejes
        g2.drawLine(margen, alto - margen, ancho - margen, alto - margen); // Eje X
        g2.drawLine(margen, margen, margen, alto - margen);               // Eje Y

        int dias = temperaturas.length;
        int espacio = (ancho - 2 * margen) / (dias - 1);

        int max = 0;
        for (int t : temperaturas)
            if (t > max) max = t;

        String[] etiquetasDias = {"L", "M", "M", "J", "V", "S", "D"};

        g2.setStroke(new BasicStroke(2));

        for (int i = 0; i < dias; i++) {

            int x = margen + i * espacio;
            int y = alto - margen - (temperaturas[i] * (alto - 2 * margen) / max);

            if (i > 0) {
                int xPrev = margen + (i - 1) * espacio;
                int yPrev = alto - margen - (temperaturas[i - 1] * (alto - 2 * margen) / max);
                g2.drawLine(xPrev, yPrev, x, y);
            }

            g2.setColor(Color.BLUE);
            g2.fillOval(x - 4, y - 4, 8, 8);

            g2.setColor(Color.BLACK);
            g2.drawString(String.valueOf(temperaturas[i]), x - 8, y - 10);

            g2.drawString(etiquetasDias[i], x - 5, alto - margen + 20);
        }
    }
}

