
public class CalculadoraPrecios {

    private EstrategiaDescuento estrategia;

    public void setEstrategia(EstrategiaDescuento estrategia) {
        this.estrategia = estrategia;
    }

    public double calcular(Producto producto, int cantidad) {
        return estrategia.aplicarDescuento(producto, cantidad);
    }
}

