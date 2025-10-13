import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;

public class Actividad4 extends JFrame {

    private JTextArea textArea;

    public Actividad4() {
        setTitle("Visualizador de Archivo");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textArea = new JTextArea();
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        leerArchivo("TestFile.txt"); 
    }

    private void leerArchivo(String nombreArchivo) {
        try (FileInputStream fis = new FileInputStream(nombreArchivo)) {
            int caracter;
            while ((caracter = fis.read()) != -1) {
                textArea.append(String.valueOf((char) caracter));
            }
        } catch (IOException e) {
            textArea.setText("Error al leer el archivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Actividad4().setVisible(true);
        });
    }
}
