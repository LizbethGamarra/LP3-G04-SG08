import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Actividad2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombreArchivo = "datos.txt";
        System.out.println("Escriba líneas de texto (escriba 'fin' para terminar):");


        try (FileWriter fw = new FileWriter(nombreArchivo, true);
             PrintWriter salida = new PrintWriter(fw)) {

            String linea;
            do {
                linea = sc.nextLine();
                if (!linea.equalsIgnoreCase("fin")) {
                    salida.println(linea);
                }
            } while (!linea.equalsIgnoreCase("fin"));

            System.out.println("Texto guardado exitosamente en " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }

        sc.close();
    }
}
