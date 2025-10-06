import java.util.List;
import java.util.Scanner;

public class PedidoVista {
    private Scanner scanner;

    public PedidoVista() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("\n=== MENÚ PRINCIPAL ===");
        System.out.println("1. Agregar pedido");
        System.out.println("2. Mostrar todos los pedidos");
        System.out.println("3. Marcar pedido como completo");
        System.out.println("4. Eliminar pedido");
        System.out.println("5. Mostrar pedidos pendientes");
        System.out.println("6. Mostrar pedidos completos");
        System.out.println("7. Contador de pedidos pendientes");
        System.out.println("8. Mostrar historial");
        System.out.println("9. Buscar pedido");
        System.out.println("10. Salir");
    }

    public String solicitarOpcion() {
        System.out.print("Selecciona una opción: ");
        return scanner.nextLine();
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
            System.out.println("No hay pedidos para mostrar.");
        } else {
            System.out.println("\n Lista de pedidos:");
            for (Pedido p : pedidos) {
                System.out.println("- " + p);
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void cerrarScanner() {
        scanner.close();
    }
}
