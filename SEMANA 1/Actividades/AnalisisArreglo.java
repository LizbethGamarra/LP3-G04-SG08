import java.util.Scanner;

public class AnalisisArreglo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el tamaño del arreglo: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("El tamaño del arreglo debe ser mayor que cero.");
            scanner.close();
            return;
        }

        int[] arreglo = new int[n];

        System.out.println("Introduce los elementos del arreglo:");
        leerArreglo(scanner, arreglo);

        double promedio = calcularPromedio(arreglo);
        System.out.println("El promedio de los elementos es: " + promedio);

        scanner.close();
    }

    public static void leerArreglo(Scanner scanner, int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = scanner.nextInt();
        }
    }

    public static double calcularPromedio(int[] arreglo) {
        int suma = 0;
        for (int i = 0; i < arreglo.length; i++) {
            suma += arreglo[i];
        }
        return (double) suma / arreglo.length;
    }
}
