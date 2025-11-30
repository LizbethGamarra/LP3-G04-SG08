
public class DescuentoPorcentual implements EstrategiaDescuento {

    @Override
    public double aplicarDescuento(Producto producto, int cantidad) {
        if (cantidad >= 2) {
            return (producto.getPrecio() * cantidad) * 0.70; // 30%
        }
        return producto.getPrecio() * cantidad;
    }
}
