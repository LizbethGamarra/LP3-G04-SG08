
public class SinDescuento implements EstrategiaDescuento {

    @Override
    public double aplicarDescuento(Producto producto, int cantidad) {
        return producto.getPrecio() * cantidad;
    }
}

