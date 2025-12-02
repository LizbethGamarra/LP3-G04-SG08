package command;

public class CerrarBarreraCommand implements Command {

    private Barrera barrera;

    public CerrarBarreraCommand(Barrera barrera) {
        this.barrera = barrera;
    }

    @Override
    public void execute() {
        barrera.cerrar();
    }
}
