package Hotel;

import java.time.LocalDate;

public class Reserva {
    private Habitacion habitacion;
    private Cliente cliente;
    private LocalDate inicio;
    private LocalDate fin;

    public Reserva(Habitacion habitacion, Cliente cliente, LocalDate inicio, LocalDate fin) {
        this.habitacion = habitacion;
        this.cliente = cliente;
        this.inicio = inicio;
        this.fin = fin;
    }

    public Habitacion getHabitacion() { return habitacion; }
    public Cliente getCliente() { return cliente; }
    public LocalDate getInicio() { return inicio; }
    public LocalDate getFin() { return fin; }
}
