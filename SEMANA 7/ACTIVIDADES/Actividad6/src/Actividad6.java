import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Fecha implements Serializable {
    private int dia;
    private int mes;
    private int anio;

    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + anio;
    }
}

class Persona implements Serializable {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Edad: " + edad;
    }
}

class Alumno extends Persona {
    private String codigo;
    private Fecha fechaNacimiento;

    public Alumno(String nombre, int edad, String codigo, Fecha fechaNacimiento) {
        super(nombre, edad);
        this.codigo = codigo;
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return super.toString() + " | Código: " + codigo + " | Fecha Nac: " + fechaNacimiento;
    }
}

public class Actividad6 {
    public static void main(String[] args) {
        String nombreArchivo = "alumnos.dat";

        List<Alumno> listaAlumnos = new ArrayList<>();
        listaAlumnos.add(new Alumno("Carlos Ruiz", 21, "A001", new Fecha(15, 3, 2003)));
        listaAlumnos.add(new Alumno("Ana Torres", 22, "A002", new Fecha(8, 6, 2002)));
        listaAlumnos.add(new Alumno("Luis Pérez", 20, "A003", new Fecha(1, 12, 2004)));

        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            for (Alumno a : listaAlumnos) {
                salida.writeObject(a);
            }
            System.out.println("Se guardaron los objetos Alumno en el archivo " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al guardar: " + e.getMessage());
        }

        System.out.println("\n--- Lectura desde archivo ---");
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            while (true) {
                Alumno a = (Alumno) entrada.readObject();
                System.out.println(a);
            }
        } catch (EOFException e) {
            System.out.println("\nFin del archivo alcanzado.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al leer: " + e.getMessage());
        }
    }
}
