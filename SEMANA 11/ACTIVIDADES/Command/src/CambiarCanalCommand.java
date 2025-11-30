
public class CambiarCanalCommand implements Command {

    private Televisor tv;

    public CambiarCanalCommand(Televisor tv) {
        this.tv = tv;
    }

    @Override
    public void ejecutar() {
        tv.cambiarCanal();
    }
}
