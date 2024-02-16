public class App {
 public static void main(String[] args) throws Exception {
  Lista<String> l1 = new ListaArray<>();
  l1.adiciona("a", 0);
  l1.adiciona("l", 0);
  l1.adiciona("u", 0);
  l1.adiciona("a", 0);

  for (int i = 0; i < l1.tamanho(); i++) {
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
