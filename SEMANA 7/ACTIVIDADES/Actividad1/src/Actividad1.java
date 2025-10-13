import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

public class Actividad1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la ruta del archivo o directorio: ");
        String entrada = sc.nextLine();

        Path ruta = Paths.get(entrada);

        if (Files.exists(ruta)) {
            System.out.println("\n--- Información del archivo/directorio ---");
            System.out.println("Nombre: " + ruta.getFileName());
            System.out.println("Ruta absoluta: " + ruta.toAbsolutePath());
            System.out.println("¿Es directorio?: " + Files.isDirectory(ruta));
            System.out.println("¿Es ruta absoluta?: " + ruta.isAbsolute());

            try {
                System.out.println("Última modificación: " + Files.getLastModifiedTime(ruta));
                System.out.println("Tamaño (bytes): " + Files.size(ruta));

                if (Files.isDirectory(ruta)) {
                    System.out.println("\nContenido del directorio:");
                    DirectoryStream<Path> stream = Files.newDirectoryStream(ruta);
                    for (Path p : stream) {
                        System.out.println(" - " + p.getFileName());
                    }
                }
            } catch (IOException e) {
                System.err.println("Error al obtener información: " + e.getMessage());
            }
        } else {
            System.out.println("La ruta indicada no existe.");
        }

        sc.close();
    }
}
