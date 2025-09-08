package Hotel5;

public class Main {
    public static void main(String[] args) {
        // Canal: Correo
        NotificadorReserva notificadorCorreo = new NotificadorReserva(new EnviadorCorreo());
        ControladorReservas controlador1 = new ControladorReservas(notificadorCorreo);
        controlador1.crearReserva("Luis Rodriguez", "Suite 201");

        System.out.println();

        // Canal: SMS
        NotificadorReserva notificadorSMS = new NotificadorReserva(new EnviadorSMS());
        ControladorReservas controlador2 = new ControladorReservas(notificadorSMS);
        controlador2.crearReserva("Ana Gómez", "Habitación 102");

        System.out.println();

        // Canal: Slack
        NotificadorReserva notificadorSlack = new NotificadorReserva(new NotificadorSlack());
        ControladorReservas controlador3 = new ControladorReservas(notificadorSlack);
        controlador3.crearReserva("Carlos Torres", "Habitación 305");
    }
}
