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
                    String tipo = vista.solicitarTipoPlato();
                    modelo.agregarPedido(new Pedido(nombre, tipo));
                    vista.mostrarMensaje(" Pedido agregado correctamente.");
                    break;

                case "2":
                    vista.mostrarPedidos(modelo.getPedidos());
                    break;

                case "3":
                    String nombreCompletar = vista.solicitarNombrePlato();
                    modelo.marcarCompleto(nombreCompletar);
                    vista.mostrarMensaje(" Pedido marcado como completo (si existía).");
                    break;

                case "4":
                    String nombreEliminar = vista.solicitarNombrePlato();
                    modelo.eliminarPedido(nombreEliminar);
                    vista.mostrarMensaje(" Pedido eliminado (si existía).");
                    break;

                case "5":
                    vista.mostrarPedidos(modelo.obtenerPorEstado("Pendiente"));
                    break;

                case "6":
                    vista.mostrarPedidos(modelo.obtenerPorEstado("Completo"));
                    break;

                case "7":
                    vista.mostrarMensaje("Pedidos pendientes: " + modelo.contarPendientes());
                    break;

                case "8":
                    vista.mostrarPedidos(modelo.getHistorial());
                    break;

                case "9":
                    String buscar = vista.solicitarNombrePlato();
                    Pedido encontrado = modelo.buscarPedido(buscar);
                    if (encontrado != null) {
                        vista.mostrarMensaje("Encontrado: " + encontrado);
                    } else {
                        vista.mostrarMensaje("No se encontró ningún pedido con ese nombre.");
                    }
                    break;

                case "10":
                    vista.mostrarMensaje(" Saliendo del sistema...");
                    break;

                default:
                    vista.mostrarMensaje("⚠ Opción no válida. Intenta de nuevo.");
            }
        } while (!opcion.equals("10"));

        vista.cerrarScanner();
    }
}
