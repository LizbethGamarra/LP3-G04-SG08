public class IgualGenerico {

    // Método genérico para comparar dos elementos
    public static <T> boolean esIgualA(T a, T b) {
        if (a == null || b == null) {
            return false;
        }
        return a.equals(b);
    }

    public static void main(String[] args) {
        System.out.println("Comparar enteros: " + esIgualA(5, 5));
        System.out.println("Comparar cadenas: " + esIgualA("Hola", "Mundo"));
        System.out.println("Comparar objetos nulos: " + esIgualA(null, "Texto"));
    }
}
