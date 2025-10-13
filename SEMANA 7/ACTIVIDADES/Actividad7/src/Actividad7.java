import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.io.IOException;

public class Actividad7 extends JFrame {

    private JTextArea areaInfo;

    public Actividad7() {
        setTitle("Visor de Información de Archivos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JButton btnSeleccionar = new JButton("Seleccionar Archivo o Directorio");
        areaInfo = new JTextArea();
        areaInfo.setEditable(false);

        add(btnSeleccionar, BorderLayout.NORTH);
        add(new JScrollPane(areaInfo), BorderLayout.CENTER);

        btnSeleccionar.addActionListener(e -> seleccionarArchivo());
    }

    private void seleccionarArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        int resultado = fileChooser.showOpenDialog(this);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            mostrarInformacion(archivo.toPath());
        } else {
            areaInfo.setText("No se seleccionó ningún archivo o directorio.");
        }
    }

    private void mostrarInformacion(Path ruta) {
        StringBuilder info = new StringBuilder();
        try {
            info.append("Nombre: ").append(ruta.getFileName()).append("\n");
            info.append("Ruta absoluta: ").append(ruta.toAbsolutePath()).append("\n");
            info.append("¿Es directorio?: ").append(Files.isDirectory(ruta)).append("\n");
            info.append("¿Es archivo?: ").append(Files.isRegularFile(ruta)).append("\n");
            info.append("Última modificación: ").append(Files.getLastModifiedTime(ruta)).append("\n");

            if (Files.isRegularFile(ruta)) {
                info.append("Tamaño (bytes): ").append(Files.size(ruta)).append("\n");
            }

            if (Files.isDirectory(ruta)) {
                info.append("\nContenido del directorio:\n");
                try (DirectoryStream<Path> stream = Files.newDirectoryStream(ruta)) {
                    for (Path p : stream) {
                        info.append(" - ").append(p.getFileName()).append("\n");
                    }
                }
            }

        } catch (IOException e) {
            info.append("\nError al obtener la información: ").append(e.getMessage());
        }

        areaInfo.setText(info.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Actividad7().setVisible(true);
        });
    }
}
