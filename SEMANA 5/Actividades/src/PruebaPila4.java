public class PruebaPila4 {
    public static void main(String[] args) {
        try {
            // Crear dos pilas de enteros
            Pila4<Integer> pila1 = new Pila4<>(5);
            Pila4<Integer> pila2 = new Pila4<>(5);

            // Insertar elementos en ambas pilas
            pila1.push(1);
            pila1.push(2);
            pila1.push(3);

            pila2.push(1);
            pila2.push(2);
            pila2.push(3);

            // Comparar pilas
            System.out.println("¿Son iguales pila1 y pila2? " + pila1.esIgual(pila2));

            // Modificar una pila
            pila2.pop();
            pila2.push(4);

            // Comparar nuevamente
            System.out.println("¿Son iguales después de modificar pila2? " + pila1.esIgual(pila2));

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
