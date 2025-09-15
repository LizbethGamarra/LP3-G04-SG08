package ejercicio1;

import java.io.IOException;

public class ProcesarEntrada {
    private LeerEntrada entrada;

    public ProcesarEntrada() {
        entrada = new LeerEntrada(System.in);
    }

    public void procesar() throws IOException, VocalException, NumeroException, BlancoException, SalidaException {
        char c = entrada.getChar();

        if (c == '\n' || c == '\r') {
            return;
        }

        if ("aeiouAEIOU".indexOf(c) != -1) {
            throw new VocalException("Se ingresó una vocal: " + c);
        } else if (Character.isDigit(c)) {
            throw new NumeroException("Se ingresó un número: " + c);
        } else if (Character.isWhitespace(c)) {
            throw new BlancoException("Se ingresó un espacio en blanco.");
        } else if (c == 'q' || c == 'Q') {
            throw new SalidaException("Carácter de salida detectado.");
        } else {
            System.out.println("Carácter válido: " + c);
        }
    }


    public static void main(String[] args) {
        ProcesarEntrada app = new ProcesarEntrada();
        System.out.println("Ingrese caracteres (use 'q' o 'Q' para salir):");

        while (true) {
            try {
                app.procesar();
            } catch (VocalException | NumeroException | BlancoException e) {
                System.out.println("Excepción: " + e.getMessage());
            } catch (SalidaException e) {
                System.out.println("Excepción: " + e.getMessage());
                break;
            } catch (IOException e) {
                System.out.println("Error de entrada/salida: " + e.getMessage());
            }
        }
    }
}
