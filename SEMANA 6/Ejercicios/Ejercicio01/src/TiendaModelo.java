import java.util.ArrayList;
import java.util.List;

public class TiendaModelo {
    private List<Producto> productosDisponibles;
    private Carrito carrito;
    private List<List<Producto>> historialCompras;

    public TiendaModelo() {
        productosDisponibles = new ArrayList<>();
        carrito = new Carrito();
        historialCompras = new ArrayList<>();

        productosDisponibles.add(new Producto("Laptop", 3500));
        productosDisponibles.add(new Producto("Mouse", 50));
        productosDisponibles.add(new Producto("Teclado", 120));
        productosDisponibles.add(new Producto("Audífonos", 200));
        productosDisponibles.add(new Producto("Monitor", 700));
    }

    public List<Producto> getProductosDisponibles() {
        return productosDisponibles;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public List<List<Producto>> getHistorialCompras() {
        return historialCompras;
    }

    public void agregarProductoTienda(String nombre, double precio) {
        productosDisponibles.add(new Producto(nombre, precio));
    }

    public double aplicarDescuento(double total, double porcentaje) {
        return total - (total * (porcentaje / 100));
    }

    public double calcularEnvio(double total) {
        return total >= 200 ? 0 : 10;
    }

    public void realizarCompra() {
        if (!carrito.estaVacio()) {
            historialCompras.add(new ArrayList<>(carrito.getProductos()));
            carrito.vaciar();
        }
    }
}
