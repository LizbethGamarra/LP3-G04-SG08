package exp04;

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
        if (saldoInicial < 0) throw new IllegalArgumentException("Saldo inicial inválido");
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void depositar(double monto) {
        saldo += monto;
        registrar("DEPÓSITO", monto);
    }

    public void retirar(double monto) {
        if (monto > saldo) throw new SaldoInsuficienteException("Saldo insuficiente");
        saldo -= monto;
        registrar("RETIRO", monto);
    }

    protected void registrar(String tipo, double monto) {
        String linea = String.format("%s | %s | %s | %.2f",
                LocalDateTime.now().format(DF), numeroCuenta, tipo, monto);
        historial.add(linea);
    }

    public String getNumeroCuenta() { return numeroCuenta; }
    public String getTitular() { return titular; }
    public double getSaldo() { return saldo; }
    public java.util.List<String> getHistorial() { return historial; }
}
