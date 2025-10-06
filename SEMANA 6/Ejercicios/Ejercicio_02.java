import java.util.*;

class Item {
    private String nombre;
    private int cantidad;
    private String tipo;
    private String descripcion;

    public Item(String nombre, int cantidad, String tipo, String descripcion) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void usarItem() {
        if (cantidad > 0) {
            cantidad--;
            System.out.println("Has usado el item: " + nombre);
        } else {
            System.out.println("No quedan unidades del item: " + nombre);
        }
    }

    @Override
    public String toString() {
        return nombre + " (" + tipo + ") - Cantidad: " + cantidad;
    }
}



class InventarioModel {
    private List<Item> items;

    public InventarioModel() {
        items = new ArrayList<>();
    }

    public void agregarItem(Item item) {
        items.add(item);
    }

    public void eliminarItem(Item item) {
        items.remove(item);
    }

    public List<Item> obtenerItems() {
        return items;
    }

    public Item buscarItem(String nombre) {
        for (Item i : items) {
            if (i.getNombre().equalsIgnoreCase(nombre)) {
                return i;
            }
        }
        return null;
    }
}



class InventarioView {
    public void mostrarInventario(List<Item> items) {
        System.out.println("\n=== INVENTARIO ===");
        if (items.isEmpty()) {
            System.out.println("El inventario está vacío.");
        } else {
            for (Item i : items) {
                System.out.println(i);
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarDetallesItem(Item item) {
        if (item != null) {
            System.out.println("\n--- Detalles del Item ---");
            System.out.println("Nombre: " + item.getNombre());
            System.out.println("Tipo: " + item.getTipo());
            System.out.println("Cantidad: " + item.getCantidad());
            System.out.println("Descripción: " + item.getDescripcion());
        } else {
            System.out.println("Item no encontrado.");
        }
    }
}



class InventarioController {
    private InventarioModel modelo;
    private InventarioView vista;

    public InventarioController(InventarioModel modelo, InventarioView vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void agregarItem(Item item) {
        modelo.agregarItem(item);
        vista.mostrarMensaje("Item agregado: " + item.getNombre());
    }

    public void eliminarItem(String nombre) {
        Item item = modelo.buscarItem(nombre);
        if (item != null) {
            modelo.eliminarItem(item);
            vista.mostrarMensaje("Item eliminado: " + nombre);
        } else {
            vista.mostrarMensaje("No se encontró el item: " + nombre);
        }
    }

    public void verInventario() {
        vista.mostrarInventario(modelo.obtenerItems());
    }

    public void mostrarDetalles(String nombre) {
        Item item = modelo.buscarItem(nombre);
        vista.mostrarDetallesItem(item);
    }

    public void buscarItem(String nombre) {
        Item item = modelo.buscarItem(nombre);
        if (item != null) {
            vista.mostrarMensaje("Item encontrado: " + item.getNombre());
        } else {
            vista.mostrarMensaje("Item no encontrado.");
        }
    }
}



//MAIN
public class Ejercicio_02 {
    public static void main(String[] args) {
        InventarioModel modelo = new InventarioModel();
        InventarioView vista = new InventarioView();
        InventarioController controlador = new InventarioController(modelo, vista);

        controlador.agregarItem(new Item("Espada de hierro", 2, "Arma", "Una espada resistente hecha de hierro."));
        controlador.agregarItem(new Item("Poción de curación", 5, "Poción", "Restaura la salud del jugador."));
        controlador.agregarItem(new Item("Escudo de madera", 1, "Armadura", "Ofrece protección básica."));

        controlador.verInventario();

        controlador.mostrarDetalles("Poción de curación");

        Item pocion = modelo.buscarItem("Poción de curación");
        if (pocion != null) pocion.usarItem();

        controlador.eliminarItem("Escudo de madera");

        controlador.verInventario();
    }
}
