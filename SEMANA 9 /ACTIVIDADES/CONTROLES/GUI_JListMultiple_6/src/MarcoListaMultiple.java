import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class MarcoListaMultiple extends JFrame {

    private final JList<String> lista;
    private final JButton boton;

    public MarcoListaMultiple() {
        super("Gamarra - Ostolaza");
        setLayout(new FlowLayout());

        String opciones[] = {"Java", "Python", "C++", "Go", "Kotlin", "JavaScript"};

        lista = new JList<>(opciones);
        lista.setVisibleRowCount(4);
        lista.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        add(lista);

        boton = new JButton("Mostrar Selección");
        add(boton);

        boton.addActionListener(
            e -> {
                java.util.List<String> seleccion = lista.getSelectedValuesList();
                JOptionPane.showMessageDialog(this, "Seleccionó: " + seleccion);
            }
        );
    }
}
