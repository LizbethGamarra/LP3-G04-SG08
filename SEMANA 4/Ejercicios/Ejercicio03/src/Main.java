import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        numero numero = new numero(0); 

        System.out.print("Ingrese un número: ");
        double input = sc.nextDouble();

        try {
            numero.setValor(input);
            System.out.println("El número ingresado es: " + numero.getValor());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
