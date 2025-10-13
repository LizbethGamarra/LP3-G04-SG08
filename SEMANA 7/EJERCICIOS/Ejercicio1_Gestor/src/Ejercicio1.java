import java.io.*;
import java.util.*;

class Personaje {
    private String nombre;
    private int vida;
    private int ataque;
    private int defensa;
    private int alcance;

    public Personaje(String nombre, int vida, int ataque, int defensa, int alcance) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.alcance = alcance;
    }

    public String getNombre() {
        return nombre;
    }

    public void setVida(int vida) { this.vida = vida; }
    public void setAtaque(int ataque) { this.ataque = ataque; }
    public void setDefensa(int defensa) { this.defensa = defensa; }
    public void setAlcance(int alcance) { this.alcance = alcance; }

    @Override
    public String toString() {
        return nombre + ";" + vida + ";" + ataque + ";" + defensa + ";" + alcance;
    }

    public static Personaje fromString(String linea) {
        String[] partes = linea.split(";");
        if (partes.length != 5) return null;
        return new Personaje(partes[0], Integer.parseInt(partes[1]), Integer.parseInt(partes[2]),
                             Integer.parseInt(partes[3]), Integer.parseInt(partes[4]));
    }

    public String mostrarDatos() {
        return "Nombre: " + nombre +
               "\nVida: " + vida +
               "\nAtaque: " + ataque +
               "\nDefensa: " + defensa +
               "\nAlcance: " + alcance;
    }
}

class Gestor {
    private List<Personaje> personajes = new ArrayList<>();
    private final String archivo = "personajes.txt";

    public Gestor() {
        cargar();
    }
    public void cargar() {
        personajes.clear();
        File f = new File(archivo);
        if (!f.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                Personaje p = Personaje.fromString(linea);
                if (p != null) personajes.add(p);
            }
        } catch (IOException e) {
            System.err.println("Error al cargar: " + e.getMessage());
        }
    }
    public void guardar() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            for (Personaje p : personajes) {
                pw.println(p);
            }
        } catch (IOException e) {
            System.err.println("Error al guardar: " + e.getMessage());
        }
    }
    public void agregar(Personaje p) {
        for (Personaje existente : personajes) {
            if (existente.getNombre().equalsIgnoreCase(p.getNombre())) {
                System.out.println("El personaje ya existe.");
                return;
            }
        }
        personajes.add(p);
        guardar();
        System.out.println("Personaje añadido correctamente.");
    }
    public void mostrar() {
        if (personajes.isEmpty()) {
            System.out.println("No hay personajes registrados.");
        } else {
            System.out.println("=== Lista de Personajes ===");
            for (Personaje p : personajes) {
                System.out.println(p.mostrarDatos());
            }
        }
    }
    public Personaje buscar(String nombre) {
        for (Personaje p : personajes) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

    public void modificar(String nombre, int vida, int ataque, int defensa, int alcance) {
        Personaje p = buscar(nombre);
        if (p != null) {
            p.setVida(vida);
            p.setAtaque(ataque);
            p.setDefensa(defensa);
            p.setAlcance(alcance);
            guardar();
            System.out.println("Personaje modificado correctamente.");
        } else {
            System.out.println("No se encontró el personaje.");
        }
    }

    public void eliminar(String nombre) {
        Personaje p = buscar(nombre);
        if (p != null) {
            personajes.remove(p);
            guardar();
            System.out.println("Personaje eliminado.");
        } else {
            System.out.println("No se encontró el personaje.");
        }
    }
}


public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Gestor gestor = new Gestor();
        int opcion;

        do {
            System.out.println("\n=== GESTOR DE PERSONAJES ===");
            System.out.println("1. Agregar personaje");
            System.out.println("2. Mostrar personajes");
            System.out.println("3. Modificar personaje");
            System.out.println("4. Eliminar personaje");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Vida: ");
                    int vida = sc.nextInt();
                    System.out.print("Ataque: ");
                    int ataque = sc.nextInt();
                    System.out.print("Defensa: ");
                    int defensa = sc.nextInt();
                    System.out.print("Alcance: ");
                    int alcance = sc.nextInt();
                    gestor.agregar(new Personaje(nombre, vida, ataque, defensa, alcance));
                    break;
                case 2:
                    gestor.mostrar();
                    break;
                case 3:
                    System.out.print("Nombre del personaje a modificar: ");
                    String mod = sc.nextLine();
                    System.out.print("Nueva vida: ");
                    vida = sc.nextInt();
                    System.out.print("Nuevo ataque: ");
                    ataque = sc.nextInt();
                    System.out.print("Nueva defensa: ");
                    defensa = sc.nextInt();
                    System.out.print("Nuevo alcance: ");
                    alcance = sc.nextInt();
                    gestor.modificar(mod, vida, ataque, defensa, alcance);
                    break;
                case 4:
                    System.out.print("Nombre del personaje a eliminar: ");
                    String elim = sc.nextLine();
                    gestor.eliminar(elim);
                    break;
                case 5:
                    System.out.println("Saliendo del gestor...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);

        sc.close();
    }
}
