public interface Fila<T> {
 /*
  * adiciona um elemento na fila
  */
 void adiciona(T elemento);

 /*
  * remove um elemento da fila
  */
 void remove();

 /*
  * devolve a quantidade de elementos na fila
  */
 int tamanho();
}
