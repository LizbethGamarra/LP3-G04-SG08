def suma(lista):
    n = 0
    for i in range(len(lista)):
        n+=lista[i]
    return n
resultado=0
lista=[2,3,5,3]
resultado = suma(lista)
print(resultado)
