package exp02;

public class SaldoNoCeroException extends RuntimeException {
    public SaldoNoCeroException(String mensaje) {
        super(mensaje);
    }
}
