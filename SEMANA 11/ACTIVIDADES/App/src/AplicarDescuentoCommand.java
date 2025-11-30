
public class AplicarDescuentoCommand implements Command {

    private Producto producto;
    private EstrategiaDescuento estrategia;
    private Notificador notificador;

    public AplicarDescuentoCommand(Producto p, EstrategiaDescuento e, Notificador n) {
        producto = p;
        estrategia = e;
        notificador = n;
    }

    @Override
    public void ejecutar() {
        double precioFinal = estrategia.aplicar(producto.precio);
        notificador.enviar("Se aplicó un descuento a " + producto.nombre +
                           ". Precio final: " + precioFinal);
    }
}
