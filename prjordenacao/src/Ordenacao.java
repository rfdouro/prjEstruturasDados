public class Ordenacao {
 public void bubblesort(int[] vetor) {
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
 }

 public void selectionsort(int[] vetor) {
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
 }

 public void quicksort(int[] vetor) {
  quicksort(vetor, 0, vetor.length);
 }

 int passo = 0;

 private void quicksort(int[] vetor, int ini, int fim) {
  int i = ini;
  int j = fim - 1;
  int pivo = vetor[(ini + fim) / 2];
  System.out.println("executa entre vetor[" + i + "] = " + vetor[i] + " e vetor[" + j + "] = " + vetor[j]);
  System.out.println("pivô escolhido na posição " + ((ini + fim) / 2) + " = vetor[" + ((ini + fim) / 2) + "] = "
    + vetor[((ini + fim) / 2)]);
  while (i < j) {
   while (vetor[i] < pivo) {
    i++;
   }
   while (vetor[j] > pivo) {
    j--;
   }
   if (i < j) {

    System.out.println("troca vetor[" + i + "] = " + vetor[i] + " por vetor[" + j + "] = " + vetor[j]);

    int aux = vetor[i];
    vetor[i] = vetor[j];
    vetor[j] = aux;
    i++;
    j--;
   }
   if (ini < j) {
    for (int x : vetor) {
     System.out.print(x + ", ");
    }
    System.out.println();
    quicksort(vetor, ini, j);
   }
   if (i < fim) {
    for (int x : vetor) {
     System.out.print(x + ", ");
    }
    System.out.println();
    quicksort(vetor, i, fim);
   }
  }
 }

 /*
  * pesquisa em => https://joaoarthurbm.github.io/eda/posts/quick-sort/
  */
 private int particiona(int[] vetor, int esq, int dir) {
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

 private void quicksortl(int[] vetor, int esq, int dir) {
  if (esq < dir) {
   int indicePivo = particiona(vetor, esq, dir);
   quicksortl(vetor, esq, indicePivo);
   quicksortl(vetor, indicePivo + 1, dir);
  }
 }

 public void quicksortl(int[] vetor) {
  quicksortl(vetor, 0, vetor.length);
 }

 private void mescla(int[] vetor, int ini, int centro, int fim) {

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

 // pesquisa em => https://joaoarthurbm.github.io/eda/posts/merge-sort/
 private void mergesort(int[] vetor, int ini, int fim) {
  if (ini >= fim) {
   return;
  }
  int centro = (fim + ini) / 2;

  mergesort(vetor, ini, centro);
  mergesort(vetor, centro + 1, fim);

  mescla(vetor, ini, centro, fim);
 }

 public void mergesort(int[] vetor) {
  mergesort(vetor, 0, vetor.length - 1);
 }
}
