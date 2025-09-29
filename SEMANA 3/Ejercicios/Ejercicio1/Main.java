package Ejercicio1;

public class Main {
    public static void main(String[] args) {
        Empleado emp = new Empleado("Carlos", 48000, "IT");
        PagoMensual calc = new PagoMensual();
        
        double pagoMensual = calc.calcularPagoMensual(emp);
        System.out.println("El pago mensual de " + emp.getNombre() + " es: " + pagoMensual);
    }
}
