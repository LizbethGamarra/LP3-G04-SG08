package exp04;

import java.io.FileNotFoundException;
import java.io.IOException;

public class PruebaExp4 {
    public static void main(String[] args) {
        CuentaBancaria c = new CuentaBancaria("500", "Gino", 0);

        try {
            ReporteTransacciones.generarReporte(c, "reporte500.txt");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        c.depositar(1000);
        c.retirar(200);

        try {
            ReporteTransacciones.generarReporte(c, "reporte500.txt");
            ReporteTransacciones.leerTransaccionesDesdeArchivo("reporte500.txt");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            ReporteTransacciones.leerTransaccionesDesdeArchivo("noExiste.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
