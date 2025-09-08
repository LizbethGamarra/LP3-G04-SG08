package Hotel2;

import java.time.LocalDate;

public class PoliticaCancelacionFlexible implements PoliticaCancelacion {
    @Override
    public boolean puedeCancelar(Reserva reserva) {
        return LocalDate.now().isBefore(reserva.getInicio().minusDays(1));
    }
}
