#include <iostream>
using namespace std;

int suma(int numeros[10])
{
  int result = 0;
  for (int i = 0; i < 10; i++)
  {
    result += numeros[i];
  }
  return result;
}

int main()
{
  int numeros[10] = {1,2,3,4,5,6,7,8,9,10};
  int resultado = 0;
  resultado = suma(numeros);
  cout<<resultado;
  return 0;
}


