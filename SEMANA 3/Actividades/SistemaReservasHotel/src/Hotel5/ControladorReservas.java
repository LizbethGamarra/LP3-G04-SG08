package Hotel5;

public class ControladorReservas {
    private NotificadorReserva notificador;

    public ControladorReservas(NotificadorReserva notificador) {
        this.notificador = notificador;
    }

    public void crearReserva(String cliente, String habitacion) {
        String mensaje = "Reserva creada para " + cliente + " en la habitación " + habitacion;
        System.out.println(mensaje);
        notificador.notificar(mensaje);
    }
}
