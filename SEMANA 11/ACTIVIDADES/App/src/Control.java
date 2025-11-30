
public class Control {
    private Command comando;

    public void setComando(Command c) {
        comando = c;
    }

    public void presionar() {
        comando.ejecutar();
    }
}