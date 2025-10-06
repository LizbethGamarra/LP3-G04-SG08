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
            vista.mostrarMenuExtendido();
            opcion = vista.solicitarOpcion();

            switch (opcion) {
                case "1":
                    String nombre = vista.solicitarNombrePlato();
                    String tipo = vista.solicitarTipoPlato();
                    modelo.agregarPedido(new Pedido(nombre, tipo));
                    vista.mostrarMensaje(" Pedido agregado: " + nombre);
                    break;
                case "2":
                    vista.mostrarPedidos(modelo.getPedidos());
                    break;
                case "3":
                    String eliminar = vista.solicitarNombrePlato();
                    modelo.eliminarPedido(eliminar);
                    vista.mostrarMensaje(" Pedido eliminado (si existía).");
                    break;
                case "4":
                    String buscar = vista.solicitarNombrePlato();
                    Pedido encontrado = modelo.buscarPedido(buscar);
                    if (encontrado != null)
                        vista.mostrarMensaje("Encontrado: " + encontrado);
                    else
                        vista.mostrarMensaje("No encontrado.");
                    break;
                case "5":
                    vista.mostrarMensaje("Total de pedidos: " + modelo.contarPedidos());
                    break;
                case "6":
                    vista.mostrarMensaje("Saliendo...");
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida.");
            }
        } while (!opcion.equals("6"));
    }
}
