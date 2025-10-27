import java.sql.*;
import java.util.*;

public class GestorEmpleados {
    private List<Empleado> empleados = new ArrayList<>();

    public void cargarDesdeBD() {
        empleados.clear();
        try (Connection con = Conexion.conectar()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM empleados");
            while (rs.next()) {
                empleados.add(new Empleado(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getInt("edad")
                ));
            }
            System.out.println(" Empleados cargados desde la base de datos: " + empleados.size());
        } catch (SQLException e) {
            System.out.println(" Error al cargar empleados: " + e.getMessage());
        }
    }

    public void mostrarTodos() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados cargados.");
            return;
        }
        empleados.forEach(System.out::println);
    }
    
    public void filtrarPorEdadMayorQue(int edadMin) {
        System.out.println("\n Empleados con edad > " + edadMin + ":");
        empleados.stream()
                 .filter(e -> e.getEdad() > edadMin)
                 .forEach(System.out::println);
    }

    public void ordenarPorEdad(boolean asc) {
        empleados.sort((e1, e2) -> asc ? e1.getEdad() - e2.getEdad() : e2.getEdad() - e1.getEdad());
        System.out.println("\n Empleados ordenados por edad (" + (asc ? "ASC" : "DESC") + "):");
        mostrarTodos();
    }

    public void mostrarLimitado(int cantidad) {
        System.out.println("\n Primeros " + cantidad + " empleados:");
        empleados.stream().limit(cantidad).forEach(System.out::println);
    }
}
