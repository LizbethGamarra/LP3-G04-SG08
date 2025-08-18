import java.util.Scanner;
public class Suma_array
{
  public static int suma(int[] arr)
  {
    /**
     *Funcion que halla la suma de un arreglo y lo retorna en la variable 
     @param resultado almacena la suma.
    */
    int resultado=0;
    for (int x : arr)
    {
      resultado += x;
    }
    return resultado;
  }
  public static void main(String[] args)
  {
    int[] arreglo = {4,3,2,1,4};
    int result = suma(arreglo);
    System.out.println(result);
  }
}

