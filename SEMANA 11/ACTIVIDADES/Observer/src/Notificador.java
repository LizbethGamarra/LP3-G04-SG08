
import java.util.ArrayList;
import java.util.List;

public class Notificador {

    private List<Observador> usuarios = new ArrayList<>();

    public void suscribir(Observador o) {
        usuarios.add(o);
    }

    public void desuscribir(Observador o) {
        usuarios.remove(o);
    }

    public void enviarNotificacion(String mensaje) {
        for (Observador o : usuarios) {
            o.actualizar(mensaje);
        }
    }
}
