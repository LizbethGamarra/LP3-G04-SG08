public class EjemploHerencia {
    public static void main(String[] args) {
        // Crear cuentas
        CuentaAhorro ahorro = new CuentaAhorro("A123", 5000, 0.05);
        CuentaCorriente corriente = new CuentaCorriente("C456", 2000, 1000);

        // Probar métodos comunes
        ahorro.depositar(1000);
        corriente.depositar(500);

        // Probar métodos específicos
        ahorro.aplicarInteres();
        corriente.retirar(2500); // puede usar el descubierto

        // Mostrar resultados
        System.out.println(ahorro);
        System.out.println(corriente);
    }
}
