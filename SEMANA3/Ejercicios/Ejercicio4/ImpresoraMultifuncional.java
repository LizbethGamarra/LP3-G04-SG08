package Ejercicio4;

public class ImpresoraMultifuncional implements ImpresoraBasica, Escaner {
    @Override
    public void imprimir() {
        System.out.println("Imprimiendo documento multifuncional...");
    }

    @Override
    public void escanear() {
        System.out.println("Escaneando documento...");
    }
}
