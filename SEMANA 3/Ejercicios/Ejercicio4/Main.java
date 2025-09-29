package Ejercicio4;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<ImpresoraBasica> impresoras = new ArrayList<>();
        impresoras.add(new Impresora());
        impresoras.add(new ImpresoraMultifuncional());

        for (ImpresoraBasica imp : impresoras) {
            imp.imprimir();
        }

        System.out.println("---- Escaneo ----");
        Escaner multifuncional = new ImpresoraMultifuncional();
        multifuncional.escanear();
    }
}
