public class Ejercicio_01 {

    // Clase genérica Par
    public static class Par<F, S> {
        private F primero;
        private S segundo;

        public Par(F primero, S segundo) {
            this.primero = primero;
            this.segundo = segundo;
        }

        public F getPrimero() {
            return primero;
        }

        public void setPrimero(F primero) {
            this.primero = primero;
        }

        public S getSegundo() {
            return segundo;
        }

        public void setSegundo(S segundo) {
            this.segundo = segundo;
        }

        @Override
        public String toString() {
            return "(Primero: " + primero + ", Segundo: " + segundo + ")";
        }
    }

    // Método main para probar
    public static void main(String[] args) {
        Par<String, Integer> par1 = new Par<>("Edad", 20);
        System.out.println("Par1: " + par1);

        // Cambiar el segundo valor
        par1.setSegundo(25);
        System.out.println("Par1 modificado: " + par1);

        Par<Double, Boolean> par2 = new Par<>(3.14, true);
        System.out.println("Par2: " + par2);
    }
}