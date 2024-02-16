public class ListaDuplaEncadeada<T> implements Lista<T> {
 int n = 0;
 No<T> inicio = null;
 No<T> fim = null;

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
 public void altera(T elemento, int indice) {
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
    No<T> anterior = noatual.noanterior;
    No<T> proximo = noatual;
    No<T> novo = new No<T>((T) elemento, proximo, anterior);
    // novo.proximono = proximo;
    // novo.noanterior = anterior;
    anterior.proximono = novo;
    proximo.noanterior = novo;
    n++;
    return;
   }
   noatual = noatual.proximono;
   contador++;
  }
 }

 @Override
 public void adiciona(T elemento, int indice) {
  if (indice == 0) {
   if (inicio == null) {
    No<T> novo = new No<T>((T) elemento, null, null);
    novo.proximono = novo;
    novo.noanterior = novo;
    inicio = novo;
    fim = novo;
    n++;
    return;
   } else {
    No<T> anterior = inicio.noanterior;
    No<T> proximo = inicio;
    No<T> novo = new No<T>((T) elemento, proximo, anterior);
    // novo.proximono = proximo;
    // novo.noanterior = anterior;
    anterior.proximono = novo;
    proximo.noanterior = novo;
    inicio = novo;
    n++;
    return;

   }
  } else if (indice == (n-1)) { // insere no final da lista
   No<T> anterior = fim;
   No<T> proximo = fim.proximono;
   No<T> novo = new No<T>((T) elemento, proximo, anterior);
   // novo.proximono = proximo;
   // novo.noanterior = anterior;
   anterior.proximono = novo;
   proximo.noanterior = novo;
   n++;
   return;
  } else {
   No<T> noatual = inicio;
   int contador = 0;
   while (noatual != null) {
    if (contador == indice) {
     No<T> anterior = noatual.noanterior;
     No<T> proximo = noatual;
     No<T> novo = new No<T>((T) elemento, proximo, anterior);
     // novo.proximono = proximo;
     // novo.noanterior = anterior;
     anterior.proximono = novo;
     proximo.noanterior = novo;
     n++;
     return;
    }
    noatual = noatual.proximono;
    contador++;
   }
  }
 }

 @Override
 public void adiciona(T elemento) {
  adiciona(elemento, 0);
 }

 @Override
 public void remove(int indice) {
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
    No<T> anterior = noatual.noanterior;
    No<T> proximo = noatual.proximono;
    anterior.proximono = proximo;
    proximo.noanterior = anterior;
    if (indice == 0) {
     inicio = proximo;
    }
    n--;
    return;
   }
   noatual = noatual.proximono;
   contador++;
  }
 }

 @Override
 public void remove() {
  remove(0);
 }

 @Override
 public int pesquisa(T elemento) {
  No<T> noatual = inicio;
  int contador = 0;
  while (noatual != null) {
   if (noatual.valor.equals(elemento)) {
    return contador;
   }
   noatual = noatual.proximono;
   if (noatual == inicio) {
    return -1;
   }
   contador++;
  }
  return -1;
 }

}
