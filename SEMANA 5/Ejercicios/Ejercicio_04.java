import java.util.ArrayList;
import java.util.List;


class Par<F, S> {
    private F primero;
    private S segundo;

    public Par(F primero, S segundo) {
        this.primero = primero;
        this.segundo = segundo;
    }

    public F getPrimero() {
        return primero;
    }

    public S getSegundo() {
        return segundo;
    }

    @Override
    public String toString() {
        return "(" + primero + ", " + segundo + ")";
    }
}


class Contenedor<F, S> {
    private List<Par<F, S>> listaPares;

    public Contenedor() {
        listaPares = new ArrayList<>();
    }

    public void agregarPar(F primero, S segundo) {
        listaPares.add(new Par<>(primero, segundo));
    }

    public Par<F, S> obtenerPar(int indice) {
        if (indice >= 0 && indice < listaPares.size()) {
            return listaPares.get(indice);
        } else {
            return null; // o lanzar una excepción
        }
    }

    public List<Par<F, S>> obtenerTodosLosPares() {
        return listaPares;
    }

    public void mostrarPares() {
        for (Par<F, S> par : listaPares) {
            System.out.println(par);
        }
    }
}

// Clase principal
public class Ejercicio_04 {
    public static void main(String[] args) {

        Contenedor<String, Integer> contenedor1 = new Contenedor<>();
        contenedor1.agregarPar("Uno", 1);
        contenedor1.agregarPar("Dos", 2);
        contenedor1.agregarPar("Tres", 3);

        System.out.println("Contenido del contenedor1:");
        contenedor1.mostrarPares();


        Contenedor<Double, Boolean> contenedor2 = new Contenedor<>();
        contenedor2.agregarPar(3.14, true);
        contenedor2.agregarPar(2.71, false);

        System.out.println("\nContenido del contenedor2:");
        contenedor2.mostrarPares();


        Par<String, Integer> par = contenedor1.obtenerPar(1);
        System.out.println("\nPar en índice 1 del contenedor1: " + par);
    }
}
