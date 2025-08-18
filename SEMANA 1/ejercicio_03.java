import java.util.Scanner;
import java.util.Random;
//Import de random para simular los dados.
public class Dados
{
  public static void main(String[] args)
  {
    Random rand = new Random();
    //Objeto rand de la clase Random.
    int[] frecuencia = new int[6];
    for (int i = 0; i < 20000; i++)
    {
      int dado = rand.nextInt(6)+1;
      switch (dado)
      {
        case 1:
          frecuencia[0]++;
          break;
        case 2:
          frecuencia[1]++;
          break;
        case 3:
          frecuencia[2]++;
          break;
        case 4:
          frecuencia[3]++;
          break;
        case 5:
          frecuencia[4]++;
          break;
        case 6:
          frecuencia[5]++;
          break;
        default:
          break;
      }
      /**
       * switch para agregar la frecuencia
       * @param dado contiene el random del 0 al 5 por eso se le suma 1 para que sea del 1 al 6.
      */ 
    }
    for (int x = 0; x < 6; x++)
    {
      System.out.println("Número "+(x+1)+":" + (frecuencia[x]+1));
    }
    //for para mostrar la frecuencia de cada número del 1 al 6.
  }
}
