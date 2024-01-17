public class Pesquisa {
 public int pesqseq(int[] vetor, int x) {
  for (int j = 0; j < vetor.length; j++) {
   if (x == vetor[j]) {
    return j;
   }
  }
  return -1;
 }

 private int pesqbin(int[] vetor, int x, int ini, int fim) {
  if (ini > fim)
   return -1;
  int centro = (ini + fim) / 2;
  if (x == vetor[centro])
   return centro;
  if (x < vetor[centro])
   return pesqbin(vetor, x, ini, centro - 1);
  else
   return pesqbin(vetor, x, centro + 1, fim);
 }

 public int pesqbin(int[] vetor, int x) {
  return pesqbin(vetor, x, 0, vetor.length - 1);
 }
}
