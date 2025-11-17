import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JOptionPane;
import java.awt.SystemColor;
import java.awt.Color;

public class Ejercicio1 extends JFrame {

    private JPanel contentPane;
    private JTextField txtNewTextField;
    private JTextField txtNewTextField_1;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
            	Ejercicio1 frame = new Ejercicio1();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Ejercicio1() {
        setTitle("UCSM - Registro Simple");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 420, 260);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("Nombre:");

        txtNewTextField = new JTextField();
        txtNewTextField.setBackground(new Color(255, 255, 255));
        txtNewTextField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Código:");

        txtNewTextField_1 = new JTextField();
        txtNewTextField_1.setBackground(new Color(212, 212, 212));
        txtNewTextField_1.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Escuela:");

        JComboBox comboBox = new JComboBox();
        comboBox.setBackground(new Color(128, 128, 255));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {
                "Ingeniería de Sistemas",
                "Ingeniería Civil",
                "Administración",
                "Contabilidad",
                "Derecho"
        }));

        JButton btnNewButton = new JButton("Registrar");
        btnNewButton.setBackground(new Color(255, 128, 64));

        btnNewButton.addActionListener(e -> {
            String nombre = txtNewTextField.getText();
            String codigo = txtNewTextField_1.getText();
            String escuela = comboBox.getSelectedItem().toString();

            JOptionPane.showMessageDialog(
                null,
                "Registro UCSM:\n\nNombre: " + nombre
                + "\nCódigo: " + codigo
                + "\nEscuela: " + escuela,
                "Registro Completado",
                JOptionPane.INFORMATION_MESSAGE
            );
        });

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(30)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblNewLabel)
                        .addComponent(lblNewLabel_1)
                        .addComponent(lblNewLabel_2))
                    .addGap(40)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                        .addComponent(txtNewTextField, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(txtNewTextField_1)
                        .addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(60, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(30)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblNewLabel)
                        .addComponent(txtNewTextField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                    .addGap(20)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblNewLabel_1)
                        .addComponent(txtNewTextField_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                    .addGap(20)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblNewLabel_2)
                        .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                    .addGap(30)
                    .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(40, Short.MAX_VALUE))
        );

        contentPane.setLayout(gl_contentPane);
    }
}

