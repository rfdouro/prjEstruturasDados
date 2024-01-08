public class AppArvore {
 public static void main(String[] args) {
  ArvoreBinariaSimples<Integer> a = new ArvoreBinariaSimples<>(5, 3, 2, 4, 6);
  a.percorrePreOrdem();
  System.out.println();
  a.remove(6);
  a.percorrePreOrdem();
  System.out.println();
  a.remove(3);
  a.percorrePreOrdem();
  System.out.println();
 }
}
