import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class RegistroEstudiantes {
    private List<String> estudiantes;

    public RegistroEstudiantes() {
        estudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        estudiantes.add(nombre);
        System.out.println("Estudiante agregado: " + nombre);
    }

    public String buscarEstudiante(String nombre) {
        for (String est : estudiantes) {
            if (est.equalsIgnoreCase(nombre)) {
                return est;
            }
        }
        throw new NoSuchElementException("El estudiante '" + nombre + "' no está registrado");
    }
}
