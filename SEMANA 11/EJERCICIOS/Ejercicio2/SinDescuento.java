public class SinDescuento implements DiscountStrategy {
    @Override
    public double aplicarDescuento(Producto[] productos) {
        double total = 0;
        for (Producto p : productos) total += p.getPrecio();
        return total;
    }
}
