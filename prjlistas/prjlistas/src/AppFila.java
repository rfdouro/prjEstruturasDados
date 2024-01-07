public class AppFila {
 public static void main(String[] args) {
  //FilaFIFO<Integer> f = new FilaFIFO<>();
  FilaLIFO<Integer> f = new FilaLIFO<>();
  f.adiciona(1);
  f.adiciona(2);
  f.adiciona(3);
  f.adiciona(4);
  for (int i = 0; i < f.tamanho(); i++) {
   System.out.print(f.seleciona(i));
  }
  System.out.println();
  f.remove();
  f.remove();
  for (int i = 0; i < f.tamanho(); i++) {
   System.out.print(f.seleciona(i));
  }
  System.out.println();
 }
}
