public class CuentaAhorro extends Cuenta {
    private double tasaInteres;

    public CuentaAhorro(String numeroCuenta, double saldo, double tasaInteres) {
        super(numeroCuenta, saldo);
        this.tasaInteres = tasaInteres;
    }

    public void aplicarInteres() {
        double interes = saldo * tasaInteres;
        depositar(interes);
        System.out.println("Interés aplicado: " + interes);
    }

    @Override
    public String toString() {
        return "CuentaAhorro [numeroCuenta=" + numeroCuenta + ", saldo=" + saldo + ", tasaInteres=" + tasaInteres + "]";
    }
}
