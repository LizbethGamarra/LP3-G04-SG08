import java.util.Scanner;

public class ejercicio_05 {
    
    public static double calcularCargo(int horas) {
        double cargo;
        
        if (horas <= 0) {
            return 0.0;
        }
       
        cargo = 3.0;
        
        if (horas > 1) {
            cargo += (horas - 1) * 0.5;
        }
        
        if (cargo > 12.0) {
            cargo = 12.0;
        }
        
        return cargo;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Ingrese el número de horas: ");
        int horas = sc.nextInt();
        
        double total = calcularCargo(horas);
        System.out.println("El cargo por " + horas + " horas es: S/" + total);
        
        sc.close();
    }
}