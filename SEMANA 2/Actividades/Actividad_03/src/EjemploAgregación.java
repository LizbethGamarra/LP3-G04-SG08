
public class EjemploAgregación {
    public static void main(String[] args) {
        // Crear motores independientes
        Motor motor1 = new Motor("Gasolina", 180);
        Motor motor2 = new Motor("Diésel", 220);

        // Asignar motores a automóviles
        Automovil auto1 = new Automovil("Toyota", "Corolla", motor1);
        Automovil auto2 = new Automovil("Ford", "Ranger", motor2);

        // Mostrar datos
        System.out.println(auto1);
        System.out.println(auto2);
    }
}
