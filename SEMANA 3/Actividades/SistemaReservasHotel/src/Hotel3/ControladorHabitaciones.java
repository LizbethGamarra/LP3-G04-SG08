package Hotel3;

import java.util.ArrayList;
import java.util.List;

public class ControladorHabitaciones {
    private List<Habitacion> habitaciones;

    public ControladorHabitaciones() {
        this.habitaciones = new ArrayList<>();
    }

    public void agregarHabitacion(Habitacion h) {
        habitaciones.add(h);
    }

    public void mostrarPrecios() {
        for (Habitacion h : habitaciones) {
            System.out.println(h.getDescripcion() + " → Precio final: " + h.calcularPrecio());
        }
    }
}
