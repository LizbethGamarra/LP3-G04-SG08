package Hotel3;

public class HabitacionSuite extends Habitacion {
    public HabitacionSuite(int id, double precioBase) {
        super(id, "Suite", precioBase);
    }

    @Override
    public double calcularPrecio() {
        return precioBase * 2.0; // precio mayor para suite
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Acceso a minibar y servicio premium";
    }
}
