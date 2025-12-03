public class CalculadoraDePrecios {
    private DiscountStrategy estrategia;

    public void setEstrategia(DiscountStrategy estrategia) {
        this.estrategia = estrategia;
    }

    public double calcular(Producto[] productos) {
        return estrategia.aplicarDescuento(productos);
    }
}
