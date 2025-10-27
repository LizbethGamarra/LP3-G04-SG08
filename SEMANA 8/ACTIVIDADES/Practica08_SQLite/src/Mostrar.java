import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Mostrar {
    public static void listar() {
        try (Connection con = Conexion.conectar()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM empleados");
            System.out.println("\nLista de empleados:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                                   " Nombre: " + rs.getString("nombre") +
                                   " Edad: " + rs.getInt("edad"));
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar: " + e.getMessage());
        }
    }
}
