public class Empleado {
    private int id;
    private String nombre;
    private int edad;

    public Empleado(int id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }

    public void setEdad(int edad) { this.edad = edad; }

    @Override
    public String toString() {
        return "ID: " + id + " Nombre: " + nombre + "  Edad: " + edad;
    }
}
