package Hotel2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ControladorReservas {
    private List<Reserva> reservas;

    public ControladorReservas() {
        this.reservas = new ArrayList<>();
    }

    public void crearReserva(Habitacion habitacion, Cliente cliente, LocalDate inicio, LocalDate fin, PoliticaCancelacion politica) {
        Reserva reserva = new Reserva(habitacion, cliente, inicio, fin, politica);
        reservas.add(reserva);
        System.out.println("Reserva creada para " + cliente.getNombre());
    }

    public void cancelarReserva(Reserva reserva) {
        if (reserva.puedeCancelar()) {
            reservas.remove(reserva);
            System.out.println("Reserva cancelada para " + reserva.getCliente().getNombre());
        } else {
            System.out.println("No se puede cancelar la reserva de " + reserva.getCliente().getNombre());
        }
    }
}
