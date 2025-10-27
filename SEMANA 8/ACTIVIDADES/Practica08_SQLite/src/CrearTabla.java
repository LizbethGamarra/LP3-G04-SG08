import java.sql.Connection;
import java.sql.Statement;

public class CrearTabla {
    public static void crear() {
        try (Connection con = Conexion.conectar()) {
            Statement stmt = con.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS empleados (" +
                         "id INTEGER PRIMARY KEY, " +
                         "nombre TEXT, " +
                         "edad INTEGER)";
            stmt.execute(sql);
            System.out.println("Tabla 'empleados' creada o ya existente.");
        } catch (Exception e) {
            System.out.println("Error al crear tabla: " + e.getMessage());
        }
    }
}
