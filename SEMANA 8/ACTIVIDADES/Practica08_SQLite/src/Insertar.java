import java.sql.Connection;
import java.sql.PreparedStatement;

public class Insertar {
    public static void insertar(int id, String nombre, int edad) {
        try (Connection con = Conexion.conectar()) {
            String sql = "INSERT INTO empleados (id, nombre, edad) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, nombre);
            ps.setInt(3, edad);
            ps.executeUpdate();
            System.out.println("Registro insertado: " + nombre);
        } catch (Exception e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }
}
