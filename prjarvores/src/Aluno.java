public class Aluno implements Comparable<Aluno> {
 public int idade;
 public String nome;

 public int compareTo(Aluno outroAluno) {
  if (this.idade < outroAluno.idade)
   return -1;
  if (this.idade == outroAluno.idade)
   return 0;
  return 1;
 }
}
