public class DescuentoPorcentualAcumulado implements DiscountStrategy {
    @Override
    public double aplicarDescuento(Producto[] productos) {
        double total = 0;
        double menor = Double.MAX_VALUE;

        for (Producto p : productos) {
            total += p.getPrecio();
            if (p.getPrecio() < menor) menor = p.getPrecio();
        }

        if (productos.length >= 3) {
            total -= menor * 0.50;
        }

        return total;
    }
}
