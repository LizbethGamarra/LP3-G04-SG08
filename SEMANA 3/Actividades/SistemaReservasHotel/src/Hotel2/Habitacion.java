package Hotel2;

public class Habitacion {
    private int id;
    private String tipo;
    private double precioBase;
    private String estado;

    public Habitacion(int id, String tipo, double precioBase, Object gestor) {
        this.id = id;
        this.tipo = tipo;
        this.precioBase = precioBase;
        this.estado = "Disponible";
    }

    public int getId() { return id; }
    public String getTipo() { return tipo; }
    public double getPrecioBase() { return precioBase; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
