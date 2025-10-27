import java.sql.Connection;
import java.sql.Statement;

public class Transaccion {
    public static void ejecutar() {
        try (Connection con = Conexion.conectar()) {
            con.setAutoCommit(false);
            Statement stmt = con.createStatement();

            try {
                stmt.executeUpdate("INSERT INTO empleados VALUES (10, 'María', 26)");
                stmt.executeUpdate("INSERT INTO empleados VALUES (11, 'Pedro', 29)");
                con.commit();
                System.out.println("Transacción confirmada (commit).");
            } catch (Exception e) {
                con.rollback();
                System.out.println("Error en transacción, rollback realizado.");
            }

        } catch (Exception e) {
            System.out.println("Error general en transacción: " + e.getMessage());
        }
    }
}
