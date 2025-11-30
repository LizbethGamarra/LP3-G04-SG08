
public class Televisor {

    private int volumen = 10;
    private int canal = 1;

    public void encender() {
        System.out.println("Televisor encendido");
    }

    public void apagar() {
        System.out.println("Televisor apagado");
    }

    public void subirVolumen() {
        volumen++;
        System.out.println("Volumen: " + volumen);
    }

    public void bajarVolumen() {
        volumen--;
        System.out.println("Volumen: " + volumen);
    }

    public void cambiarCanal() {
        canal++;
        System.out.println("Canal cambiado a: " + canal);
    }
}
