import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class MarcoBoton extends JFrame {

    private final JButton botonSimple;
    private final JButton botonElegante;

    public MarcoBoton() {
        super("Gamarra - Ostolaza");
        setLayout(new FlowLayout());

        botonSimple = new JButton("Botón simple");
        add(botonSimple);

        Icon icon1 = new ImageIcon(getClass().getResource("insecto1.gif"));
        Icon icon2 = new ImageIcon(getClass().getResource("insecto2.gif"));

        botonElegante = new JButton("Botón elegante", icon1);
        botonElegante.setRolloverIcon(icon2);

        add(botonElegante);

        ActionListener manejador = e ->
            JOptionPane.showMessageDialog(
                MarcoBoton.this,
                "Usted presionó: " + e.getActionCommand()
            );

        botonSimple.addActionListener(manejador);
        botonElegante.addActionListener(manejador);
    }
}
