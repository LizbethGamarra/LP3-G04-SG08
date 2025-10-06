import java.util.List;
import java.util.Scanner;

public class TiendaVista {
    private Scanner scanner;

    public TiendaVista() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("\n MENÚ DEL CARRITO DE COMPRAS ");
        System.out.println("1. Ver productos disponibles");
        System.out.println("2. Agregar producto al carrito");
        System.out.println("3. Ver carrito");
        System.out.println("4. Eliminar producto del carrito");
        System.out.println("5. Aplicar descuento");
        System.out.println("6. Calcular envío");
        System.out.println("7. Realizar compra");
        System.out.println("8. Ver historial de compras");
        System.out.println("9. Agregar nuevo producto a la tienda");
        System.out.println("10. Salir");
    }

    public String solicitarOpcion() {
        System.out.print("Selecciona una opción: ");
        return scanner.nextLine();
    }

    public void mostrarProductos(List<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos disponibles.");
        } else {
            System.out.println("\nProductos:");
            for (Producto p : productos) {
                System.out.println("- " + p);
            }
        }
    }

    public String solicitarNombreProducto() {
        System.out.print("Nombre del producto: ");
        return scanner.nextLine();
    }

    public double solicitarPrecioProducto() {
        System.out.print("Precio del producto: ");
        return Double.parseDouble(scanner.nextLine());
    }

    public double solicitarDescuento() {
        System.out.print("Porcentaje de descuento (%): ");
        return Double.parseDouble(scanner.nextLine());
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void cerrarScanner() {
        scanner.close();
    }
}
