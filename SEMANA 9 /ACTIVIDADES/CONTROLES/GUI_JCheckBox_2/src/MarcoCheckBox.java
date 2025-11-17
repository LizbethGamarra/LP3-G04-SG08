import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class MarcoCheckBox extends JFrame {

    private JTextField campoTexto;
    private JCheckBox negrita;
    private JCheckBox cursiva;

    public MarcoCheckBox() {
        super("Gamarra - Ostolaza");
        setLayout(new FlowLayout());

        campoTexto = new JTextField("Prueba de JCheckBox", 20);
        campoTexto.setFont(new Font("Serif", Font.PLAIN, 14));
        add(campoTexto);

        negrita = new JCheckBox("Negrita");
        cursiva = new JCheckBox("Cursiva");

        add(negrita);
        add(cursiva);

        ItemListener manejador = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int estilo = Font.PLAIN;

                if (negrita.isSelected()) estilo += Font.BOLD;
                if (cursiva.isSelected()) estilo += Font.ITALIC;

                campoTexto.setFont(new Font("Serif", estilo, 14));
            }
        };

        negrita.addItemListener(manejador);
        cursiva.addItemListener(manejador);
    }
}
