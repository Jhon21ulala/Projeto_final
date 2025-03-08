public class EstadoAtivo implements EstadoAluno{
public void setNota (AlunoTurma aluno, double nota){
    aluno.setNotaAtivo(nota);
    System.out.println ("Nota definida no estado Ativo:" + nota);
}
}
