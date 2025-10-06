import java.util.*;

class Item {
    private String nombre;
    private int cantidad;
    private String tipo;
    private String descripcion;
    private int poder;

    public Item(String nombre, int cantidad, String tipo, String descripcion, int poder) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.poder = poder;
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

    public int getPoder() {
        return poder;
    }

    public void usarItem() {
        if (cantidad > 0) {
            cantidad--;
        }
    }

    @Override
    public String toString() {
        return nombre + " (" + tipo + ") - Cantidad: " + cantidad + " - Poder: " + poder;
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

    public Item buscarItem(String nombre) {
        return modelo.buscarItem(nombre);
    }

    public void verInventario() {
        vista.mostrarInventario(modelo.obtenerItems());
    }
}

class Jugador {
    private String nombre;
    private int salud;
    private int nivel;
    private InventarioModel inventario;
    private Item armaEquipada;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.salud = 100;
        this.nivel = 1;
        this.inventario = new InventarioModel();
    }

    public String getNombre() { return nombre; }
    public int getSalud() { return salud; }
    public int getNivel() { return nivel; }
    public Item getArmaEquipada() { return armaEquipada; }

    public void equiparArma(String nombreItem) {
        Item item = inventario.buscarItem(nombreItem);
        if (item != null && item.getTipo().equalsIgnoreCase("Arma")) {
            armaEquipada = item;
            System.out.println(nombre + " ha equipado el arma: " + item.getNombre());
        } else {
            System.out.println("No se puede equipar ese objeto.");
        }
    }

    public void atacar(Enemigo enemigo) {
        int daño = (armaEquipada != null) ? armaEquipada.getPoder() : 5;
        enemigo.recibirDaño(daño);
        System.out.println(nombre + " ataca a " + enemigo.getNombre() + " causando " + daño + " de daño.");
    }

    public void usarObjeto(String nombreItem) {
        Item item = inventario.buscarItem(nombreItem);
        if (item != null && item.getTipo().equalsIgnoreCase("Poción")) {
            salud += item.getPoder();
            item.usarItem();
            System.out.println(nombre + " usa una " + item.getNombre() + " y recupera " + item.getPoder() + " de salud.");
        } else {
            System.out.println("No se puede usar ese objeto.");
        }
    }

    public void recibirDaño(int daño) {
        salud -= daño;
        if (salud < 0) salud = 0;
        System.out.println(nombre + " recibe " + daño + " de daño. Salud restante: " + salud);
    }

    public boolean estaVivo() {
        return salud > 0;
    }

    public InventarioModel getInventario() {
        return inventario;
    }
}

class Enemigo {
    private String nombre;
    private int salud;
    private int nivel;
    private String tipo;

    public Enemigo(String nombre, int salud, int nivel, String tipo) {
        this.nombre = nombre;
        this.salud = salud;
        this.nivel = nivel;
        this.tipo = tipo;
    }

    public String getNombre() { return nombre; }
    public int getSalud() { return salud; }
    public boolean estaVivo() { return salud > 0; }

    public void atacar(Jugador jugador) {
        int daño = (int)(Math.random() * 10) + 5;
        System.out.println(nombre + " (" + tipo + ") ataca causando " + daño + " de daño.");
        jugador.recibirDaño(daño);
    }

    public void recibirDaño(int daño) {
        salud -= daño;
        if (salud < 0) salud = 0;
    }
}

class CombateModel {
    private Jugador jugador;
    private List<Enemigo> enemigos;

    public CombateModel(Jugador jugador, List<Enemigo> enemigos) {
        this.jugador = jugador;
        this.enemigos = enemigos;
    }

    public Jugador getJugador() { return jugador; }
    public List<Enemigo> getEnemigos() { return enemigos; }
}

class CombateView {
    public void mostrarEstado(Jugador jugador, List<Enemigo> enemigos) {
        System.out.println("\n=== ESTADO DEL COMBATE ===");
        System.out.println(jugador.getNombre() + " - Salud: " + jugador.getSalud());
        for (Enemigo e : enemigos) {
            System.out.println(e.getNombre() + " (" + e.getSalud() + " HP)");
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}

class CombateController {
    private CombateModel modelo;
    private CombateView vista;
    private Scanner sc;

    public CombateController(CombateModel modelo, CombateView vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.sc = new Scanner(System.in);
    }

    public void iniciarCombate() {
        Jugador jugador = modelo.getJugador();
        List<Enemigo> enemigos = modelo.getEnemigos();

        vista.mostrarMensaje("\n¡Comienza el combate!");

        while (jugador.estaVivo() && enemigos.stream().anyMatch(Enemigo::estaVivo)) {
            vista.mostrarEstado(jugador, enemigos);

            System.out.println("\n¿Qué deseas hacer?");
            System.out.println("1. Atacar");
            System.out.println("2. Usar poción");
            System.out.println("3. Ver inventario");
            System.out.print("→ Opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("¿A qué enemigo quieres atacar?: ");
                    String nombreE = sc.nextLine();
                    Enemigo objetivo = enemigos.stream()
                            .filter(e -> e.getNombre().equalsIgnoreCase(nombreE))
                            .findFirst().orElse(null);
                    if (objetivo != null && objetivo.estaVivo()) {
                        jugador.atacar(objetivo);
                    } else {
                        vista.mostrarMensaje("Enemigo no encontrado o ya derrotado.");
                    }
                    break;
                case 2:
                    System.out.print("¿Qué objeto usar?: ");
                    String nombreItem = sc.nextLine();
                    jugador.usarObjeto(nombreItem);
                    break;
                case 3:
                    new InventarioView().mostrarInventario(jugador.getInventario().obtenerItems());
                    continue;
                default:
                    vista.mostrarMensaje("Opción no válida.");
                    continue;
            }

            for (Enemigo e : enemigos) {
                if (e.estaVivo()) e.atacar(jugador);
            }
        }

        if (jugador.estaVivo()) {
            vista.mostrarMensaje("\n¡Has ganado el combate!");
        } else {
            vista.mostrarMensaje("\nHas sido derrotado...");
        }
    }
}

// MAIN
public class Ejercicio_03 {
    public static void main(String[] args) {
        Jugador jugador = new Jugador("Heroe");

        jugador.getInventario().agregarItem(new Item("Espada de hierro", 1, "Arma", "Una espada básica.", 15));
        jugador.getInventario().agregarItem(new Item("Poción de curación", 3, "Poción", "Restaura salud.", 20));

        jugador.equiparArma("Espada de hierro");

        List<Enemigo> enemigos = new ArrayList<>();
        enemigos.add(new Enemigo("Goblin", 40, 1, "Bestia"));
        enemigos.add(new Enemigo("Esqueleto", 50, 1, "No-Muerto"));

        CombateModel combateModel = new CombateModel(jugador, enemigos);
        CombateView combateView = new CombateView();
        CombateController combateController = new CombateController(combateModel, combateView);

        combateController.iniciarCombate();
    }
}
