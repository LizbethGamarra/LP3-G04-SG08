import java.io.*;
import java.util.*;


class Empleado {
    private int numero;
    private String nombre;
    private double sueldo;

    public Empleado(int numero, String nombre, double sueldo) {
        this.numero = numero;
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    public int getNumero() { return numero; }
    public String getNombre() { return nombre; }
    public double getSueldo() { return sueldo; }

    public void setNumero(int numero) { this.numero = numero; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setSueldo(double sueldo) { this.sueldo = sueldo; }

    @Override
    public String toString() {
        return "Número: " + numero + ", Nombre: " + nombre + ", Sueldo: " + sueldo;
    }

    public String toArchivo() {
        return numero + ";" + nombre + ";" + sueldo;
    }

    public static Empleado fromString(String linea) {
        String[] partes = linea.split(";");
        if (partes.length != 3) return null;
        return new Empleado(
                Integer.parseInt(partes[0]),
                partes[1],
                Double.parseDouble(partes[2])
        );
    }
}


class Vista {
    private Scanner sc = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n=== GESTIÓN DE EMPLEADOS ===");
        System.out.println("1. Listar todos los empleados");
        System.out.println("2. Agregar un nuevo empleado");
        System.out.println("3. Buscar empleado por número");
        System.out.println("4. Eliminar empleado por número");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
        int opcion = sc.nextInt();
        sc.nextLine();
        return opcion;
    }

    public Empleado leerEmpleado() {
        System.out.print("Número del empleado: ");
        int numero = sc.nextInt();
        sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Sueldo: ");
        double sueldo = sc.nextDouble();
        sc.nextLine();
        return new Empleado(numero, nombre, sueldo);
    }

    public int leerNumeroEmpleado(String mensaje) {
        System.out.print(mensaje);
        int numero = sc.nextInt();
        sc.nextLine();
        return numero;
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarEmpleado(Empleado e) {
        if (e != null)
            System.out.println(e);
        else
            System.out.println("Empleado no encontrado.");
    }

    public void mostrarEmpleados(List<Empleado> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay empleados registrados.");
            return;
        }
        for (Empleado e : lista) {
            System.out.println(e);
        }
    }
}


class Controlador {
    private List<Empleado> empleados = new ArrayList<>();
    private final String archivo = "empleados.txt";
    private Vista vista;

    public Controlador(Vista vista) {
        this.vista = vista;
        leerEmpleados();
    }


    public void leerEmpleados() {
        empleados.clear();
        File f = new File(archivo);
        if (!f.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                Empleado e = Empleado.fromString(linea);
                if (e != null) empleados.add(e);
            }
        } catch (IOException ex) {
            vista.mostrarMensaje("Error al leer archivo: " + ex.getMessage());
        }
    }


    private void guardarEmpleados() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            for (Empleado e : empleados) {
                pw.println(e.toArchivo());
            }
        } catch (IOException ex) {
            vista.mostrarMensaje("Error al guardar archivo: " + ex.getMessage());
        }
    }

    public void listarEmpleados() {
        vista.mostrarEmpleados(empleados);
    }

    public void agregarEmpleado() {
        Empleado e = vista.leerEmpleado();

        for (Empleado emp : empleados) {
            if (emp.getNumero() == e.getNumero()) {
                vista.mostrarMensaje("El número ya existe. No se puede agregar.");
                return;
            }
        }
        empleados.add(e);
        guardarEmpleados();
        vista.mostrarMensaje("Empleado agregado correctamente.");
    }

    public void buscarEmpleado() {
        int numero = vista.leerNumeroEmpleado("Ingrese número del empleado a buscar: ");
        for (Empleado e : empleados) {
            if (e.getNumero() == numero) {
                vista.mostrarEmpleado(e);
                return;
            }
        }
        vista.mostrarMensaje("Empleado no encontrado.");
    }

    public void eliminarEmpleado() {
        int numero = vista.leerNumeroEmpleado("Ingrese número del empleado a eliminar: ");
        Iterator<Empleado> it = empleados.iterator();
        while (it.hasNext()) {
            Empleado e = it.next();
            if (e.getNumero() == numero) {
                it.remove();
                guardarEmpleados();
                vista.mostrarMensaje("Empleado eliminado correctamente.");
                return;
            }
        }
        vista.mostrarMensaje("Empleado no encontrado.");
    }
}


public class Ejercicio_03 {
    public static void main(String[] args) {
        Vista vista = new Vista();
        Controlador controlador = new Controlador(vista);
        int opcion;

        do {
            opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1: controlador.listarEmpleados(); break;
                case 2: controlador.agregarEmpleado(); break;
                case 3: controlador.buscarEmpleado(); break;
                case 4: controlador.eliminarEmpleado(); break;
                case 5: vista.mostrarMensaje("Saliendo del programa..."); break;
                default: vista.mostrarMensaje("Opción inválida.");
            }
        } while (opcion != 5);
    }
}
