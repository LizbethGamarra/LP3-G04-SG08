package command;

public class AbrirBarreraCommand implements Command {

    private Barrera barrera;

    public AbrirBarreraCommand(Barrera barrera) {
        this.barrera = barrera;
    }

    @Override
    public void execute() {
        barrera.abrir();
    }
}
