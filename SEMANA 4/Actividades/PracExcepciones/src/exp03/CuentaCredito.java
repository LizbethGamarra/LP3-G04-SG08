package exp03;

public class CuentaCredito extends CuentaBancaria {
    private double limiteCredito;

    public CuentaCredito(String numeroCuenta, String titular, double saldoInicial, double limiteCredito) {
        super(numeroCuenta, titular, saldoInicial);
        this.limiteCredito = limiteCredito;
    }

    @Override
    public void retirar(double monto) {
        double disponible = saldo + limiteCredito;
        if (monto > disponible) throw new LimiteCreditoExcedidoException("Disponible: " + disponible);
        saldo -= monto;
        registrar("RETIRO (CREDITO)", monto);
    }

    @Override
    public void transferir(CuentaBancaria destino, double monto) {
        if (destino == null) throw new CuentaNoEncontradaException("Cuenta destino no encontrada");
        double disponible = saldo + limiteCredito;
        if (monto > disponible) throw new LimiteCreditoExcedidoException("Disponible: " + disponible);
        saldo -= monto;
        destino.saldo += monto;
        registrar("TRANSFERENCIA A " + destino.getNumeroCuenta(), monto);
        destino.registrar("TRANSFERENCIA DESDE " + this.getNumeroCuenta(), monto);
    }
}