package binding;

import javax.swing.*;
import java.awt.*;

public class AppBinding {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Formulario Persona");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 250);
        frame.setLocationRelativeTo(null);

        Persona persona = new Persona("Luis Rodriguez", 24, "Masculino");

        JTextField nombreField = new JTextField(persona.getNombre(), 15);
        JTextField edadField = new JTextField(String.valueOf(persona.getEdad()), 15);
        JTextField sexoField = new JTextField(persona.getSexo(), 15);

        JButton btnGuardar = new JButton("Guardar");
        JButton btnLimpiar = new JButton("Limpiar");

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Nombre:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(nombreField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(new JLabel("Edad:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(edadField, gbc);

        // Sexo
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(new JLabel("Sexo:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(sexoField, gbc);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        panelBotones.add(btnGuardar);
        panelBotones.add(btnLimpiar);

        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(panelBotones, gbc);


        btnGuardar.addActionListener(e -> {
            persona.setNombre(nombreField.getText());

            try {
                persona.setEdad(Integer.parseInt(edadField.getText()));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Edad inválida");
            }

            persona.setSexo(sexoField.getText());

            JOptionPane.showMessageDialog(frame, "Datos guardados correctamente");

            System.out.println("Modelo actualizado:");
            System.out.println("Nombre: " + persona.getNombre());
            System.out.println("Edad: " + persona.getEdad());
            System.out.println("Sexo: " + persona.getSexo());
        });

        btnLimpiar.addActionListener(e -> {
            nombreField.setText("");
            edadField.setText("");
            sexoField.setText("");
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}


