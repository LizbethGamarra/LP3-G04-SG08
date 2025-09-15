package exp02;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CuentaBancaria {
    private String numeroCuenta;
    private String titular;
    protected double saldo;
    protected List<String> historial = new ArrayList<>();

    private static final DateTimeFormatter DF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial) {
        if (saldoInicial < 0) throw new IllegalArgumentException("Saldo inicial no puede ser negativo");
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void depositar(double monto) {
        if (monto <= 0) throw new IllegalArgumentException("Monto inválido");
        saldo += monto;
        registrar("DEPÓSITO", monto);
    }

    public void retirar(double monto) {
        if (monto <= 0) throw new IllegalArgumentException("Monto inválido");
        if (monto > saldo) throw new SaldoInsuficienteException("Saldo insuficiente. Saldo: " + saldo);
        saldo -= monto;
        registrar("RETIRO", monto);
    }

    public void transferir(CuentaBancaria destino, double monto) {
        if (destino == null) throw new CuentaNoEncontradaException("Cuenta destino no encontrada");
        if (monto > saldo) throw new SaldoInsuficienteException("Saldo insuficiente");
        saldo -= monto;
        destino.saldo += monto;
        registrar("TRANSFERENCIA A " + destino.numeroCuenta, monto);
        destino.registrar("TRANSFERENCIA DESDE " + this.numeroCuenta, monto);
    }

    public void cerrarCuenta() {
        if (saldo != 0) throw new SaldoNoCeroException("La cuenta tiene saldo distinto de cero");
        registrar("CIERRE DE CUENTA", 0);
    }

    protected void registrar(String tipo, double monto) {
        String linea = String.format("%s | %s | %s | %.2f",
                LocalDateTime.now().format(DF), numeroCuenta, tipo, monto);
        historial.add(linea);
    }

    public double getSaldo() { return saldo; }
    public String getNumeroCuenta() { return numeroCuenta; }
}
