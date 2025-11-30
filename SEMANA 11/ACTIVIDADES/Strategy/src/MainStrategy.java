
import java.util.Scanner;

public class MainStrategy {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Producto p = new Producto("Celular", 1000);

        CalculadoraPrecios calc = new CalculadoraPrecios();

        System.out.println("Selecciona la estrategia:");
        System.out.println("1. Sin descuento");
        System.out.println("2. Descuento fijo 10%");
        System.out.println("3. 30% si compras 2 iguales");
        System.out.println("4. 50% al menor si compras 3");

        int op = sc.nextInt();

        switch(op) {
            case 1: calc.setEstrategia(new SinDescuento()); break;
            case 2: calc.setEstrategia(new DescuentoFijo()); break;
            case 3: calc.setEstrategia(new DescuentoPorcentual()); break;
            case 4: calc.setEstrategia(new DescuentoPorcentualAcumulado()); break;
            default:
                System.out.println("Opción inválida");
                return;
        }

        System.out.print("Cantidad de productos: ");
        int cantidad = sc.nextInt();

        double total = calc.calcular(p, cantidad);

        System.out.println("\nTotal a pagar: $" + total);
    }
}
