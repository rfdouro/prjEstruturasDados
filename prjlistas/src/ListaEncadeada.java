@SuppressWarnings("unchecked")
public class ListaEncadeada<T> implements Lista<T> {
 int n = 0;
 No<T> inicio = null;

 @Override
 public int tamanho() {
  return n;
 }

 @Override
 public T seleciona(int indice) {
  if (indice > n - 1 || indice < 0) {
   return null;
  }
  if (inicio == null && n == 0) {
   return null;
  }
  No<T> noatual = inicio;
  int contador = 0;
  while (noatual != null) {
   if (contador == indice) {
    return (T) noatual.valor;
   }
   noatual = noatual.proximono;
   contador++;
  }
  return null;
 }

 @Override
 public void altera(Object elemento, int indice) {
  if (indice > n - 1 || indice < 0) {
   return;
  }
  if (inicio == null && n == 0) {
   return;
  }
  No<T> noatual = inicio;
  int contador = 0;
  while (noatual != null) {
   if (contador == indice) {
    noatual.valor = (T) elemento;
    return;
   }
   noatual = noatual.proximono;
   contador++;
  }
 }

 @Override
 public void adiciona(Object elemento, int indice) {
  if (indice == 0) {
   No<T> novo = new No<T>((T) elemento, inicio, null);
   inicio = novo;
   n++;
   return;
  } else {
   No<T> noatual = inicio;
   int contador = 0;
   while (noatual != null) {
    if (contador == indice - 1) {
     No<T> novo = new No<T>((T) elemento, null, null);
     if (noatual.proximono != null) {
      novo = new No<T>((T) elemento, noatual.proximono, null);
     }
     noatual.proximono = novo;
     n++;
     return;
    }
    noatual = noatual.proximono;
    contador++;
   }
  }
 }

 @Override
 public void remove(int indice) {
  if (indice > n - 1 || indice < 0) {
   return;
  }
  if (inicio == null && n == 0) {
   return;
  }
  if (indice == 0) {
   inicio = inicio.proximono;
   n--;
   return;
  } else {
   No<T> ant = inicio, noatual = inicio.proximono;
   int contador = 0;
   while (noatual != null) {
    if (contador == indice - 1) {
     ant.proximono = noatual.proximono;
     n--;
     return;
    }
    ant = noatual;
    noatual = noatual.proximono;
    contador++;
   }
  }
 }

}
