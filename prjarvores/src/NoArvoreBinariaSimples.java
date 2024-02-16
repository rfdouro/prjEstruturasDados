public class NoArvoreBinariaSimples<T> {
  public T valor;
  public NoArvoreBinariaSimples<T> esquerdo;
  public NoArvoreBinariaSimples<T> direito;
  public NoArvoreBinariaSimples<T> pai;

  public NoArvoreBinariaSimples() {
  }

  public NoArvoreBinariaSimples(T valor, NoArvoreBinariaSimples<T> esquerdo, NoArvoreBinariaSimples<T> direito,
      NoArvoreBinariaSimples<T> pai) {
    this.valor = valor;
    this.esquerdo = esquerdo;
    this.direito = direito;
    this.pai = pai;
  }

  public String toString() {

     return "\n\t\t[" + (pai != null ? pai.valor : " ") + "]\n\t\t " + this.valor
     + " \n([" +
     (esquerdo != null ? esquerdo.valor : " ")
     + "]\t\t,\t\t[" + (direito != null ? direito.valor : " ") + "])";

    //return "" + this.valor;
  }

}
