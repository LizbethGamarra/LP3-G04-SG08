import java.util.ArrayList;
import java.util.List;

public class SistemaNotificaciones implements Subject {
    private List<Observer> observadores = new ArrayList<>();

    @Override
    public void suscribir(Observer o) {
        observadores.add(o);
        System.out.println("Se suscribió: " + ((Usuario)o).getNombre());
    }

    @Override
    public void desuscribir(Observer o) {
        observadores.remove(o);
        System.out.println("Se desuscribió: " + ((Usuario)o).getNombre());
    }

    @Override
    public void notificar(Notificacion notificacion) {
        for (Observer o : observadores) {
            o.actualizar(notificacion);
        }
    }
}
