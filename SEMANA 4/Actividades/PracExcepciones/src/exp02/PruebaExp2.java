package exp02;

public class PruebaExp2 {
    public static void main(String[] args) {
        CuentaBancaria a = new CuentaBancaria("100", "Carlos", 500);
        CuentaBancaria b = new CuentaBancaria("200", "Diana", 300);

        a.transferir(b, 200);

        try {
            a.transferir(null, 50);
        } catch (CuentaNoEncontradaException e) {
            System.out.println(e.getMessage());
        }

        try {
            a.cerrarCuenta();
        } catch (SaldoNoCeroException e) {
            System.out.println(e.getMessage());
        }

        a.retirar(a.getSaldo());
        a.cerrarCuenta();
    }
}
