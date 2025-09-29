package Hotel4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Habitacion> lista = new ArrayList<>();

        lista.add(new HabitacionSimple(101, 100.0));
        lista.add(new HabitacionDoble(102, 150.0));
        lista.add(new HabitacionSuite(201, 300.0));

        ControladorServicios controlador = new ControladorServicios(lista);
        controlador.gestionarServicios();
    }
}
