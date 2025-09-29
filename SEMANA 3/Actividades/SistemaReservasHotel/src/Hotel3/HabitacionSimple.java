package Hotel3;

public class HabitacionSimple extends Habitacion {
    public HabitacionSimple(int id, double precioBase) {
        super(id, "Simple", precioBase);
    }

    @Override
    public double calcularPrecio() {
        return precioBase; // respeta el contrato
    }
}
