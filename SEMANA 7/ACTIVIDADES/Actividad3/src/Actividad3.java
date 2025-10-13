import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Actividad3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el número de filas: ");
        int filas = sc.nextInt();

        System.out.print("Ingrese el número de columnas: ");
        int columnas = sc.nextInt();

        double[][] matriz = new double[filas][columnas];

        System.out.println("\nIngrese los valores de la matriz:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextDouble();
            }
        }

        String nombreArchivo = "matriz.dat"; 

        try (DataOutputStream salida = new DataOutputStream(new FileOutputStream(nombreArchivo))) {
            salida.writeInt(filas);
            salida.writeInt(columnas);

            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    salida.writeDouble(matriz[i][j]);
                }
            }

            System.out.println("\nLa matriz ha sido guardada en el archivo " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }

        sc.close();
    }
}
