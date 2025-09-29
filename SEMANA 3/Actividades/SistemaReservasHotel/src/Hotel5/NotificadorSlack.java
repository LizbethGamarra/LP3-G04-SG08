package Hotel5;

public class NotificadorSlack implements CanalNotificacion {
    @Override
    public void enviarNotificacion(String mensaje) {
        System.out.println("Enviando mensaje a Slack: " + mensaje);
    }
}
