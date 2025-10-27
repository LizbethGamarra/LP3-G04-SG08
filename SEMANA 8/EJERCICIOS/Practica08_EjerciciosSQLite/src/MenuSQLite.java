import java.sql.*;
import java.util.Scanner;

public class MenuSQLite {
    static Scanner sc = new Scanner(System.in);
    static final String CLAVE = "7650"; 
    public static void main(String[] args) {
        try (Connection con = Conexion.conectar()) {
            crearTabla(con);

            int opcion;
            do {
                System.out.println("\n MENÚ EMPLEADOS =");
                System.out.println("1. Insertar empleado");
                System.out.println("2. Mostrar empleados");
                System.out.println("3. Actualizar edad");
                System.out.println("4. Borrar empleado");
                System.out.println("5. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1 -> insertar(con);
                    case 2 -> mostrar(con);
                    case 3 -> actualizar(con);
                    case 4 -> borrar(con);
                    case 5 -> System.out.println("Saliendo del programa...");
                    default -> System.out.println("Opción no válida.");
                }
            } while (opcion != 5);

        } catch (Exception e) {
            System.out.println("Error general: " + e.getMessage());
        }
    }

    private static void crearTabla(Connection con) {
        try {
            Statement stmt = con.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS empleados (" +
                         "id INTEGER PRIMARY KEY, nombre TEXT, edad INTEGER)");
            System.out.println("Tabla 'empleados' lista.");
        } catch (SQLException e) {
            System.out.println("Error al crear tabla: " + e.getMessage());
        }
    }


    private static void insertar(Connection con) {
        try {
            con.setAutoCommit(false);
            System.out.print("ID: ");
            int id = sc.nextInt();
            System.out.print("Nombre: ");
            String nombre = sc.next();
            System.out.print("Edad: ");
            int edad = sc.nextInt();

            PreparedStatement ps = con.prepareStatement("INSERT INTO empleados VALUES (?, ?, ?)");
            ps.setInt(1, id);
            ps.setString(2, nombre);
            ps.setInt(3, edad);
            ps.executeUpdate();

            confirmar(con, "insertar");
        } catch (Exception e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }

    private static void mostrar(Connection con) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM empleados");
            System.out.println("\n Lista de empleados:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                                   " Nombre: " + rs.getString("nombre") +
                                   " Edad: " + rs.getInt("edad"));
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar: " + e.getMessage());
        }
    }

    private static void actualizar(Connection con) {
        try {
            con.setAutoCommit(false);
            System.out.print("Ingrese ID del empleado: ");
            int id = sc.nextInt();
            System.out.print("Nueva edad: ");
            int edad = sc.nextInt();

            PreparedStatement ps = con.prepareStatement("UPDATE empleados SET edad=? WHERE id=?");
            ps.setInt(1, edad);
            ps.setInt(2, id);
            ps.executeUpdate();

            confirmar(con, "actualizar");
        } catch (Exception e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }

    private static void borrar(Connection con) {
        try {
            con.setAutoCommit(false);
            System.out.print("Ingrese ID del empleado a eliminar: ");
            int id = sc.nextInt();

            PreparedStatement ps = con.prepareStatement("DELETE FROM empleados WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();

            confirmar(con, "borrar");
        } catch (Exception e) {
            System.out.println("Error al borrar: " + e.getMessage());
        }
    }

    private static void confirmar(Connection con, String operacion) {
        System.out.print("Ingrese clave para confirmar: ");
        String clave = sc.next();
        try {
            if (clave.equals(CLAVE)) {
                con.commit();
                System.out.println(" Operación de " + operacion + " confirmada.");
            } else {
                con.rollback();
                System.out.println(" Clave incorrecta. Operación cancelada.");
            }
        } catch (SQLException e) {
            System.out.println("Error al confirmar: " + e.getMessage());
        }
    }
}
