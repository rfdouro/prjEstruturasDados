@SuppressWarnings("unchecked")
public class ArvoreAVL<T extends Comparable<T>> {

  public int n = 0;
  public NoArvoreAVL<T> raiz;

  public ArvoreAVL() {

  }

  public ArvoreAVL(T... e) {
    for (int i = 0; i < e.length; i++) {
      adiciona(e[i]);
    }
  }

  public int maior(int a, int b) {
    return (a > b) ? a : b;
  }

  public int alturaNo(NoArvoreAVL<T> no) {
    if (no != null) {
      return no.altura;
    }
    return -1;
  }

  public int fatorBalanco(NoArvoreAVL<T> no) {
    if (no != null) {
      return (alturaNo((NoArvoreAVL<T>) no.esquerdo) - alturaNo((NoArvoreAVL<T>) no.direito));
    }
    return 0;
  }

  public NoArvoreAVL<T> rotacaoEsquerda(NoArvoreAVL<T> no) {
    /*
     * NoArvoreAVL<T> direito, filhoEsquerdo;
     * 
     * direito = (NoArvoreAVL<T>) no.direito;
     * filhoEsquerdo = (NoArvoreAVL<T>) direito.esquerdo;
     * 
     * no.pai = direito;
     * direito.esquerdo = no;
     * if (filhoEsquerdo != null)
     * filhoEsquerdo.pai = no;
     * no.direito = filhoEsquerdo;
     */

    if (no.valor.equals(4)) {
      System.out.println("aqui");
    }

    NoArvoreAVL<T> paiNo = (NoArvoreAVL<T>) no.pai,
        filhoDir = (NoArvoreAVL<T>) no.direito,
        netoEsq = (NoArvoreAVL<T>) filhoDir.esquerdo;

    no.pai = filhoDir;
    no.direito = netoEsq;
    if (netoEsq != null)
      netoEsq.pai = no;
    filhoDir.pai = paiNo;
    filhoDir.esquerdo = no;

    no.altura = maior(alturaNo((NoArvoreAVL<T>) no.esquerdo), alturaNo((NoArvoreAVL<T>) no.direito)) + 1;
    filhoDir.altura = maior(alturaNo((NoArvoreAVL<T>) filhoDir.esquerdo), alturaNo((NoArvoreAVL<T>) filhoDir.direito))
        + 1;

    return filhoDir;
  }

  public NoArvoreAVL<T> rotacaoDireita(NoArvoreAVL<T> no) {
    /*
     * NoArvoreAVL<T> esquerdo, filhoDireito;
     * 
     * esquerdo = (NoArvoreAVL<T>) no.esquerdo;
     * filhoDireito = (NoArvoreAVL<T>) esquerdo.direito;
     * 
     * no.pai = esquerdo;
     * esquerdo.direito = no;
     * if (filhoDireito != null)
     * filhoDireito.pai = no;
     * no.esquerdo = filhoDireito;
     */

    if (no.valor.equals(4)) {
      System.out.println("aqui");
    }
    NoArvoreAVL<T> paiNo = (NoArvoreAVL<T>) no.pai,
        filhoEsq = (NoArvoreAVL<T>) no.esquerdo,
        netoDir = (NoArvoreAVL<T>) filhoEsq.direito;

    no.pai = filhoEsq;
    no.esquerdo = netoDir;
    if (netoDir != null)
      netoDir.pai = no;
    filhoEsq.pai = paiNo;
    filhoEsq.direito = no;

    no.altura = maior(alturaNo((NoArvoreAVL<T>) no.esquerdo), alturaNo((NoArvoreAVL<T>) no.direito)) + 1;
    filhoEsq.altura = maior(alturaNo((NoArvoreAVL<T>) filhoEsq.esquerdo), alturaNo((NoArvoreAVL<T>) filhoEsq.direito))
        + 1;

    return filhoEsq;
  }

  public NoArvoreAVL<T> rotacaoEsquerdaDireita(NoArvoreAVL<T> no) {
    NoArvoreAVL<T> esquerdo = rotacaoEsquerda((NoArvoreAVL<T>) no.esquerdo);
    if (esquerdo.valor.equals(4)) {
      System.out.println("aqui");
    }
    no.esquerdo = esquerdo;
    if (esquerdo != null)
      esquerdo.pai = no;
    return rotacaoDireita(no);
  }

  public NoArvoreAVL<T> rotacaoDireitaEsquerda(NoArvoreAVL<T> no) {
    NoArvoreAVL<T> direito = rotacaoDireita((NoArvoreAVL<T>) no.direito);
    if (direito.valor.equals(4)) {
      System.out.println("aqui");
    }
    no.direito = direito;
    if (direito != null)
      direito.pai = no;
    return rotacaoEsquerda(no);
  }

  public void adiciona(T valor) {
    if (raiz == null) {
      raiz = new NoArvoreAVL<>(valor, null, null, null);
      n++;
      return;
    }
    raiz = adiciona(valor, raiz);
  }

