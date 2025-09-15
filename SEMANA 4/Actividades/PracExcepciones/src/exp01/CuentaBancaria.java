package exp01;

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
        if (numeroCuenta == null || numeroCuenta.isBlank()) throw new IllegalArgumentException("Número de cuenta inválido");
        if (titular == null || titular.isBlank()) throw new IllegalArgumentException("Titular inválido");
        if (saldoInicial < 0) throw new IllegalArgumentException("Saldo inicial no puede ser negativo");
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void depositar(double monto) {
        if (monto <= 0) throw new IllegalArgumentException("El monto a depositar debe ser positivo");
        saldo += monto;
        registrar("DEPÓSITO", monto);
    }

    public void retirar(double monto) {
        if (monto <= 0) throw new IllegalArgumentException("El monto a retirar debe ser positivo");
        if (monto > saldo) throw new SaldoInsuficienteException("Saldo insuficiente. Saldo actual: " + saldo);
        saldo -= monto;
        registrar("RETIRO", monto);
    }

    protected void registrar(String tipo, double monto) {
        String linea = String.format("%s | %s | %s | %.2f",
                LocalDateTime.now().format(DF), numeroCuenta, tipo, monto);
        historial.add(linea);
    }

    public List<String> getHistorial() {
        return new ArrayList<>(historial);
    }

    public String getNumeroCuenta() { return numeroCuenta; }
    public String getTitular() { return titular; }
    public double getSaldo() { return saldo; }
}
 

