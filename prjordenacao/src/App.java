
public class App {

 public static void main(String[] args) throws Exception {

  int[] v1 = { -15, 6, 1, 80, 7, 3, 5, -3 };
  new Ordenacao().quicksort(v1);
  for (int x : v1) {
   System.out.print(x + ", ");
  }
  System.out.println();

 }
}
