package exp03;

public class PruebaExp3 {
    public static void main(String[] args) {
        CuentaCredito cc = new CuentaCredito("300", "Emanuel", 100, 200);

        cc.retirar(250);

        try {
            cc.retirar(1000);
        } catch (LimiteCreditoExcedidoException e) {
            System.out.println(e.getMessage());
        }

        CuentaBancaria destino = new CuentaBancaria("400", "Fabiola", 90);
        try {
            cc.transferir(destino, 1000);
        } catch (LimiteCreditoExcedidoException e) {
            System.out.println(e.getMessage());
        }
    }
}

