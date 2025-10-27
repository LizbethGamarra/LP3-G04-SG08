public class Principal {
    public static void main(String[] args) {
        CrearTabla.crear();          
        Insertar.insertar(1, "Carlos", 25);
        Insertar.insertar(2, "Laura", 30);
        Mostrar.listar();
        Actualizar.actualizarEdad(1, 35);
        Borrar.eliminar(2);
        Transaccion.ejecutar();
        Mostrar.listar();
    }
}
