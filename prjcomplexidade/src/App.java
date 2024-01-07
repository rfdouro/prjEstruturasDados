public class App {

 public double soma(double[] vetor) {
  double soma = 0;
  for (int i = 0; i < vetor.length; i++) {
   soma = soma + vetor[i];
  }
  return soma;
 }

 public double soma(double x, double y) {
  return x + y;
 }

 public boolean existe(double[] vetor, double x) {
  for (int i = 0; i < vetor.length; i++) {
   if (x == vetor[i]) {
    return true;
   }
  }
  return false;
 }

 public static void main(String[] args) throws Exception {
  System.out.println("Hello, World!");
 }
}
