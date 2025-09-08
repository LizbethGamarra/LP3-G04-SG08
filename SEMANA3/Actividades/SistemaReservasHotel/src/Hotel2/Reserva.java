package Hotel2;

import java.time.LocalDate;

public class Reserva {
    private Habitacion habitacion;
    private Cliente cliente;
    private LocalDate inicio;
    private LocalDate fin;
    private PoliticaCancelacion politica;

    public Reserva(Habitacion habitacion, Cliente cliente, LocalDate inicio, LocalDate fin, PoliticaCancelacion politica) {
        this.habitacion = habitacion;
        this.cliente = cliente;
        this.inicio = inicio;
        this.fin = fin;
        this.politica = politica;
    }

    public boolean puedeCancelar() {
        return politica.puedeCancelar(this);
    }

    // Getters
    public LocalDate getInicio() { return inicio; }
    public LocalDate getFin() { return fin; }
    public Cliente getCliente() { return cliente; }
    public Habitacion getHabitacion() { return habitacion; }
}
