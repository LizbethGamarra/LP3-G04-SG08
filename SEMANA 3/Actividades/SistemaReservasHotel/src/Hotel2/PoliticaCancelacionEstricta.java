package Hotel2;

public class PoliticaCancelacionEstricta implements PoliticaCancelacion {
    @Override
    public boolean puedeCancelar(Reserva reserva) {
        return false; // nunca se permite cancelar
    }
}
