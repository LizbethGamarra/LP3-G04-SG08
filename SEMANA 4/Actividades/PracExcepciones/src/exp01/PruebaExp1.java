package exp01;

public class PruebaExp1 {
    public static void main(String[] args) {
        CuentaBancaria c1 = new CuentaBancaria("001", "Alicia", 1000.0);

        try {
            new CuentaBancaria("002", "Luis", -50.0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            c1.depositar(-100);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            c1.retirar(2000);
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        }

        c1.depositar(500);
        c1.retirar(300);

        for (String h : c1.getHistorial()) {
            System.out.println(h);
        }
    }
}

