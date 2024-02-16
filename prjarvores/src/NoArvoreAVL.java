public class NoArvoreAVL<T> extends NoArvoreBinariaSimples<T> {
 public int fatorBalanco, altura;

 public NoArvoreAVL() {
 }

 public NoArvoreAVL(T valor, NoArvoreAVL<T> esquerdo, NoArvoreAVL<T> direito, NoArvoreAVL<T> pai) {
  super(valor, esquerdo, direito, pai);
 }

}
