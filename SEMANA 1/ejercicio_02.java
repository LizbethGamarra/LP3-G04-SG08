import java.util.Scanner;
public class Unidimencional
{
  public static void main(String[] args)
  {
    int[] array = new int[10];
    //inicializacion de un arreglo Unidimencional de tamaño 10
    Scanner scanner = new Scanner(System.in);
    /**
     *@param n almacena un valor mínimo posible para un int.
    */ 
    int n = Integer.MIN_VALUE;
    for (int  i = 0; i < 10; i++) 
    {
      System.out.print("Ingrese el número "+(i+1)+":");
      int numero = scanner.nextInt();
      while (numero < n)
      {
        System.out.print("Numero no valido, ingrese nuevamente. ");
        numero = scanner.nextInt();
        /**
         * While para validacion número mayor que el anterior.
        */
      }
      n = numero;
      array[i] = numero;
    }
    for (int i=0;i<10;i++)
    {
      System.out.println(array[i]);
    }
  }
}
