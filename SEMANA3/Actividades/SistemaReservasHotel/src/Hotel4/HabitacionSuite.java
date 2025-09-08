package Hotel4;

public class HabitacionSuite extends Habitacion implements ServicioLimpieza, ServicioComida, ServicioLavanderia {

    public HabitacionSuite(int id, double precioBase) {
        super(id, "Suite", precioBase);
    }

    @Override
    public void solicitarLimpieza() {
        System.out.println("Limpieza solicitada para la suite " + id);
    }

    @Override
    public void solicitarComida(String plato) {
        System.out.println("Pedido de " + plato + " para la suite " + id);
    }

    @Override
    public void solicitarLavanderia(String prenda) {
        System.out.println("Lavandería solicitada para " + prenda + " en la suite " + id);
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Servicios Premium (comida, lavandería)";
    }
}
