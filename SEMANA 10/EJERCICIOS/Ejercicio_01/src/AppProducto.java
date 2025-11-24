import javax.swing.*;
import java.awt.*;

public class AppProducto {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Gestión de Producto");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 350);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Producto producto = new Producto("Sin nombre", 0.0, 0, "Ninguna");

        JTextField txtNombre = new JTextField(15);
        JTextField txtPrecio = new JTextField(15);
        JTextField txtStock = new JTextField(15);
        JTextField txtCategoria = new JTextField(15);

        JButton btnActualizar = new JButton("Actualizar Producto");
        JLabel lblResultado = new JLabel("");

        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Nombre:"), gbc);

        gbc.gridx = 1; 
        panel.add(txtNombre, gbc);

        gbc.gridx = 2; 
        panel.add(new JLabel("Precio:"), gbc);

        gbc.gridx = 3; 
        panel.add(txtPrecio, gbc);


        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Cantidad Stock:"), gbc);

        gbc.gridx = 1; 
        panel.add(txtStock, gbc);

        gbc.gridx = 2; 
        panel.add(new JLabel("Categoría:"), gbc);

        gbc.gridx = 3; 
        panel.add(txtCategoria, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(btnActualizar, gbc);

        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(lblResultado, gbc);

        btnActualizar.addActionListener(e -> {
            try {
                producto.setNombre(txtNombre.getText());
                producto.setPrecio(Double.parseDouble(txtPrecio.getText()));
                producto.setCantidadStock(Integer.parseInt(txtStock.getText()));
                producto.setCategoria(txtCategoria.getText());

                String info = "<html>"
                        + "<b>Producto actualizado:</b><br>"
                        + "Nombre: " + producto.getNombre() + "<br>"
                        + "Precio: " + producto.getPrecio() + "<br>"
                        + "Stock: " + producto.getCantidadStock() + "<br>"
                        + "Categoría: " + producto.getCategoria() + "</html>";

                lblResultado.setText(info);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Precio y Stock deben ser numéricos.");
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}

