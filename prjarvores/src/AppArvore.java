public class AppArvore {
 public static void main(String[] args) {
  ArvoreBinariaSimples<Integer> a = new ArvoreBinariaSimples<>();
  a.adiciona(1);
  a.adiciona(0);
  a.adiciona(2);
  a.adiciona(3);
  a.adiciona(8);
  a.adiciona(4);
  a.adiciona(5);
  a.percorrePreOrdem();
  System.out.println();
  a.remove(1);
  a.percorrePreOrdem();
  System.out.println();
  a.remove(8);
  a.percorrePreOrdem();
  System.out.println();
  a.remove(5);
  a.percorrePreOrdem();
  System.out.println();
  a.remove(4);
  a.percorrePreOrdem();
  System.out.println();
  a.remove(3);
  a.percorrePreOrdem();
  System.out.println();
 }
}
