package Hotel3;

public class HabitacionDoble extends Habitacion {
    public HabitacionDoble(int id, double precioBase) {
        super(id, "Doble", precioBase);
    }

    @Override
    public double calcularPrecio() {
        return precioBase * 1.5; // recargo por dos camas
    }
}
