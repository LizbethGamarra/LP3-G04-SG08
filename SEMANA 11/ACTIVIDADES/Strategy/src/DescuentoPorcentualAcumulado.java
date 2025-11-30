
public class DescuentoPorcentualAcumulado implements EstrategiaDescuento {

    @Override
    public double aplicarDescuento(Producto producto, int cantidad) {
        double total = producto.getPrecio() * cantidad;

        if (cantidad >= 3) {
            double descuento = producto.getPrecio() * 0.50; // 50% del menor
            return total - descuento;
        }

        return total;
    }
}
