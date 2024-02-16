public interface Lista<T> {
 /*
  * retorna a quantidade de elementos na lista
  */
 int tamanho();

 /*
  * retorna o elemento na posição indicada
  */
 T seleciona(int indice);

 /*
  * altera o elemento na posição indicada pelo indice
  * inserindo ali um novo elemento passado como parâmetro
  */
 void altera(T elemento, int indice);

 /*
  * adiciona um novo elemento na posição indicada pelo indice
  * inserindo ali um novo elemento passado como parâmetro
  * deslocando o conteúdo em uma posição (à frente)
  */
 void adiciona(T elemento, int indice);

 /*
  * adiciona um novo elemento na última posição válida
  */
 void adiciona(T elemento);

 /*
  * remove o elemento na posição indicada pelo índice
  * deslocando o conteúdo em uma posição (atrás)
  */
 void remove(int indice);

 /*
  * remove o elemento na posição inicial
  */
 void remove();

 /*
  * retorna o índice de um elemento na lista
  * caso não seja encontrado deve retornar um número negativo
  */
 int pesquisa(T elemento);
}
