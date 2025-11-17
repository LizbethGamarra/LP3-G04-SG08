import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Marco_Pasaje extends JFrame {

    private JTextField txtNombre, txtDNI, txtFecha;
    private JComboBox<String> cmbOrigen, cmbDestino;
    private JRadioButton rbPrimerPiso, rbSegundoPiso;
    private JCheckBox cbAudifonos, cbManta, cbRevistas;
    private JList<String> listServicio;
    private JButton btnComprar, btnReiniciar;

    public Marco_Pasaje() {

        super("Compra de Pasajes - Swing");

        JPanel panel = new JPanel(new GridLayout(9, 2, 10, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 25, 20, 25)); // márgenes externos
        add(panel);

        // Campos de texto
        panel.add(new JLabel("Nombre completo:"));
        txtNombre = new JTextField();
        panel.add(txtNombre);

        panel.add(new JLabel("DNI:"));
        txtDNI = new JTextField();
        panel.add(txtDNI);

        panel.add(new JLabel("Fecha de viaje:"));
        txtFecha = new JTextField("dd/mm/yyyy");
        panel.add(txtFecha);

        // Combobox orign y destino
        panel.add(new JLabel("Lugar de origen:"));
        cmbOrigen = new JComboBox<>(new String[]{"Arequipa", "Lima", "Cusco", "Tacna"});
        panel.add(cmbOrigen);

        panel.add(new JLabel("Lugar de destino:"));
        cmbDestino = new JComboBox<>(new String[]{"Arequipa", "Lima", "Cusco", "Tacna"});
        panel.add(cmbDestino);

        // radio buttons pisos del bus
        panel.add(new JLabel("Piso del bus:"));
        JPanel panelPiso = new JPanel();
        rbPrimerPiso = new JRadioButton("1er Piso");
        rbSegundoPiso = new JRadioButton("2do Piso");
        ButtonGroup grupoPisos = new ButtonGroup();
        grupoPisos.add(rbPrimerPiso);
        grupoPisos.add(rbSegundoPiso);
        panelPiso.add(rbPrimerPiso);
        panelPiso.add(rbSegundoPiso);
        panel.add(panelPiso);

        // checkbox adicionales
        panel.add(new JLabel("Servicios opcionales:"));
        JPanel panelServicios = new JPanel();
        cbAudifonos = new JCheckBox("Audífonos");
        cbManta = new JCheckBox("Manta");
        cbRevistas = new JCheckBox("Revistas");
        panelServicios.add(cbAudifonos);
        panelServicios.add(cbManta);
        panelServicios.add(cbRevistas);
        panel.add(panelServicios);


        // jlist calidad de servicio
        panel.add(new JLabel("Calidad de servicio:"));

        listServicio = new JList<>(new String[]{"Económico", "Standard", "VIP"});
        listServicio.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scroll = new JScrollPane(listServicio);
        scroll.setPreferredSize(new Dimension(100, 60));
        panel.add(scroll);

        btnComprar = new JButton("Comprar");
        btnReiniciar = new JButton("Reiniciar");
        panel.add(btnComprar);
        panel.add(btnReiniciar);

        btnComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String servicios = "";
                if (cbAudifonos.isSelected()) servicios += "Audífonos ";
                if (cbManta.isSelected()) servicios += "Manta ";
                if (cbRevistas.isSelected()) servicios += "Revistas ";

                String piso = rbPrimerPiso.isSelected() ? "1er Piso" :
                              rbSegundoPiso.isSelected() ? "2do Piso" :
                              "No seleccionado";

                String calidad = listServicio.getSelectedValue();

                String resumen = "----- RESUMEN DE COMPRA -----\n\n"
                        + "Nombre: " + txtNombre.getText() + "\n"
                        + "DNI: " + txtDNI.getText() + "\n"
                        + "Fecha: " + txtFecha.getText() + "\n"
                        + "Origen: " + cmbOrigen.getSelectedItem() + "\n"
                        + "Destino: " + cmbDestino.getSelectedItem() + "\n"
                        + "Piso: " + piso + "\n"
                        + "Servicios adicionales: " + servicios + "\n"
                        + "Servicio: " + calidad;

                JOptionPane.showMessageDialog(null, resumen, "Compra Realizada",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        btnReiniciar.addActionListener(e -> {
            txtNombre.setText("");
            txtDNI.setText("");
            txtFecha.setText("");
            cmbOrigen.setSelectedIndex(0);
            cmbDestino.setSelectedIndex(0);
            rbPrimerPiso.setSelected(false);
            rbSegundoPiso.setSelected(false);
            cbAudifonos.setSelected(false);
            cbManta.setSelected(false);
            cbRevistas.setSelected(false);
            listServicio.clearSelection();
        });

        setSize(600, 430);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
