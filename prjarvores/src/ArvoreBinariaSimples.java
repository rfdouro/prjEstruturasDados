@SuppressWarnings("unchecked")
public class ArvoreBinariaSimples<T extends Comparable<T>> {

  public int n = 0;
  public NoArvoreBinariaSimples<T> raiz;

  public ArvoreBinariaSimples() {

  }

  public ArvoreBinariaSimples(T... e) {
    for (int i = 0; i < e.length; i++) {
      adiciona(e[i]);
    }
  }

  public void adiciona(T valor) {
    if (raiz == null) {
      raiz = new NoArvoreBinariaSimples<>(valor, null, null, null);
      n++;
      return;
    }
    adiciona(valor, raiz);
  }

  private void adiciona(T valor, NoArvoreBinariaSimples<T> atual) {
    if (atual != null) {
      if (atual.valor.compareTo(valor) >= 0) {
        if (atual.esquerdo == null) {
          n++;
          atual.esquerdo = new NoArvoreBinariaSimples<>(valor, null, null, atual);
        } else {
          adiciona(valor, atual.esquerdo);
        }
      } else {
        if (atual.direito == null) {
          n++;
          atual.direito = new NoArvoreBinariaSimples<>(valor, null, null, atual);
        } else {
          adiciona(valor, atual.direito);
        }
      }
    }
  }

  public int tamanho() {
    return n;
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

  private void percorrePreOrdem(NoArvoreBinariaSimples<T> atual) {
    if (atual != null) {
      System.out.print(atual + ", ");
      percorrePreOrdem(atual.esquerdo);
      percorrePreOrdem(atual.direito);
    }
  }

  private void percorreOrdem(NoArvoreBinariaSimples<T> atual) {
    if (atual != null) {
      percorreOrdem(atual.esquerdo);
      System.out.print(atual.valor + ", ");
      percorreOrdem(atual.direito);
    }
  }

  private void percorrePosOrdem(NoArvoreBinariaSimples<T> atual) {
    if (atual != null) {
      percorrePosOrdem(atual.esquerdo);
      percorrePosOrdem(atual.direito);
      System.out.print(atual.valor + ", ");
    }
  }

  public boolean existe(T pesquisa) {
    return existe(pesquisa, raiz);
  }

  private boolean existe(T pesquisa, NoArvoreBinariaSimples<T> atual) {
    if (atual != null) {
      if (atual.valor.equals(pesquisa)) {
        return true;
      }
      if (atual.valor.compareTo(pesquisa) >= 0) {
        return existe(pesquisa, atual.esquerdo);
      } else {
        return existe(pesquisa, atual.direito);
      }
    }
    return false;
  }

  private NoArvoreBinariaSimples<T> pesquisa(T pesquisa, NoArvoreBinariaSimples<T> atual) {
    if (atual != null) {
      if (atual.valor.equals(pesquisa)) {
        return atual;
      }
      if (atual.valor.compareTo(pesquisa) >= 0) {
        return pesquisa(pesquisa, atual.esquerdo);
      } else {
        return pesquisa(pesquisa, atual.direito);
      }
    }
    return null;
  }

  public boolean remove(T elemento) {
    // return remove(elemento, raiz);
    NoArvoreBinariaSimples<T> no = pesquisa(elemento, raiz);
    NoArvoreBinariaSimples<T> pai = (no != null) ? no.pai : null;

    if (no == null) {
      return false;
    } else if (no.direito != null && no.esquerdo != null) {
      NoArvoreBinariaSimples<T> max = maximo(no.esquerdo);
      no.valor = max.valor;
      if (no == max.pai) {
        no.esquerdo = max.esquerdo;
        if (no.esquerdo != null)
          no.esquerdo.pai = no;
      } else {
        max.pai.direito = max.esquerdo;
        if (max.esquerdo != null)
          max.esquerdo.pai = max.pai;
      }
    } else if (no.direito == null && no.esquerdo == null) {
      // é folha -> encontra pelo endereço de memória
      if (pai == null) {
        raiz = null;
      } else if (pai.direito == no) {
        pai.direito = null;
      } else if (pai.esquerdo == no) {
        pai.esquerdo = null;
      }
    } else if (no.direito != null) {
      // tem um filho -> elimina pelo pai à direita
      no.valor = no.direito.valor;
      NoArvoreBinariaSimples<T> esq = no.direito.esquerdo;
      NoArvoreBinariaSimples<T> dir = no.direito.direito;
      no.esquerdo = esq;
      if (esq != null)
        esq.pai = no;
      no.direito = dir;
      if (dir != null)
        dir.pai = no;
    } else if (no.esquerdo != null) {
      // tem um filho -> elimina pelo pai à esquerda
      no.valor = no.esquerdo.valor;
      NoArvoreBinariaSimples<T> esq = no.esquerdo.esquerdo;
      NoArvoreBinariaSimples<T> dir = no.esquerdo.direito;
      no.esquerdo = esq;
      if (esq != null)
        esq.pai = no;
      no.direito = dir;
      if (dir != null)
        dir.pai = no;
    }

    return true;
  }

  private NoArvoreBinariaSimples<T> maximo(NoArvoreBinariaSimples<T> atual) {
    if (atual.direito == null) {
      return atual;
    } else {
      return maximo(atual.direito);
    }
  }

  private boolean remove(T elemento, NoArvoreBinariaSimples<T> atual) {
    if (atual != null) {
      if (atual.valor.compareTo(elemento) == 0) {
        if (atual.direito != null && atual.esquerdo != null) {
          // faz procedimento do maximo
          /*
           * um nó de maior valor ou tem filho à equerda ou é folha (não tem filhos) ->
           * isso garante o sucesso
           */
          NoArvoreBinariaSimples<T> max = maximo(atual.esquerdo);
          atual.valor = max.valor;
          atual.esquerdo = max.esquerdo;
        } else if (atual.direito == null && atual.esquerdo == null) {
          // é folha -> encontra pelo endereço de memória
          if (atual.pai == null) {
            raiz = null;
          } else if (atual.pai.direito != null && atual.pai.direito == atual) {
            atual.pai.direito = null;
          } else if (atual.pai.esquerdo != null && atual.pai.esquerdo == atual) {
            atual.pai.esquerdo = null;
          }
          System.out.println(atual.pai);
        } else if (atual.direito != null) {
          // tem um filho -> elimina pelo pai à direita
          atual.valor = atual.direito.valor;
          NoArvoreBinariaSimples<T> esq = atual.direito.esquerdo;
          NoArvoreBinariaSimples<T> dir = atual.direito.direito;
          atual.esquerdo = esq;
          if (esq != null)
            esq.pai = atual;
          atual.direito = dir;
          if (dir != null)
            dir.pai = atual;
        } else {
          // tem um filho -> elimina pelo pai à esquerda
          atual.valor = atual.esquerdo.valor;
          NoArvoreBinariaSimples<T> esq = atual.esquerdo.esquerdo;
          NoArvoreBinariaSimples<T> dir = atual.esquerdo.direito;
          atual.esquerdo = esq;
          if (esq != null)
            esq.pai = atual;
          atual.direito = dir;
          if (dir != null)
            dir.pai = atual;
        }
        n--;
        return true;
      } else if (atual.valor.compareTo(elemento) >= 0) { // continua procurando
        return remove(elemento, atual.esquerdo);
      } else {
        return remove(elemento, atual.direito);
      }
    }
    return false;
  }
}
