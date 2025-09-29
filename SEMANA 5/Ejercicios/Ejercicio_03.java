class Par<F, S> {
    private F primero;
    private S segundo;

    public Par(F primero, S segundo) {
        this.primero = primero;
        this.segundo = segundo;
    }

    public F getPrimero() {
        return primero;
    }

    public S getSegundo() {
        return segundo;
    }
}

class Persona {
    private String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Persona: " + nombre;
    }
}

// Clase principal
public class Ejercicio_03 {
    
    public static <F, S> void imprimirPar(Par<F, S> par) {
        System.out.println("Par -> (" + par.getPrimero() + ", " + par.getSegundo() + ")");
    }

    public static void main(String[] args) {
        Par<String, Integer> par1 = new Par<>("Edad", 20);
        imprimirPar(par1);

        Par<Double, Boolean> par2 = new Par<>(3.14, true);
        imprimirPar(par2);

        Persona p = new Persona("Juan");
        Par<Persona, Integer> par3 = new Par<>(p, 123);
        imprimirPar(par3);
    }
}
