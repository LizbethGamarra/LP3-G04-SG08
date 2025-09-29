public class Pila4<E> {
    private final int tamanio;
    private int tope;
    private E[] elementos;

    // Constructor por defecto
    public Pila4() {
        this(10);
    }

    // Constructor con tamaño definido
    @SuppressWarnings("unchecked")
    public Pila4(int s) {
        tamanio = s > 0 ? s : 10;
        tope = -1;
        elementos = (E[]) new Object[tamanio];
    }

    // Insertar un elemento en la pila
    public void push(E valor) throws Exception {
        if (tope == tamanio - 1) {
            throw new Exception("La pila está llena");
        }
        elementos[++tope] = valor;
    }

    // Retirar un elemento de la pila
    public E pop() throws Exception {
        if (tope == -1) {
            throw new Exception("La pila está vacía");
        }
        return elementos[tope--];
    }

    // Comparar dos pilas (mismo tamaño y mismos elementos en el mismo orden)
    public boolean esIgual(Pila4<E> otraPila) {
        if (this.tope != otraPila.tope) {
            return false;
        }
        for (int i = 0; i <= tope; i++) {
            if (!this.elementos[i].equals(otraPila.elementos[i])) {
                return false;
            }
        }
        return true;
    }
}
