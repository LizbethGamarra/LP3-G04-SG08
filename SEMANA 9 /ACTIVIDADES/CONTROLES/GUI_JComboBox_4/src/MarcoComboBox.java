import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class MarcoComboBox extends JFrame {

    private final JComboBox<String> imagenesCombo;
    private final JLabel etiqueta;
    private final Icon[] iconos;

    public MarcoComboBox() {
        super("Gamarra - Ostolaza");
        setLayout(new FlowLayout());

        String nombres[] = {"Vehículo 1", "Vehículo 2"};
        String rutas[] = {"vehiculo1.gif", "vehiculo2.gif"};

        imagenesCombo = new JComboBox<>(nombres);
        add(imagenesCombo);

        iconos = new Icon[rutas.length];
        for (int i = 0; i < rutas.length; i++) {
            iconos[i] = new ImageIcon(getClass().getResource(rutas[i]));
        }

        etiqueta = new JLabel(iconos[0]);
        add(etiqueta);

        imagenesCombo.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    etiqueta.setIcon(iconos[imagenesCombo.getSelectedIndex()]);
                }
            }
        );
    }
}
