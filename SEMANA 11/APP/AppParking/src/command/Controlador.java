package command;

public class Controlador {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void ejecutar() {
        if (command != null) {
            command.execute();
        }
    }
}
