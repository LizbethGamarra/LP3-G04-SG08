public class CuentaCorriente extends Cuenta {
    private double limiteDescubierto;

    public CuentaCorriente(String numeroCuenta, double saldo, double limiteDescubierto) {
        super(numeroCuenta, saldo);
        this.limiteDescubierto = limiteDescubierto;
    }

    @Override
    public void retirar(double monto) {
        if (monto <= saldo + limiteDescubierto) {
            saldo -= monto;
        } else {
            System.out.println("Límite de descubierto excedido.");
        }
    }

    @Override
    public String toString() {
        return "CuentaCorriente [numeroCuenta=" + numeroCuenta + ", saldo=" + saldo +
                ", limiteDescubierto=" + limiteDescubierto + "]";
    }
}
