package Hotel;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Lista de reservas inicial
        ArrayList<Reserva> reservas = new ArrayList<>();

        GestorDisponibilidadHabitacion gestor = new GestorDisponibilidadHabitacion(reservas);
        Habitacion hab1 = new Habitacion(101, "Doble", 100.0, gestor);
        Cliente cliente = new Cliente("	Fernando Rivera");

        ControladorReservas controlador = new ControladorReservas();

        // Intentar reservar
        controlador.crearReserva(hab1, cliente,
                LocalDate.of(2025, 9, 10),
                LocalDate.of(2025, 9, 12));

        // Intentar otra reserva en las mismas fechas
        controlador.crearReserva(hab1, new Cliente("Carlos Gómez"),
                LocalDate.of(2025, 9, 11),
                LocalDate.of(2025, 9, 13));
    }
}
