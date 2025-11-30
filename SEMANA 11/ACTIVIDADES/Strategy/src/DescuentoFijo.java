
public class DescuentoFijo implements EstrategiaDescuento {

    @Override
    public double aplicarDescuento(Producto producto, int cantidad) {
        return (producto.getPrecio() * cantidad) * 0.90; // 10%
    }
}
