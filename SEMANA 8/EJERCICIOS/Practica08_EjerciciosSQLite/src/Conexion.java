import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    public static Connection conectar() {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:empresa.db");
            System.out.println("Conectado a la base de datos SQLite.");
        } catch (Exception e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
        return con;
    }
}
