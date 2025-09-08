package Hotel5;

public class NotificadorReserva {
    private CanalNotificacion canal;

    //  dependencia
    public NotificadorReserva(CanalNotificacion canal) {
        this.canal = canal;
    }

    public void notificar(String mensaje) {
        canal.enviarNotificacion(mensaje);
    }
}
