public class Ejercicio_02 {

    // Clase genérica Par con método esIgual
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

        // Método para comparar dos pares
        public boolean esIgual(Par<F, S> otroPar) {
            return this.primero.equals(otroPar.getPrimero()) &&
                   this.segundo.equals(otroPar.getSegundo());
        }

        @Override
        public String toString() {
            return "(Primero: " + primero + ", Segundo: " + segundo + ")";
        }
    }

    // Método main para probar
    public static void main(String[] args) {
        Par<String, Integer> par1 = new Par<>("Edad", 20);
        Par<String, Integer> par2 = new Par<>("Edad", 20);
        Par<String, Integer> par3 = new Par<>("Altura", 20);

        System.out.println("Par1: " + par1);
        System.out.println("Par2: " + par2);
        System.out.println("Par3: " + par3);

        System.out.println("¿Par1 es igual a Par2? " + par1.esIgual(par2)); // true
        System.out.println("¿Par1 es igual a Par3? " + par1.esIgual(par3)); // false
    }
}