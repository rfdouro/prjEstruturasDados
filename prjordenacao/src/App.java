import java.util.Arrays;

public class App {

 public static int[] bubblesort(int[] vetor) {
  int t = vetor.length;
  for (int i = 0; i < t; i++) {
   for (int j = 0; j < t - 1; j++) {
    if (vetor[j] > vetor[j + 1]) {
     int a = vetor[j];
     vetor[j] = vetor[j + 1];
     vetor[j + 1] = a;
    }
   }
  }
  return vetor;
 }

 public static int[] selectionsort(int[] vetor) {
  int t = vetor.length;
  for (int i = 0; i < t; i++) {
   int menor = i;
   for (int j = i; j < t; j++) {
    if (vetor[menor] > vetor[j]) {
     menor = j;
    }
   }
   int a = vetor[menor];
   vetor[menor] = vetor[i];
   vetor[i] = a;
  }
  return vetor;
 }

 /*
  * https://joaoarthurbm.github.io/eda/posts/quick-sort/
  */
 public static int particiona(int[] vetor, int esq, int dir) {
  int pivo = vetor[esq];
  int i = esq;
  for (int j = esq + 1; j < dir; j++) {
   if (vetor[j] <= pivo) {
    i++;
    int a = vetor[j];
    vetor[j] = vetor[i];
    vetor[i] = a;
   }
  }
  int a = vetor[esq];
  vetor[esq] = vetor[i];
  vetor[i] = a;
  return i;
 }

 public static void quicksort(int[] vetor, int esq, int dir) {
  if (esq < dir) {
   int indicePivo = particiona(vetor, esq, dir);
   quicksort(vetor, esq, indicePivo - 1);
   quicksort(vetor, indicePivo + 1, dir);
  }
 }

 private static void mescla(int[] vetor, int ini, int centro, int fim) {

  int[] aux = new int[vetor.length];
  for (int i = ini; i <= fim; i++) {
   aux[i] = vetor[i];
  }

  int inia = ini;
  int inib = centro + 1;
  int inic = ini;

  while (inia <= centro && inib <= fim) {
   if (aux[inia] > aux[inib]) {
    vetor[inic] = aux[inib];
    inib++;
   } else {
    vetor[inic] = aux[inia];
    inia++;
   }
   inic++;
  }

  while (inia <= centro) {
   vetor[inic] = aux[inia];
   inia++;
   inic++;
  }
  while (inib <= fim) {
   vetor[inic] = aux[inib];
   inib++;
   inic++;
  }

 }

 // https://joaoarthurbm.github.io/eda/posts/merge-sort/
 public static void mergesort(int[] vetor, int ini, int fim) {
  if (ini >= fim) {
   return;
  }
  int centro = (fim + ini) / 2;

  mergesort(vetor, ini, centro);
  mergesort(vetor, centro + 1, fim);

  mescla(vetor, ini, centro, fim);
 }

 public static void main(String[] args) throws Exception {

  int[] v1 = { 15, 6, 1, 80, 7, 3, 5, 3 };
  mergesort(v1, 0, v1.length - 1);
  for (int x : v1) {
   System.out.print(x + ", ");
  }
  System.out.println();

 }
}
