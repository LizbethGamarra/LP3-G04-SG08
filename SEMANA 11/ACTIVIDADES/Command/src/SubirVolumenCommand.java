
public class SubirVolumenCommand implements Command {

    private Televisor tv;

    public SubirVolumenCommand(Televisor tv) {
        this.tv = tv;
    }

    @Override
    public void ejecutar() {
        tv.subirVolumen();
    }
}

