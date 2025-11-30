
public class MainObserver {

    public static void main(String[] args) {

        Notificador notificador = new Notificador();

        Observador u1 = new Usuario("Luis");
        Observador u2 = new Usuario("Jesica");
        Observador u3 = new Usuario("Carlos");

        // Suscribir usuarios
        notificador.suscribir(u1);
        notificador.suscribir(u2);
        notificador.suscribir(u3);

        notificador.enviarNotificacion("Nueva promoción en productos!");

        System.out.println("\nCarlos se desuscribe...\n");

        notificador.desuscribir(u3);

        notificador.enviarNotificacion("Actualización del sistema disponible.");
    }
}
