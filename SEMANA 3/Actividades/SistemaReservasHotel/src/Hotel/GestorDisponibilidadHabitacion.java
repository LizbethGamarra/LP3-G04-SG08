package Hotel;

import java.time.LocalDate;
import java.util.List;

public class GestorDisponibilidadHabitacion {
    private List<Reserva> reservas;

    public GestorDisponibilidadHabitacion(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public boolean estaDisponible(Habitacion habitacion, LocalDate inicio, LocalDate fin) {
        for (Reserva reserva : reservas) {
            if (reserva.getHabitacion().getId() == habitacion.getId()) {
                if (!(fin.isBefore(reserva.getInicio()) || inicio.isAfter(reserva.getFin()))) {
                    return false; // Se cruza con otra reserva
                }
            }
        }
        return true;
    }

    public double calcularPrecio(Habitacion habitacion, LocalDate inicio, LocalDate fin) {
        long dias = java.time.temporal.ChronoUnit.DAYS.between(inicio, fin);
        return habitacion.getPrecioBase() * dias;
    }
}
