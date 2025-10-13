import javax.swing.*;
import java.io.*;
import java.util.*;

public class Ejercicio4 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Ejercicio4::iniciarPrograma);
    }

    public static void iniciarPrograma() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecciona un archivo de texto (.txt)");
        int opcion = fileChooser.showOpenDialog(null);

        if (opcion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            procesarArchivo(archivo);
        } else {
            JOptionPane.showMessageDialog(null, "No se seleccionó ningún archivo.");
        }
    }

    public static void procesarArchivo(File archivo) {
        int lineas = 0;
        int palabras = 0;
        int caracteres = 0;
        Map<String, Integer> frecuencia = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                lineas++;
                caracteres += linea.replace("\n", "").length();

                String[] palabrasLinea = linea.split("\\W+");
                for (String palabra : palabrasLinea) {
                    if (!palabra.isEmpty()) {
                        palabras++;
                        String palabraLimpia = palabra.toLowerCase();
                        frecuencia.put(palabraLimpia, frecuencia.getOrDefault(palabraLimpia, 0) + 1);
                    }
                }
            }

            double promedio = (lineas > 0) ? (double) palabras / lineas : 0.0;

            List<Map.Entry<String, Integer>> listaFrecuencias = new ArrayList<>(frecuencia.entrySet());
            listaFrecuencias.sort((a, b) -> b.getValue() - a.getValue());

            StringBuilder resultado = new StringBuilder();
            resultado.append("Archivo: ").append(archivo.getName()).append("\n\n");
            resultado.append("Total de líneas: ").append(lineas).append("\n");
            resultado.append("Total de palabras: ").append(palabras).append("\n");
            resultado.append("Total de caracteres: ").append(caracteres).append("\n");
            resultado.append(String.format("Promedio de palabras por línea: %.2f\n\n", promedio));
            resultado.append("Palabras más frecuentes:\n");

            int contador = 0;
            for (Map.Entry<String, Integer> entrada : listaFrecuencias) {
                resultado.append("  ").append(entrada.getKey())
                         .append(" → ").append(entrada.getValue()).append(" veces\n");
                if (++contador == 10) break; 
            }

            JTextArea area = new JTextArea(resultado.toString());
            area.setEditable(false);
            area.setFont(new java.awt.Font("Consolas", java.awt.Font.PLAIN, 14));

            JScrollPane scroll = new JScrollPane(area);
            scroll.setPreferredSize(new java.awt.Dimension(600, 400));

            JOptionPane.showMessageDialog(null, scroll, "Resultados del análisis", JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo: " + e.getMessage());
        }
    }
}
