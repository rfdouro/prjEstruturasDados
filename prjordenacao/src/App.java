
public class App {

 public static void main(String[] args) throws Exception {

  int[] v1 = { 5, 3, 2, 21, -1, 3, 4 };
  for (int x : v1) {
   System.out.print(x + ", ");
  }
  System.out.println();
  new Ordenacao().mergesort(v1);
  for (int x : v1) {
   System.out.print(x + ", ");
  }
  System.out.println();

 }
}
