public class PruebaPila {
    public static void main(String[] args) {
        try {
            Pila<Integer> pilaEnteros = new Pila<>(5);
            pilaEnteros.push(10);
            pilaEnteros.push(20);
            pilaEnteros.push(30);

            System.out.println("¿Contiene 20? " + pilaEnteros.contains(20));
            System.out.println("Elemento sacado: " + pilaEnteros.pop());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
