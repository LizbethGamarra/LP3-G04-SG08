public class Contador {
    // Variable de instancia (cada objeto tiene su propio valor)
    private int valor;

    // Variable de clase (compartida por todos los objetos)
    private static int acumulador = 0;

    // Constante de la clase
    public static final int VALOR_INICIAL = 10;

    // Constructor que recibe un valor inicial
    public Contador(int valor) {
        this.valor = valor;
        acumulador += valor; // suma al acumulador
    }

    // Constructor por defecto usando la constante
    public Contador() {
        this(VALOR_INICIAL); // llama al otro constructor
    }

    // Método de instancia: incrementa el valor de ESTE contador
    public void inc() {
        this.valor++;
    }

    // Métodos getters
    public int getValor() {
        return valor;
    }

    public static int getAcumulador() {
        return acumulador;
    }
}
