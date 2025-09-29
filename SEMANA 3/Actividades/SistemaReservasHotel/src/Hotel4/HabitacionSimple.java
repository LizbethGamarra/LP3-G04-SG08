package Hotel4;

public class HabitacionSimple extends Habitacion implements ServicioLimpieza {

    public HabitacionSimple(int id, double precioBase) {
        super(id, "Simple", precioBase);
    }

    @Override
    public void solicitarLimpieza() {
        System.out.println("Limpieza solicitada para la habitación simple " + id);
    }
}
