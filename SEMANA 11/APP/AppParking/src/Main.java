import java.util.Scanner;
import java.util.Map;

import command.*;
import observer.*;
import strategy.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ParkingLot parking = new ParkingLot(5); 
        parking.attach(new User("Admin"));
        parking.attach(new User("Seguridad"));

        Barrera barrera = new Barrera();
        Controlador control = new Controlador();

        int opcion;

        do {
            System.out.println("\n=== SISTEMA PARKING INTELIGENTE ===");
            System.out.println("1. Ingresar vehículo");
            System.out.println("2. Ver espacios disponibles");
            System.out.println("3. Registrar salida de vehículo");
            System.out.println("4. Listar vehículos dentro del parking");
            System.out.println("0. Salir");
            System.out.print("Ingrese opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {

            case 1:
                System.out.print("Ingrese placa del vehículo: ");
                String placa = sc.nextLine();

                System.out.println("Seleccione tarifa:");
                System.out.println("1. Normal (S/3 por hora)");
                System.out.println("2. Nocturna (S/2 por hora)");
                System.out.println("3. Fin de semana (S/4 por hora)");
                int t = sc.nextInt();

                TarifaStrategy tarifa = null;
                switch (t) {
                    case 1: tarifa = new TarifaNormal(); break;
                    case 2: tarifa = new TarifaNocturna(); break;
                    case 3: tarifa = new TarifaFinDeSemana(); break;
                    default:
                        System.out.println("Opción inválida.");
                        break;
                }

                if (tarifa == null) break;

                control.setCommand(new AbrirBarreraCommand(barrera));
                control.ejecutar();

                parking.registrarEntrada(placa, tarifa);

                control.setCommand(new CerrarBarreraCommand(barrera));
                control.ejecutar();

                System.out.println("Vehículo ingresado correctamente.");
                break;

            case 2:
                System.out.println("Vehículos dentro: " + parking.getOccupied());
                System.out.println("Espacios disponibles: " + (parking.getCapacity() - parking.getOccupied()));
                break;

            case 3:
                System.out.print("Ingrese placa del vehículo: ");
                String placaSalida = sc.nextLine();

                System.out.print("Ingrese horas estacionado: ");
                double horas = sc.nextDouble();

                double total = parking.registrarSalida(placaSalida, horas);

                if (total >= 0) {
                    System.out.println("Total a pagar: S/ " + total);
                } else {
                    System.out.println(" La placa no existe en el parking.");
                }

                break;

            case 4:
                System.out.println("\n=== VEHÍCULOS DENTRO DEL PARKING ===");

                if (parking.getRegistros().isEmpty()) {
                    System.out.println("No hay vehículos dentro actualmente.");
                } else {
                    for (Map.Entry<String, TarifaStrategy> entry : parking.getRegistros().entrySet()) {
                        System.out.println("Placa: " + entry.getKey() +
                                " | Tarifa: " + entry.getValue().getClass().getSimpleName());
                    }
                }
                break;

            case 0:
                System.out.println("Saliendo...");
                break;

            default:
                System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}



