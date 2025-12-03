public class DescuentoPorcentual implements DiscountStrategy {
    @Override
    public double aplicarDescuento(Producto[] productos) {
        if (productos.length == 2 &&
            productos[0].getNombre().equalsIgnoreCase(productos[1].getNombre())) {
            return (productos[0].getPrecio() + productos[1].getPrecio()) * 0.70;
        }

        double total = 0;
        for (Producto p : productos) total += p.getPrecio();
        return total;
    }
}
