import javax.swing.*;
import java.awt.*;

public class AppTemperaturas {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Gráfico de Temperaturas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);
        frame.setLayout(new BorderLayout());

        JPanel panelInputs = new JPanel(new GridLayout(2, 7, 10, 5));

        String[] dias = {"Lunes", "Martes", "Miérc.", "Jueves", "Viernes", "Sábado", "Domingo"};
        JTextField[] campos = new JTextField[7];

        for (int i = 0; i < 7; i++) {
            JLabel lbl = new JLabel(dias[i], SwingConstants.CENTER);
            lbl.setFont(new Font("Arial", Font.BOLD, 13));
            panelInputs.add(lbl);
        }

        for (int i = 0; i < 7; i++) {
            campos[i] = new JTextField();
            panelInputs.add(campos[i]);
        }

        PanelGrafico panelGrafico = new PanelGrafico();

        JButton btnMostrar = new JButton("Mostrar Gráfico");
        btnMostrar.setFont(new Font("Arial", Font.BOLD, 14));

        btnMostrar.addActionListener(e -> {
            try {
                int[] temperaturas = new int[7];
                for (int i = 0; i < 7; i++) {
                    temperaturas[i] = Integer.parseInt(campos[i].getText());
                }

                panelGrafico.setTemperaturas(temperaturas);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame,
                        "Ingrese SOLO números enteros en todos los campos.");
            }
        });

        frame.add(panelInputs, BorderLayout.NORTH);
        frame.add(panelGrafico, BorderLayout.CENTER);
        frame.add(btnMostrar, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}

