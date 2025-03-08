public class EstadoRecuperacao implements EstadoAluno{
public void setNota (AlunoTurma aluno, double nota){
    aluno.setNotaRecuperacao(double nota);
    System.out.println ("Nota definida no estado Recuperacao:" + nota);
}
}

