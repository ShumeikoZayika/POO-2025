package pt.escnaval.exercicios;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AlunoRepo {
    private final List<Aluno> alunos = new ArrayList<>();

    public boolean adicionar(Aluno aluno) {
        if (aluno == null || findById(aluno.getId()) != null) {
            return false;
        }
        alunos.add(aluno);
        return true;
    }

    public boolean removerPorId(int id) {
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getId() == id) {
                alunos.remove(i);
                return true;
            }
        }
        return false;
    }

    public Aluno findById(int id) {
        for (Aluno aluno : alunos) {
            if (aluno.getId() == id) {
                return aluno;
            }
        }
        return null;
    }

    public void listarPorId() {
        if (alunos.isEmpty()) {
            System.out.println("(sem registos)");
            return;
        }
        List<Aluno> ordenados = new ArrayList<>(alunos);
        ordenados.sort(Comparator.comparingInt(Aluno::getId));
        imprimirTabela(ordenados);
    }

    public void listarPorNome() {
        if (alunos.isEmpty()) {
            System.out.println("(sem registos)");
            return;
        }
        List<Aluno> ordenados = new ArrayList<>(alunos);
        ordenados.sort(Comparator.comparing(Aluno::getNome, String.CASE_INSENSITIVE_ORDER));
        imprimirTabela(ordenados);
    }

    public void buscarPorNome(String termo) {
        if (termo == null || termo.trim().isEmpty()) {
            System.out.println("Nenhum termo indicado.");
            return;
        }
        String termoNormalizado = termo.trim().toLowerCase();
        List<Aluno> encontrados = new ArrayList<>();
        for (Aluno aluno : alunos) {
            if (aluno.getNome().toLowerCase().contains(termoNormalizado)) {
                encontrados.add(aluno);
            }
        }
        if (encontrados.isEmpty()) {
            System.out.println("Nenhum aluno encontrado para \"" + termo + "\".");
            return;
        }
        imprimirTabela(encontrados);
    }

    private static void imprimirTabela(List<Aluno> lista) {
        System.out.printf("%-6s | %-40s%n", "ID", "Nome");
        System.out.println("------+-" + "-".repeat(40));
        for (Aluno aluno : lista) {
            System.out.printf("%-6d | %-40s%n", aluno.getId(), aluno.getNome());
        }
    }
}
