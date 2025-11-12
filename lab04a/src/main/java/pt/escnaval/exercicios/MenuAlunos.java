package pt.escnaval.exercicios;

import java.util.Scanner;

public class MenuAlunos {
    private final AlunoRepo repo = new AlunoRepo();

    public static void main(String[] args) {
        new MenuAlunos().executar();
    }

    private void executar() {
        try (Scanner sc = new Scanner(System.in)) {
            int opcao;
            do {
                mostrarMenu();
                opcao = UtilsIO.lerOpcao(sc, 0, 6);
                switch (opcao) {
                    case 1:
                        repo.listarPorId();
                        break;
                    case 2:
                        repo.listarPorNome();
                        break;
                    case 3:
                        adicionarFluxo(sc);
                        break;
                    case 4:
                        removerFluxo(sc);
                        break;
                    case 5:
                        buscarFluxo(sc);
                        break;
                    case 6:
                        renomearFluxo(sc);
                        break;
                    case 0:
                        System.out.println("A terminar...");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
                System.out.println();
            } while (opcao != 0);
        }
    }

    private void mostrarMenu() {
        System.out.println("=== MENU ALUNOS ===");
        System.out.println("1) Listar por ID");
        System.out.println("2) Listar por Nome");
        System.out.println("3) Adicionar");
        System.out.println("4) Remover por ID");
        System.out.println("5) Buscar por termo");
        System.out.println("6) Renomear por ID");
        System.out.println("0) Sair");
        System.out.print("Opção (0..6) → ");
    }

    private void adicionarFluxo(Scanner sc) {
        int id = UtilsIO.lerInt(sc, "ID (inteiro > 0): ");
        if (repo.findById(id) != null) {
            System.out.println("Falha: ID já existente.");
            return;
        }
        String nome = UtilsIO.lerLinhaObrigatoria(sc, "Nome: ");
        try {
            boolean inserido = repo.adicionar(new Aluno(id, nome));
            System.out.println(inserido ? "Adicionado." : "Não foi possível adicionar o aluno.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void removerFluxo(Scanner sc) {
        int id = UtilsIO.lerInt(sc, "ID a remover: ");
        boolean removido = repo.removerPorId(id);
        System.out.println(removido ? "Removido." : "ID não encontrado.");
    }

    private void buscarFluxo(Scanner sc) {
        String termo = UtilsIO.lerLinhaObrigatoria(sc, "Termo (parte do nome): ");
        repo.buscarPorNome(termo);
    }

    private void renomearFluxo(Scanner sc) {
        int id = UtilsIO.lerInt(sc, "ID a renomear: ");
        Aluno aluno = repo.findById(id);
        if (aluno == null) {
            System.out.println("ID não encontrado.");
            return;
        }
        String novoNome = UtilsIO.lerLinhaObrigatoria(sc, "Novo nome: ");
        try {
            aluno.setNome(novoNome);
            System.out.println("Atualizado.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
