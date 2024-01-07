public class NoArvore<T> {
 T valor;
 NoArvore<T> esquerdo;
 NoArvore<T> direito;
 NoArvore<T> pai;

 public NoArvore() {
 }

 public NoArvore(T valor, NoArvore<T> esquerdo, NoArvore<T> direito, NoArvore<T> pai) {
  this.valor = valor;
  this.esquerdo = esquerdo;
  this.direito = direito;
  this.pai = pai;
 }

 public String toString() {
  return "[" + (pai != null ? pai.valor : "null") + "] " + valor + " ([" + (esquerdo != null ? esquerdo.valor : "null")
    + "],[" + (direito != null ? direito.valor : "null") + "])";
 }

}
