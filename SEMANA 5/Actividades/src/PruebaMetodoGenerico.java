public class PruebaMetodoGenerico {

    // Método genérico para imprimir cualquier arreglo
    public static <E> void imprimirArreglo(E[] arregloEntrada) {
        for (E elemento : arregloEntrada) {
            System.out.printf("%s ", elemento);
        }
        System.out.println();
    }

    // Método sobrecargado: imprime parte del arreglo (entre dos índices)
    public static <E> void imprimirArreglo(E[] arregloEntrada, int inicio, int fin) throws ExcepcionSubindiceInvalido {
        if (inicio < 0 || fin > arregloEntrada.length || inicio >= fin) {
            throw new ExcepcionSubindiceInvalido("Índices inválidos.");
        }
        for (int i = inicio; i < fin; i++) {
            System.out.printf("%s ", arregloEntrada[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] enteros = {1, 2, 3, 4, 5};
        String[] cadenas = {"Hola", "Mundo", "Java"};

        System.out.println("Arreglo completo:");
        imprimirArreglo(enteros);

        System.out.println("\nSubarreglo:");
        try {
            imprimirArreglo(cadenas, 0, 2);
        } catch (ExcepcionSubindiceInvalido e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

