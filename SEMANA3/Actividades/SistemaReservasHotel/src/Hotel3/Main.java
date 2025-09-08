package Hotel3;

public class Main {
    public static void main(String[] args) {
        ControladorHabitaciones controlador = new ControladorHabitaciones();

        Habitacion h1 = new HabitacionSimple(101, 100.0);
        Habitacion h2 = new HabitacionDoble(102, 150.0);
        Habitacion h3 = new HabitacionSuite(201, 300.0);

        controlador.agregarHabitacion(h1);
        controlador.agregarHabitacion(h2);
        controlador.agregarHabitacion(h3);

        controlador.mostrarPrecios();
    }
}
