import java.util.Scanner; 

public class ejercicio_06 {

    // Función que convierte horas, minutos y segundos a segundos totales
    public static int convertirASegundos(int horas, int minutos, int segundos) {
        return (horas * 3600) + (minutos * 60) + segundos; // Calcula el total en segundos
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Creamos un lector de datos

        System.out.print("Ingrese horas: ");
        int horas = sc.nextInt(); // Guardamos las horas ingresadas

        System.out.print("Ingrese minutos: ");
        int minutos = sc.nextInt(); // Guardamos los minutos ingresados

        System.out.print("Ingrese segundos: ");
        int segundos = sc.nextInt(); // Guardamos los segundos ingresados

        int totalSegundos = convertirASegundos(horas, minutos, segundos); // Llamamos a la función

        System.out.println("El tiempo total en segundos es: " + totalSegundos); 

        sc.close(); 
    }
}