  public NoArvoreAVL<T> adiciona(T valor, NoArvoreAVL<T> atual) {
    if (atual != null) {
      if (atual.valor.compareTo(valor) >= 0) {
        if (atual.esquerdo == null) {
          n++;
          atual.esquerdo = new NoArvoreAVL<>(valor, null, null, atual);
        } else {
          atual.esquerdo = adiciona(valor, (NoArvoreAVL<T>) atual.esquerdo);
        }
      } else {
        if (atual.direito == null) {
          n++;
          atual.direito = new NoArvoreAVL<>(valor, null, null, atual);
        } else {
          atual.direito = adiciona(valor, (NoArvoreAVL<T>) atual.direito);
        }
      }
    }

    atual.altura = maior(alturaNo((NoArvoreAVL<T>) atual.esquerdo), alturaNo((NoArvoreAVL<T>) atual.direito)) + 1;

    return balancear(atual);
  }

  public NoArvoreAVL<T> balancear(NoArvoreAVL<T> no) {
    int fatBal = fatorBalanco(no);
    if (fatBal < -1 && fatorBalanco((NoArvoreAVL<T>) no.direito) <= 0) {
      no = rotacaoEsquerda(no);
    } else if (fatBal > 1 && fatorBalanco((NoArvoreAVL<T>) no.esquerdo) >= 0) {
      no = rotacaoDireita(no);
    } else if (fatBal > 1 && fatorBalanco((NoArvoreAVL<T>) no.esquerdo) < 0) {
      no = rotacaoEsquerdaDireita(no);
    } else if (fatBal < -1 && fatorBalanco((NoArvoreAVL<T>) no.direito) > 0) {
      no = rotacaoDireitaEsquerda(no);
    }
    return no;
  }

  private NoArvoreAVL<T> maximo(NoArvoreAVL<T> atual) {
    if (atual.direito == null) {
      return atual;
    } else {
      return maximo((NoArvoreAVL<T>) atual.direito);
    }
  }

  public NoArvoreAVL<T> remove(NoArvoreAVL<T> atual, T valor) {
    return null;
  }

  public void imprime() {
    imprime(0, raiz);
  }

  private void imprime(int nivel, NoArvoreAVL<T> atual) {
    if (atual != null) {
      imprime(nivel + 1, (NoArvoreAVL<T>) atual.direito);
      System.out.print("\n\n");

      for (int i = 0; i < nivel; i++) {
        System.out.print('\t');
      }

      System.out.print(atual.valor);

      imprime(nivel + 1, (NoArvoreAVL<T>) atual.esquerdo);
    }
  }

  public void percorrePreOrdem() {
    percorrePreOrdem(raiz);
  }

  public void percorrePosOrdem() {
    percorrePosOrdem(raiz);
  }

  public void percorreOrdem() {
    percorreOrdem(raiz);
  }

  private void percorrePreOrdem(NoArvoreAVL<T> atual) {
    if (atual != null) {
      System.out.print(atual + ", ");
      percorrePreOrdem((NoArvoreAVL<T>) atual.esquerdo);
      percorrePreOrdem((NoArvoreAVL<T>) atual.direito);
    }
  }

  private void percorreOrdem(NoArvoreAVL<T> atual) {
    if (atual != null) {
      percorreOrdem((NoArvoreAVL<T>) atual.esquerdo);
      System.out.print(atual.valor + ", ");
      percorreOrdem((NoArvoreAVL<T>) atual.direito);
    }
  }

  private void percorrePosOrdem(NoArvoreAVL<T> atual) {
    if (atual != null) {
      percorrePosOrdem((NoArvoreAVL<T>) atual.esquerdo);
      percorrePosOrdem((NoArvoreAVL<T>) atual.direito);
      System.out.print(atual.valor + ", ");
    }
  }

  public boolean existe(T pesquisa) {
    return existe(pesquisa, raiz);
  }

  private boolean existe(T pesquisa, NoArvoreAVL<T> atual) {
    if (atual != null) {
      if (atual.valor.equals(pesquisa)) {
        return true;
      }
      if (atual.valor.compareTo(pesquisa) >= 0) {
        return existe(pesquisa, (NoArvoreAVL<T>) atual.esquerdo);
      } else {
        return existe(pesquisa, (NoArvoreAVL<T>) atual.direito);
      }
    }
    return false;
  }

  public NoArvoreAVL<T> pesquisa(T pesquisa) {
    return pesquisa(pesquisa, raiz);
  }

  private NoArvoreAVL<T> pesquisa(T pesquisa, NoArvoreAVL<T> atual) {
    if (atual != null) {
      if (atual.valor.equals(pesquisa)) {
        return atual;
      }
      if (atual.valor.compareTo(pesquisa) >= 0) {
        return pesquisa(pesquisa, (NoArvoreAVL<T>) atual.esquerdo);
      } else {
        return pesquisa(pesquisa, (NoArvoreAVL<T>) atual.direito);
      }
    }
    return null;
  }

}
