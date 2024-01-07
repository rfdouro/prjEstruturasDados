public class AppArvore {
 public static void main(String[] args) {
  ArvoreBinariaSimples<Integer> a = new ArvoreBinariaSimples<>();
  a.adiciona(5);
  a.adiciona(2);
  a.adiciona(7);
  a.adiciona(6);
  a.adiciona(8);
  a.adiciona(1);
  a.percorreOrdem();
  System.out.println();
  a.remove(5);
  a.percorrePreOrdem();
 }
}
