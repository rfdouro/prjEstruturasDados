
public class App {

 public static void main(String[] args) throws Exception {

  int[] v1 = { 5, 3, 2, 21, -1, 3, 4 };
  System.out.println(new Pesquisa().pesqseq(v1, 4));
  new Ordenacao().mergesort(v1);
  System.out.println(new Pesquisa().pesqbin(v1, -85));

 }
}
