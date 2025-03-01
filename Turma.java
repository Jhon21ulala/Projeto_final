package classes;

import java.util.ArrayList;
import java.util.List;

public class Turma {

  private String identificacao;
  private Curso curso;
  private Semestre semestre; 
  private ArrayList<Professor> professores = new ArrayList<>();
  private ArrayList<AlunoTurma> alunos = new ArrayList<>();

  private List<Log> logs = new ArrayList<>();

  // Construtores
  public Turma() {
  }

  public Turma(String identificacao, Curso curso, Semestre semestre) {
    this.identificacao = identificacao;
    this.curso = curso;
    this.semestre = semestre;  // Atribuindo semestre
    this.logs = new ArrayList<>();
  }

  // Getters e Setters
  public String getIdentificacao() {
    return identificacao;
  }

  public void setIdentificacao(String identificacao) {
    this.identificacao = identificacao;
  }

  public Curso getCurso() {
    return curso;
  }

  public void setCurso(Curso curso) {
    this.curso = curso;
  }

  public Semestre getSemestre() {
    return semestre;
  }

  public void setSemestre(Semestre semestre) {
    this.semestre = semestre;
  }

  public ArrayList<Professor> getProfessores() {
    return professores;
  }

  public void setProfessores(ArrayList<Professor> professores) {
    this.professores = professores;
  }

  public ArrayList<AlunoTurma> getAlunosTurma() {
    return alunos;
  }

  public void setAlunos(ArrayList<AlunoTurma> alunos) {
    this.alunos = alunos;
  }

  // Métodos para adicionar professores e alunos
  public void adicionarProfessor(Professor professor) {
    professor.setCoodernador(false); 
    professores.add(professor);
  }

  public void adicionarAluno(AlunoTurma aluno) {
    alunos.add(aluno);
  }

  // Método para exibir a estatística das notas
  public void setEstatica() {
    System.out.println("Estáticas das notas dos alunos:");
    int totalAprovados = 0;
    int totalReprovados = 0;
    int totalRecuperação = 0;
    for (AlunoTurma aluno : alunos) {
      String nome = aluno.getAluno().getNome();
      double media = aluno.getNota().calcularMedia();

      System.out.printf("Nome: %s, Média: %.2f\n", nome, media);
      if (media < 2.5) {
        totalReprovados++;
      } else if (media < 7) {
        totalRecuperação++;
      } else {
        totalAprovados++;
      }
    }

    System.out.println("Total de aprovados: " + totalAprovados);
    System.out.println("Total de reprovados: " + totalReprovados);
    System.out.println("Total de recuperação: " + totalRecuperação);
  }

  // Método para alterar a nota do aluno (somente para coordenadores)
  public void alterarNotaEstudante(Professor coordenador, AlunoTurma alunoTurma, Nota novaNota) {
    if (coordenador.getCoordenador()) {
      alunoTurma.setNota(novaNota);   
    } else {
      System.out.println("Somente coordenadores podem alterar notas");
    }
  }

  // Exibir dados da turma
  public void exibirDados() {
    System.out.println("Turma: " + identificacao);
    System.out.println("Semestre: " + semestre);  // Exibindo semestre
    System.out.println("Professores:");
    for (Professor professor : professores) {
      professor.exibirDados();
    }
    System.out.println("Alunos:");
    for (AlunoTurma aluno : alunos) {
      aluno.getAluno().exibirDados();
    }
  }

  public ArrayList<AlunoTurma> getAlunos() {
    return alunos;
  }

  public List<Log> getLogs() {
    return logs;
  }

  public void setLogs(List<Log> logs) {
    this.logs = logs;
  }
}
