public class FilaLIFO<T> extends ListaArray<T> implements Fila<T> {

 @Override
 public void adiciona(T elemento) {
  super.adiciona(elemento, super.tamanho());
 }

 @Override
 public void remove() {
  super.remove(super.tamanho() - 1);
 }

}
