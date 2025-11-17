import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class MarcoRadioButton extends JFrame {

    private final JTextField campoTexto;
    private final JRadioButton simple;
    private final JRadioButton negrita;
    private final JRadioButton cursiva;
    private final JRadioButton negritaCursiva;

    public MarcoRadioButton() {
        super("Gamarra - Ostolaza");
        setLayout(new FlowLayout());

        campoTexto = new JTextField("Prueba de JRadioButton", 25);
        campoTexto.setFont(new Font("Serif", Font.PLAIN, 14));
        add(campoTexto);

        simple = new JRadioButton("Simple", true);
        negrita = new JRadioButton("Negrita");
        cursiva = new JRadioButton("Cursiva");
        negritaCursiva = new JRadioButton("Negrita/Cursiva");

        add(simple);
        add(negrita);
        add(cursiva);
        add(negritaCursiva);

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(simple);
        grupo.add(negrita);
        grupo.add(cursiva);
        grupo.add(negritaCursiva);

        simple.addItemListener(e -> campoTexto.setFont(new Font("Serif", Font.PLAIN, 14)));
        negrita.addItemListener(e -> campoTexto.setFont(new Font("Serif", Font.BOLD, 14)));
        cursiva.addItemListener(e -> campoTexto.setFont(new Font("Serif", Font.ITALIC, 14)));
        negritaCursiva.addItemListener(e -> campoTexto.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 14)));
    }
}
