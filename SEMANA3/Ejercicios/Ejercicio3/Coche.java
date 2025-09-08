package Ejercicio3;

public class Coche implements VehiculoMotorizado {
    @Override
    public void acelerar() {
        System.out.println("El coche acelera con motor");
    }

    @Override
    public void encenderMotor() {
        System.out.println("El motor del coche ha sido encendido");
    }
}
