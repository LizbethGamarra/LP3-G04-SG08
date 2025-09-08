package Ejercicio1;

public class PagoMensual {
    public double calcularPagoMensual(Empleado empleado) {
        return empleado.getSalario() / 12;
    }
}
