public class AppFila {
 public static void main(String[] args) {
  ListaEncadeada<Integer> ld = new ListaEncadeada<>();
  ld.adiciona(5);
  ld.adiciona(4);
  ld.adiciona(3);
  ld.adiciona(6, 2);
  ld.remove(2);
  for (int i = 0; i < ld.tamanho(); i++) {
   System.out.println(ld.seleciona(i));
  }
 }
}
