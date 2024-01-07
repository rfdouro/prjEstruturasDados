@SuppressWarnings("unchecked")
public class ListaArray<T> implements Lista<T> {
 Object[] elementos;
 int n;

 public ListaArray() {
  elementos = new Object[1];
  n = 0;
 }

 @Override
 public int tamanho() {
  return n;
 }

 @Override
 public T seleciona(int indice) {
  return (T) elementos[indice];
 }

 @Override
 public void altera(T elemento, int indice) {
  elementos[indice] = elemento;
 }

 @Override
 public void adiciona(T elemento, int indice) {
  // desloca elementos à direita
  if (elementos[indice] != null) {
   for (int i = n - 1; i >= indice; i--) {
    elementos[i + 1] = elementos[i];
   }
  }
  // insere elemento na posição
  elementos[indice] = elemento;
  n++;
  if (n == elementos.length) {
   Object[] novoselementos = new Object[elementos.length * 2];
   for (int i = 0; i < elementos.length; i++) {
    novoselementos[i] = elementos[i];
   }
   elementos = novoselementos;
  }
 }

 @Override
 public void remove(int indice) {
  // desloca elementos à esquerda
  if (elementos[indice] != null) {
   for (int i = indice; i < n; i++) {
    elementos[i] = elementos[i + 1];
   }
  }
  // apaga uma posição
  elementos[n] = null;
  n--;
  if (n == elementos.length / 4) {
   Object[] novoselementos = new Object[elementos.length / 2];
   for (int i = 0; i < n; i++) {
    novoselementos[i] = elementos[i];
   }
   elementos = novoselementos;
  }
 }
}
