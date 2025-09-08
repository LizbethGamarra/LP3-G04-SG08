package Hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ControladorReservas {
    private GestorDisponibilidadHabitacion gestor;
    private List<Reserva> reservas;

    public ControladorReservas() {
        this.reservas = new ArrayList<>();
        this.gestor = new GestorDisponibilidadHabitacion(reservas);
    }

    public void crearReserva(Habitacion habitacion, Cliente cliente, LocalDate inicio, LocalDate fin) {
        if (gestor.estaDisponible(habitacion, inicio, fin)) {
            Reserva reserva = new Reserva(habitacion, cliente, inicio, fin);
            reservas.add(reserva);
            habitacion.setEstado("Reservada");
            System.out.println("Reserva creada para"+cliente.getNombre());
        } else {
            System.out.println("La habitación no está disponible.");
        }
    }
}
