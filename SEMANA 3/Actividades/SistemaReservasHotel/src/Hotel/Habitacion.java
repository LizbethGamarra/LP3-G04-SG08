package Hotel;

import java.time.LocalDate;

public class Habitacion {
    private int id;
    private String tipo;
    private double precioBase;
    private String estado;
    private GestorDisponibilidadHabitacion gestor;

    public Habitacion(int id, String tipo, double precioBase, GestorDisponibilidadHabitacion gestor) {
        this.id = id;
        this.tipo = tipo;
        this.precioBase = precioBase;
        this.estado = "Disponible";
        this.gestor = gestor;
    }

    public boolean verificarDisponibilidad(LocalDate inicio, LocalDate fin) {
        return gestor.estaDisponible(this, inicio, fin);
    }

    public double obtenerPrecio(LocalDate inicio, LocalDate fin) {
        return gestor.calcularPrecio(this, inicio, fin);
    }

    public int getId() { return id; }
    public String getTipo() { return tipo; }
    public double getPrecioBase() { return precioBase; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
