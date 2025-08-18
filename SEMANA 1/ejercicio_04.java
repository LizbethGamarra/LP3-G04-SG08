import java.util.Scanner;

public class ejercicio_04 {
   
    public static double menor(double a, double b, double c) {
        double menor = a; 
        if (b < menor) {
            menor = b;
        }
        if (c < menor) {
            menor = c;
        }
        return menor;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el primer número: ");
        double num1 = scanner.nextDouble();

        System.out.print("Ingrese el segundo número: ");
        double num2 = scanner.nextDouble();

        System.out.print("Ingrese el tercer número: ");
        double num3 = scanner.nextDouble();

        double resultado = menor(num1, num2, num3);

        System.out.println("El menor de los tres números es: " + resultado);

        scanner.close();
    }
}