package exp04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class ReporteTransacciones {

    public static void generarReporte(CuentaBancaria cuenta, String rutaArchivo) throws IOException {
        List<String> historial = cuenta.getHistorial();
        if (historial.isEmpty()) throw new HistorialVacioException("No hay transacciones");
        try (PrintWriter pw = new PrintWriter(new FileWriter(rutaArchivo))) {
            pw.println("REPORTE DE TRANSACCIONES");
            pw.println("NumeroCuenta: " + cuenta.getNumeroCuenta());
            pw.println("Titular: " + cuenta.getTitular());
            pw.printf("Saldo: %.2f%n", cuenta.getSaldo());
            for (String linea : historial) {
                pw.println(linea);
            }
        }
    }

    public static void leerTransaccionesDesdeArchivo(String rutaArchivo) throws FileNotFoundException {
        File f = new File(rutaArchivo);
        try (Scanner sc = new Scanner(f)) {
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        }
    }
}
