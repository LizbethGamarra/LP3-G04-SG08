
public class MainApp {

    public static void main(String[] args) {

        // Usuarios (Observer)
        Notificador notificador = new Notificador();
        notificador.suscribir(new Usuario("Luis"));
        notificador.suscribir(new Usuario("Carlos"));

        // Producto
        Producto laptop = new Producto("Laptop", 2000);

        // Estrategia elegida (Strategy)
        EstrategiaDescuento descuento = new Descuento10(); // Cambia a new SinDescuento()

        // Command que aplica el descuento
        Command comando = new AplicarDescuentoCommand(laptop, descuento, notificador);

        // Control
        Control control = new Control();
        control.setComando(comando);

        // Ejecutar la acción
        control.presionar();
    }
}
