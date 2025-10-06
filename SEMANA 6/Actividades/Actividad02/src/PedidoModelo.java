import java.util.ArrayList;
import java.util.List;

public class PedidoModelo {
    private List<Pedido> pedidos;

    public PedidoModelo() {
        pedidos = new ArrayList<>();
    }

    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void eliminarPedido(String nombre) {
        pedidos.removeIf(p -> p.getNombrePlato().equalsIgnoreCase(nombre));
    }

    public Pedido buscarPedido(String nombre) {
        for (Pedido p : pedidos) {
            if (p.getNombrePlato().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

    public int contarPedidos() {
        return pedidos.size();
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
}

