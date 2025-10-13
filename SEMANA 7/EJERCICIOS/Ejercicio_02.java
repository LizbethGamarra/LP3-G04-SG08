import java.io.*;
import java.util.*;

class Personaje {
    private String nombre;
    private int vida;
    private int ataque;
    private int defensa;
    private int alcance;
    private int nivel; // Nuevo atributo nivel

    public Personaje(String nombre, int vida, int ataque, int defensa, int alcance) {
        this(nombre, vida, ataque, defensa, alcance, 1); // Nivel inicial 1
    }

    public Personaje(String nombre, int vida, int ataque, int defensa, int alcance, int nivel) {
        if (vida <= 0 || ataque <= 0 || defensa <= 0 || alcance <= 0)
            throw new IllegalArgumentException("Todos los valores deben ser mayores que cero.");

        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.alcance = alcance;
        this.nivel = nivel;
    }

    public String getNombre() { return nombre; }
    public int getVida() { return vida; }
    public int getAtaque() { return ataque; }
    public int getDefensa() { return defensa; }
    public int getAlcance() { return alcance; }
    public int getNivel() { return nivel; }

    public void setVida(int vida) { this.vida = vida; }
    public void setAtaque(int ataque) { this.ataque = ataque; }
    public void setDefensa(int defensa) { this.defensa = defensa; }
    public void setAlcance(int alcance) { this.alcance = alcance; }
    public void subirNivel() { 
        nivel++; 
        vida += 1;
        ataque += 1;
        defensa += 1;
        alcance += 1;
    }

    @Override
    public String toString() {
        return nombre + ";" + vida + ";" + ataque + ";" + defensa + ";" + alcance + ";" + nivel;
    }

    public static Personaje fromString(String linea) {
        String[] partes = linea.split(";");
        if (partes.length != 6) return null;
        return new Personaje(partes[0],
                Integer.parseInt(partes[1]),
                Integer.parseInt(partes[2]),
                Integer.parseInt(partes[3]),
                Integer.parseInt(partes[4]),
                Integer.parseInt(partes[5]));
    }

