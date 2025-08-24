public class EjemploCoche {
    public static void main(String[] args) {
        // Crear los dos objetos
        Coche cocheDeportivo = new Coche("Ferrari", "F8", 2008, 150000);
        Coche cocheTodoTerreno = new Coche("Audi", "R8", 2015, 80000);

        //  métodos
        cocheDeportivo.encender();
        cocheDeportivo.acelerar();
        cocheDeportivo.frenar();
        cocheDeportivo.aplicarDescuento(5000); // aplica descuento porque es <2010
        cocheDeportivo.apagar();

        System.out.println("----------------------");

        cocheTodoTerreno.encender();
        cocheTodoTerreno.acelerar();
        cocheTodoTerreno.aplicarDescuento(5000); // no aplica descuento porque es >=2010
        cocheTodoTerreno.frenar();
        cocheTodoTerreno.apagar();
    }
}
