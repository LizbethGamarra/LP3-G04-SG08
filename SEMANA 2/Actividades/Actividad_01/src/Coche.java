public class Coche {
    // Atributos
    private String marca;
    private String modelo;
    private int añoFabricacion;
    private double precio;
    private boolean enMarcha;

    // Constructor por defecto
    public Coche() {
        this.marca = "Desconocida";
        this.modelo = "Genérico";
        this.añoFabricacion = 2000;
        this.precio = 10000.0;
        this.enMarcha = false;
    }

    // Constructor con parámetros
    public Coche(String marca, String modelo, int añoFabricacion, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.añoFabricacion = añoFabricacion;
        this.precio = precio;
        this.enMarcha = false;
    }

    // Métodos
    public boolean aplicarDescuento(double descuento) {
        if (this.añoFabricacion < 2010) {
            this.precio -= descuento;
            System.out.println("Descuento aplicado. Nuevo precio: " + this.precio);
            return true;
        } else {
            System.out.println("No se aplica descuento. Año de fabricación: " + this.añoFabricacion);
            return false;
        }
    }

    public void encender() {
        enMarcha = true;
        System.out.println("El coche " + modelo + " está encendido.");
    }

    public void apagar() {
        enMarcha = false;
        System.out.println("El coche " + modelo + " está apagado.");
    }

    public void acelerar() {
        if (enMarcha) {
            System.out.println("El coche " + modelo + " está acelerando.");
        } else {
            System.out.println("Primero debes encender el coche.");
        }
    }

    public void frenar() {
        if (enMarcha) {
            System.out.println("El coche " + modelo + " está frenando.");
        } else {
            System.out.println("El coche está apagado, no puede frenar.");
        }
    }

    // Getters y setters
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public int getAñoFabricacion() { return añoFabricacion; }
    public void setAñoFabricacion(int añoFabricacion) { this.añoFabricacion = añoFabricacion; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
}
