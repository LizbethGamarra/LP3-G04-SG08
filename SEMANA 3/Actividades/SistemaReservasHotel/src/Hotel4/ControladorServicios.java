package Hotel4;

import java.util.List;

public class ControladorServicios {
    private List<Habitacion> habitaciones;

    public ControladorServicios(List<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public void gestionarServicios() {
        for (Habitacion h : habitaciones) {
            System.out.println("Servicios disponibles para " + h.getDescripcion());

            if (h instanceof ServicioLimpieza) {
                ((ServicioLimpieza) h).solicitarLimpieza();
            }
            if (h instanceof ServicioComida) {
                ((ServicioComida) h).solicitarComida("Sandwich");
            }
            if (h instanceof ServicioLavanderia) {
                ((ServicioLavanderia) h).solicitarLavanderia("Camisa");
            }

            System.out.println();
        }
    }
}
