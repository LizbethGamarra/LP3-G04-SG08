import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PedidoModelo {
    private List<Pedido> pedidos;
    private List<Pedido> historial;

    public PedidoModelo() {
        pedidos = new ArrayList<>();
        historial = new ArrayList<>();
    }

    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void eliminarPedido(String nombre) {
        for (Pedido p : pedidos) {
            if (p.getNombrePlato().equalsIgnoreCase(nombre) && !p.getEstado().equals("Eliminado")) {
                p.setEstado("Eliminado");
                historial.add(p);
                return;
            }
        }
    }

    public void marcarCompleto(String nombre) {
        for (Pedido p : pedidos) {
            if (p.getNombrePlato().equalsIgnoreCase(nombre) && p.getEstado().equals("Pendiente")) {
                p.setEstado("Completo");
                historial.add(p);
                return;
            }
        }
    }

    public Pedido buscarPedido(String nombre) {
        for (Pedido p : pedidos) {
            if (p.getNombrePlato().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

    public List<Pedido> obtenerPorEstado(String estado) {
        return pedidos.stream()
                .filter(p -> p.getEstado().equalsIgnoreCase(estado))
                .collect(Collectors.toList());
    }

    public int contarPendientes() {
        return (int) pedidos.stream()
                .filter(p -> p.getEstado().equalsIgnoreCase("Pendiente"))
                .count();
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public List<Pedido> getHistorial() {
        return historial;
    }
}