    public String mostrarDatos() {
        return "Nombre: " + nombre +
                "\nVida: " + vida +
                "\nAtaque: " + ataque +
                "\nDefensa: " + defensa +
                "\nAlcance: " + alcance +
                "\nNivel: " + nivel;
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
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private void guardar() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            for (Personaje p : personajes) {
                pw.println(p);
            }
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    public void agregar(Personaje nuevo) {
        for (Personaje p : personajes) {
            if (p.getNombre().equalsIgnoreCase(nuevo.getNombre())) {
                System.out.println("El personaje ya existe. No se agregará.");
                return;
            }
        }
        personajes.add(nuevo);
        guardar();
        System.out.println("Personaje agregado correctamente.");
    }

    public void mostrar() {
        if (personajes.isEmpty()) {
            System.out.println("No hay personajes registrados.");
            return;
        }
        for (Personaje p : personajes) {
            System.out.println("-----------------------");
            System.out.println(p.mostrarDatos());
        }
    }

    public void modificar(String nombre, int vida, int ataque, int defensa, int alcance) {
        for (Personaje p : personajes) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                p.setVida(vida);
                p.setAtaque(ataque);
                p.setDefensa(defensa);
                p.setAlcance(alcance);
                guardar();
                System.out.println("Personaje modificado correctamente.");
                return;
            }
        }
        System.out.println("No se encontró un personaje con ese nombre.");
    }

    public void eliminar(String nombre) {
        Iterator<Personaje> it = personajes.iterator();
        while (it.hasNext()) {
            Personaje p = it.next();
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                it.remove();
                guardar();
                System.out.println("Personaje eliminado correctamente.");
                return;
            }
        }
        System.out.println("No se encontró un personaje con ese nombre.");
    }

    public void filtrarPorAtributo(String atributo) {
        List<Personaje> copia = new ArrayList<>(personajes);
        switch (atributo.toLowerCase()) {
            case "vida":
                copia.sort(Comparator.comparingInt(Personaje::getVida).reversed());
                break;
            case "ataque":
                copia.sort(Comparator.comparingInt(Personaje::getAtaque).reversed());
                break;
            case "defensa":
                copia.sort(Comparator.comparingInt(Personaje::getDefensa).reversed());
                break;
            case "alcance":
                copia.sort(Comparator.comparingInt(Personaje::getAlcance).reversed());
                break;
            default:
                System.out.println("Atributo inválido.");
                return;
        }
        for (Personaje p : copia) {
            System.out.println("-----------------------");
            System.out.println(p.mostrarDatos());
        }
    }


    public void actualizarAtributo(String nombre, String atributo, int valor) {
        for (Personaje p : personajes) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                switch (atributo.toLowerCase()) {
                    case "vida": p.setVida(valor); break;
                    case "ataque": p.setAtaque(valor); break;
                    case "defensa": p.setDefensa(valor); break;
                    case "alcance": p.setAlcance(valor); break;
                    default:
                        System.out.println("Atributo inválido.");
                        return;
                }
                guardar();
                System.out.println("Atributo actualizado correctamente.");
                return;
            }
        }
        System.out.println("No se encontró un personaje con ese nombre.");
    }


    public void mostrarEstadisticas() {
        if (personajes.isEmpty()) {
            System.out.println("No hay personajes registrados.");
            return;
        }
        double sumaVida = 0, sumaAtaque = 0, sumaDefensa = 0, sumaAlcance = 0;
        for (Personaje p : personajes) {
            sumaVida += p.getVida();
            sumaAtaque += p.getAtaque();
            sumaDefensa += p.getDefensa();
            sumaAlcance += p.getAlcance();
        }
        int total = personajes.size();
        System.out.println("Total de personajes: " + total);
        System.out.printf("Vida promedio: %.2f\n", sumaVida / total);
        System.out.printf("Ataque promedio: %.2f\n", sumaAtaque / total);
        System.out.printf("Defensa promedio: %.2f\n", sumaDefensa / total);
        System.out.printf("Alcance promedio: %.2f\n", sumaAlcance / total);
    }

    public void importarDesdeArchivo(String nombreArchivo) {
        File f = new File(nombreArchivo);
        if (!f.exists()) {
            System.out.println("Archivo no encontrado.");
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                Personaje p = Personaje.fromString(linea);
                if (p != null) agregar(p);
            }
            System.out.println("Importación completada.");
        } catch (IOException e) {
            System.out.println("Error al importar: " + e.getMessage());
        }
    }

    public void cargarAleatorios() {
        agregar(new Personaje("Caballero", 4, 2, 4, 2));
        agregar(new Personaje("Guerrero", 2, 4, 2, 4));
        agregar(new Personaje("Arquero", 2, 4, 1, 8));
        System.out.println("Personajes aleatorios cargados.");
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
            System.out.println("5. Filtrar personajes por atributo");
            System.out.println("6. Actualizar atributo individual");
            System.out.println("7. Mostrar estadísticas");
            System.out.println("8. Importar personajes desde archivo");
            System.out.println("9. Cargar personajes aleatorios");
            System.out.println("10. Salir");
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
                    sc.nextLine();
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
                    sc.nextLine();
                    gestor.modificar(mod, vida, ataque, defensa, alcance);
                    break;
                case 4:
                    System.out.print("Nombre del personaje a eliminar: ");
                    String elim = sc.nextLine();
                    gestor.eliminar(elim);
                    break;
                case 5:
                    System.out.print("Ingrese el atributo por el cual filtrar (vida, ataque, defensa, alcance): ");
                    String attr = sc.nextLine();
                    gestor.filtrarPorAtributo(attr);
                    break;
                case 6:
                    System.out.print("Nombre del personaje a actualizar: ");
                    String nom = sc.nextLine();
                    System.out.print("Atributo a actualizar (vida, ataque, defensa, alcance): ");
                    String atributo = sc.nextLine();
                    System.out.print("Nuevo valor: ");
                    int valor = sc.nextInt();
                    sc.nextLine();
                    gestor.actualizarAtributo(nom, atributo, valor);
                    break;
                case 7:
                    gestor.mostrarEstadisticas();
                    break;
                case 8:
                    System.out.print("Nombre del archivo a importar: ");
                    String archivo = sc.nextLine();
                    gestor.importarDesdeArchivo(archivo);
                    break;
                case 9:
                    gestor.cargarAleatorios();
                    break;
                case 10:
                    System.out.println("Saliendo del gestor...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 10);

        sc.close();
    }
}
