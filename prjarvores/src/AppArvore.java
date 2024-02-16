public class AppArvore {
 public static void main(String[] args) {
  ArvoreBinariaSimples<Integer> a = new ArvoreBinariaSimples<>(5, 3, 2, 4, 6, 7, -1);
  a.percorreOrdem();
  System.out.println();
  a.percorrePreOrdem();
  System.out.println();
  System.out.println(a.existe(-2));
  a.remove(4);
  a.percorrePreOrdem();
  System.out.println();
 }
}
