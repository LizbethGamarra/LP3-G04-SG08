import java.sql.Connection;
import java.sql.PreparedStatement;

public class Borrar {
    public static void eliminar(int id) {
        try (Connection con = Conexion.conectar()) {
            String sql = "DELETE FROM empleados WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Registro con ID " + id + " eliminado.");
        } catch (Exception e) {
            System.out.println("Error al borrar: " + e.getMessage());
        }
    }
}
