package classes;

public class AlunoTurma {
    private Aluno aluno;
    private Nota nota;

    public AlunoTurma(Aluno aluno, Nota nota) {
        this.aluno = aluno;
        this.nota = nota;
       // this.nota.adicionarIObservador(this); // Se inscreve para ouvir as alterações na nota
    }

    
    public AlunoTurma(Aluno aluno) {
        this.aluno = aluno;
       // this.nota.adicionarIObservador(this); // Se inscreve para ouvir as alterações na nota
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Nota getNota() {
        return nota;
    }
    public void setNota(Nota nota) {
         this.nota = nota;
    }

    // Método para bloquear ou desbloquear as notas do aluno
    public void alterarEstadoNota(boolean estado) {
        this.nota.atualizarEstadoNota(estado);  // Chama o método da classe Nota para atualizar o estado
    }
}
