import java.util.List;

public class PedidoControlador {
    private PedidoModelo modelo;
    private PedidoVista vista;

    public PedidoControlador(PedidoModelo modelo, PedidoVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        String opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.solicitarOpcion();

            switch (opcion) {
                case "1":
                    String nombre = vista.solicitarNombrePlato();
                    if (!nombre.isEmpty()) {
                        modelo.agregarPedido(new Pedido(nombre));
                        vista.mostrarMensaje("Pedido agregado: " + nombre);
                    } else {
                        vista.mostrarMensaje("El nombre no puede estar vacío.");
                    }
                    break;
                case "2":
                    vista.mostrarPedidos(modelo.getPedidos());
                    break;
                case "3":
                    vista.mostrarMensaje("Saliendo.");
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida.");
            }
        } while (!opcion.equals("3"));

        vista.cerrarScanner();
    }
}
