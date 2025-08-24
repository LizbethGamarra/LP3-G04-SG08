public class EjemploComposicion {
    public static void main(String[] args) {
        // Crear una persona con su cuenta asociada
        Persona persona1 = new Persona("Ana", 25, "12345", 5000);

        // Mostrar datos
        System.out.println(persona1);

        // Operar sobre la cuenta a través de la persona
        persona1.getCuenta().depositar(1500);
        persona1.getCuenta().retirar(2000);

        // Mostrar datos actualizados
        System.out.println("Después de operaciones: " + persona1);
    }
}
