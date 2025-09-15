import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class PruebaRegistro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RegistroEstudiantes registro = new RegistroEstudiantes();

        int opcion = 0;
        do {
            System.out.println("REGISTRO DE ESTUDIANTES");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Buscar estudiante");
            System.out.println("3. Salir");
            System.out.print("Opción: ");

            try {
                opcion = sc.nextInt();
                sc.nextLine(); 

                switch (opcion) {
                    case 1 -> {
                        System.out.print("Ingrese nombre del estudiante: ");
                        String nombre = sc.nextLine();
                        try {
                            registro.agregarEstudiante(nombre);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                    case 2 -> {
                        System.out.print("Ingrese nombre a buscar: ");
                        String nombre = sc.nextLine();
                        try {
                            String encontrado = registro.buscarEstudiante(nombre);
                            System.out.println("Estudiante encontrado: " + encontrado);
                        } catch (NoSuchElementException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                    case 3 -> System.out.println("Saliendo del sistema...");
                    default -> System.out.println("Opción inválida");
                }

            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número válido.");
                sc.nextLine(); 
                opcion = 0;
            }
        } while (opcion != 3);

        sc.close();
    }
}
