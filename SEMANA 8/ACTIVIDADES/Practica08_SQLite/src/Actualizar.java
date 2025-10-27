import java.sql.Connection;
import java.sql.PreparedStatement;

public class Actualizar {
    public static void actualizarEdad(int id, int nuevaEdad) {
        try (Connection con = Conexion.conectar()) {
            String sql = "UPDATE empleados SET edad=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, nuevaEdad);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Edad actualizada para ID " + id);
        } catch (Exception e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }
}
