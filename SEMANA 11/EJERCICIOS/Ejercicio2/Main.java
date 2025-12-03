import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Producto[] lista = {
            new Producto("Laptop", 3000),
            new Producto("Laptop", 3000),
            new Producto("Mouse", 50),
            new Producto("Teclado", 80)
        };

        System.out.println("Seleccione estrategia:");
        System.out.println("1. Sin Descuento");
        System.out.println("2. Descuento Fijo (10%)");
        System.out.println("3. Descuento Porcentual (2 iguales 30%)");
        System.out.println("4. Descuento Porcentual Acumulado (3 productos, -50% al más barato)");

        int opcion = sc.nextInt();

        CalculadoraDePrecios calc = new CalculadoraDePrecios();

        switch (opcion) {
            case 1 -> calc.setEstrategia(new SinDescuento());
            case 2 -> calc.setEstrategia(new DescuentoFijo());
            case 3 -> calc.setEstrategia(new DescuentoPorcentual());
            case 4 -> calc.setEstrategia(new DescuentoPorcentualAcumulado());
            default -> {
                System.out.println("Opción no válida");
                return;
            }
        }

        double total = calc.calcular(lista);
        System.out.println("Precio final: " + total);
    }
}
