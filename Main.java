package classes;

import classes.adapter.DataAdapter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static DataBase db;
    static int opcao;
    static Scanner entrada;

    public static void main(String[] args) {
        db = DataBase.getInstance();
        entrada = new Scanner(System.in);

        menuPrincipal();

        entrada.close();
    }

    public static void menuPrincipal() {
        do {
            System.out.println("╔═════════════════════════════════════════╗");
            System.out.println("║                MENU PRINCIPAL           ║");
            System.out.println("╠═════════════════════════════════════════╣");
            System.out.println("║     1 - Menu Coordenador                ║");
            System.out.println("║     2 - Menu Professor                  ║");
            System.out.println("║     0 - Sair                            ║");
            System.out.println("╚═════════════════════════════════════════╝");
            System.out.print("Opção: ");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    menuCoordenador();
                    break;
                case 2:
                    menuProfessor();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    public static void menuCoordenador() {
        do {
            System.out.println("╔═════════════════════════════════════════╗");
            System.out.println("║                MENU COORDENADOR         ║");
            System.out.println("╠═════════════════════════════════════════╣");
            System.out.println("║     1 - Cadastrar um professor          ║");
            System.out.println("║     2 - Vincular um prof. a turma       ║");
            System.out.println("║     3 - Cadastrar um estudante          ║");
            System.out.println("║     4 - Vincular estud. a turma         ║");
            System.out.println("║     5 - Cadastrar um curso              ║");
            System.out.println("║     6 - Cadastrar uma turma             ║");
            System.out.println("║     7 - Cadastrar um coordenador        ║");
            System.out.println("║     8 - Atribuir notas aos estudantes   ║");
            System.out.println("║     9 - Mostrar a estatística           ║");
            System.out.println("║    10 - Lista de recuperação            ║");
            System.out.println("║    11 - Lista geral                     ║");
            System.out.println("║    12 - Histórico                       ║");
            System.out.println("║    13 - Exportar dados do estudante     ║");
            System.out.println("║    14 - Importar dados do MEC           ║");
            System.out.println("║     0 - Voltar ao menu principal        ║");
            System.out.println("╚═════════════════════════════════════════╝");
            System.out.print("Opção: ");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarProfessor();
                    break;
                case 2:
                    vincularProfessorTurma();
                    break;
                case 3:
                    cadastrarAluno();
                    break;
                case 4:
                    vincularEstudanteTurma();
                    break;
                case 5:
                    cadastrarCurso();
                    break;
                case 6:
                    cadastrarTurma();
                    break;
                case 7:
                    cadastarCoordenador();
                    break;
                case 8:
                    cadastrarNotas();
                    break;
                case 9:
                    mostrarEstatistica();
                    break;
                case 10:
                    exibirListaRecuperacao();
                    break;
                case 11:
                    exibirListaGeral();
                    break;
                case 12:
                    exibirHistorico();
                    break;
                case 13:
                    System.out.println(exportarDadosEstudante());
                    break;
                case 14:
                    importDadosEstudanteMEC();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    public static void menuProfessor() {
        do {
            System.out.println("╔═════════════════════════════════════════╗");
            System.out.println("║                MENU PROFESSOR           ║");
            System.out.println("╠═════════════════════════════════════════╣");
            System.out.println("║     1 - Atribuir notas aos estudantes   ║");
            System.out.println("║     2 - Mostrar a estatística           ║");
            System.out.println("║     3 - Lista de recuperação            ║");
            System.out.println("║     4 - Lista geral                     ║");
            System.out.println("║     5 - Histórico                       ║");
            System.out.println("║     0 - Voltar ao menu principal        ║");
            System.out.println("╚═════════════════════════════════════════╝");
            System.out.print("Opção: ");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarNotas();
                    break;
                case 2:
                    mostrarEstatistica();
                    break;
                case 3:
                    exibirListaRecuperacao();
                    break;
                case 4:
                    exibirListaGeral();
                    break;
                case 5:
                    exibirHistorico();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    public static String exportarDadosEstudante() {
        DataBase db = DataBase.getInstance();
        ArrayList<String[]> data = new ArrayList<String[]>();

        ExportData exp = new ExportData();
        ArrayList<Aluno> alunos = db.getAlunos();
        for (int i = 0; i < alunos.size(); i++) {
            String[] sm = {"matricula", alunos.get(i).getMatricula()};
            String[] sn = {"nome", alunos.get(i).getNome()};
            String[] sc = {"cpf", alunos.get(i).getCpf()};
            String[] st = {"telefone", alunos.get(i).getTelefone()};
            String[] se = {"endereco", alunos.get(i).getEndereco()};
            data.add(sm);
            data.add(sn);
            data.add(sc);
            data.add(st);
            data.add(se);
        }
        return exp.ArrayToXMLFormat(data, 5, "student");
    }

    public static void importDadosEstudanteMEC() {
        String data = exportarDadosEstudante();
        ImportDataMEC imec = new ImportDataMEC();
        imec.importData(data);
    }

    // Outros métodos como cadastrarProfessor, vincularProfessorTurma, etc.
}