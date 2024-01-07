public class App {
 public static void main(String[] args) throws Exception {
  Lista<Integer> l1 = new ListaDuplaEncadeada<>();
  l1.adiciona(1, 0);
  l1.adiciona(2, 0);
  l1.adiciona(3, 0);
  l1.adiciona(4, 0);


  for (int i = 0; i < 4; i++) {
   System.out.print(l1.seleciona(i));
  }
  System.out.println();
  for (int i = 0; i < 4; i++) {
   l1.remove(0);
   for (int j = 0; j < l1.tamanho(); j++) {
    System.out.print(l1.seleciona(j));
   }
   System.out.println();
  }
  System.out.println();
 }
}
