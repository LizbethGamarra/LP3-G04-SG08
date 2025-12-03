public class Main {
    public static void main(String[] args) {
        SistemaNotificaciones sistema = new SistemaNotificaciones();

        Usuario u1 = new Usuario("Lizbeth");
        Usuario u2 = new Usuario("Carlos");
        Usuario u3 = new Usuario("María");

        sistema.suscribir(u1);
        sistema.suscribir(u2);

        sistema.notificar(new Notificacion("Nueva promoción del 50%"));

        System.out.println("------------------------");

        sistema.desuscribir(u2);
        sistema.suscribir(u3);

        sistema.notificar(new Notificacion("Actualización de producto disponible"));
    }
}
