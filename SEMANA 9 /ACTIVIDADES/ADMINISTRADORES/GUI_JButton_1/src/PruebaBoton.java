import javax.swing.JFrame;

public class PruebaBoton {
    public static void main(String[] args) {
        MarcoBoton ventana = new MarcoBoton();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(700, 240);
        ventana.setVisible(true);
    }
}
