package Hotel4;

public class Habitacion {
    protected int id;
    protected String tipo;
    protected double precioBase;

    public Habitacion(int id, String tipo, double precioBase) {
        this.id = id;
        this.tipo = tipo;
        this.precioBase = precioBase;
    }

    public double calcularPrecio() {
        return precioBase;
    }

    public String getDescripcion() {
        return "Habitación " + tipo + " - Precio base: " + precioBase;
    }
}
