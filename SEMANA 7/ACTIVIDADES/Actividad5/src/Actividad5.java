import java.io.*;
import java.util.*;

class Persona {
    private String nombre;
    private String telefono;
    private String direccion;

    public Persona(String nombre, String telefono, String direccion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nTeléfono: " + telefono + "\nDirección: " + direccion;
    }
}

public class Actividad5 {
    public static void main(String[] args) {
        List<Persona> agenda = new ArrayList<>();
        String nombreArchivo = "agenda.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length == 3) {
                    Persona p = new Persona(datos[0].trim(), datos[1].trim(), datos[2].trim());
                    agenda.add(p);
                }
            }
            System.out.println("Agenda cargada correctamente. Total contactos: " + agenda.size());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("\nIngrese el nombre a buscar: ");
        String nombreBuscado = sc.nextLine().trim();

        boolean encontrado = false;
        for (Persona p : agenda) {
            if (p.getNombre().equalsIgnoreCase(nombreBuscado)) {
                System.out.println("\nContacto encontrado:\n" + p);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("\nNo se encontró el contacto con el nombre: " + nombreBuscado);
        }

        sc.close();
    }
}
