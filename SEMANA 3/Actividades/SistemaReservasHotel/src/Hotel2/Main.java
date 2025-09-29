package Hotel2;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        ControladorReservas controlador = new ControladorReservas();

        Habitacion hab1 = new Habitacion(101, "Suite", 200.0, null);
        Cliente cliente1 = new Cliente("Adrian Rivera");

        // Reserva con política flexible
        Reserva r1 = new Reserva(hab1, cliente1,
                LocalDate.of(2025, 9, 15),
                LocalDate.of(2025, 9, 18),
                new PoliticaCancelacionFlexible());

        // Reserva con política estricta
        Reserva r2 = new Reserva(hab1, cliente1,
                LocalDate.of(2025, 9, 20),
                LocalDate.of(2025, 9, 23),
                new PoliticaCancelacionEstricta());

        controlador.crearReserva(hab1, cliente1,
                LocalDate.of(2025, 9, 15),
                LocalDate.of(2025, 9, 18),
                new PoliticaCancelacionFlexible());

        // Intentar cancelar
        controlador.cancelarReserva(r1); //si se está antes del 14/09/2025
        controlador.cancelarReserva(r2); //nunca se cancela
    }
}
