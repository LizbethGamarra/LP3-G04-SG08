package binding;

import javax.swing.*;
import java.awt.event.*;

public class BindingApp {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo de Binding de Datos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 250);

        Persona persona = new Persona("John Doe", 30, "Masculino");

        JTextField nombreField = new JTextField(persona.getNombre(), 15);
        JTextField edadField = new JTextField(String.valueOf(persona.getEdad()), 15);
        JTextField sexoField = new JTextField(persona.getSexo(), 15);
        JButton button = new JButton("Actualizar Modelo");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                persona.setNombre(nombreField.getText());

                try {
                    persona.setEdad(Integer.parseInt(edadField.getText()));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Edad inválida");
                }

                persona.setSexo(sexoField.getText());

                System.out.println("Modelo actualizado:");
                System.out.println("Nombre: " + persona.getNombre());
                System.out.println("Edad: " + persona.getEdad());
                System.out.println("Sexo: " + persona.getSexo());
            }
        });

        frame.setLayout(new java.awt.FlowLayout());
        frame.add(new JLabel("Nombre: "));
        frame.add(nombreField);
        frame.add(new JLabel("Edad: "));
        frame.add(edadField);
        frame.add(new JLabel("Sexo: "));
        frame.add(sexoField);
        frame.add(button);

        frame.setVisible(true);
    }
}
