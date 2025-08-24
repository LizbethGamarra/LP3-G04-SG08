public class EjemploContador {
    public static void main(String[] args) {
        // Crear dos contadores
        Contador c1 = new Contador(5);
        Contador c2 = new Contador(7);

        // Incrementar c1
        c1.inc();

        // Imprimir resultados
        System.out.println("Valor de c1: " + c1.getValor());
        System.out.println("Valor de c2: " + c2.getValor());
        System.out.println("Valor del acumulador: " + Contador.getAcumulador());

        // Crear un contador con el constructor por defecto
        Contador c3 = new Contador();
        System.out.println("Valor de c3: " + c3.getValor());
        System.out.println("Valor del acumulador actualizado: " + Contador.getAcumulador());
    }
}
