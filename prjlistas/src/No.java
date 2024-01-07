public class No<T> {
 T valor;
 No<T> proximono, noanterior;

 No() {

 }

 No(T _valor, No<T> _proximo, No<T> _noanterior) {
  valor = _valor;
  proximono = _proximo;
  noanterior = _noanterior;
 }
}
