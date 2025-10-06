import java.util.List;
import java.util.Scanner;

public class PedidoVista {
    private Scanner scanner;

    public PedidoVista() {
        scanner = new Scanner(System.in);
    }

    public String solicitarNombrePlato() {
        System.out.print("Introduce el nombre del plato: ");
        return scanner.nextLine();
    }

    public String solicitarTipoPlato() {
        System.out.print("Introduce el tipo de plato (Entrada, Fondo, Bebida, etc.): ");
        return scanner.nextLine();
    }

    public void mostrarPedidos(List<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos.");
        } else {
            System.out.println("\n📋 Lista de pedidos:");
            for (Pedido p : pedidos) {
                System.out.println("- " + p);
            }
        }
    }

    public void mostrarMenuExtendido() {
        System.out.println("\n=== MENÚ ===");
        System.out.println("1. Agregar pedido");
        System.out.println("2. Mostrar pedidos");
        System.out.println("3. Eliminar pedido");
        System.out.println("4. Buscar pedido");
        System.out.println("5. Contar pedidos");
        System.out.println("6. Salir");
    }

    public String solicitarOpcion() {
        System.out.print("Selecciona una opción: ");
        return scanner.nextLine();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void cerrarScanner() {
        scanner.close();
    }
}
