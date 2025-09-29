public class Pila<E> {
    private final int tamanio;
    private int tope;
    private E[] elementos;

    // Constructor por defecto
    public Pila() {
        this(10);
    }

    // Constructor con tamaño personalizado
    @SuppressWarnings("unchecked")
    public Pila(int s) {
        tamanio = s > 0 ? s : 10;
        tope = -1;
        elementos = (E[]) new Object[tamanio];
    }

    // Insertar elemento
    public void push(E valor) throws Exception {
        if (tope == tamanio - 1) {
            throw new Exception("La pila está llena");
        }
        elementos[++tope] = valor;
    }

    // Sacar elemento
    public E pop() throws Exception {
        if (tope == -1) {
            throw new Exception("La pila está vacía");
        }
        return elementos[tope--];
    }

    // Verificar si un elemento existe en la pila
    public boolean contains(E elemento) {
        for (int i = tope; i >= 0; i--) {
            if (elementos[i].equals(elemento)) {
                return true;
            }
        }
        return false;
    }
}
