package Hotel4;

public class HabitacionDoble extends Habitacion implements ServicioLimpieza, ServicioComida {

    public HabitacionDoble(int id, double precioBase) {
        super(id, "Doble", precioBase);
    }

    @Override
    public void solicitarLimpieza() {
        System.out.println("Limpieza solicitada para la habitación doble " + id);
    }

    @Override
    public void solicitarComida(String plato) {
        System.out.println("Pedido de " + plato + " para la habitación doble " + id);
    }
}
