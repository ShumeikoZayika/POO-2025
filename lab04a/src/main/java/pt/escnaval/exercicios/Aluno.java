package pt.escnaval.exercicios;

import java.util.Objects;

public class Aluno {
    private final int id;
    private String nome;

    public Aluno(int id, String nome) {
        validarId(id);
        this.id = id;
        setNome(nome);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public final void setNome(String nome) {
        if (nome == null) {
            throw new IllegalArgumentException("O nome não pode ser nulo.");
        }
        String normalizado = nome.trim();
        if (normalizado.isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }
        this.nome = normalizado;
    }

    @Override
    public String toString() {
        return String.format("%4d\t%s", id, nome);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Aluno)) {
            return false;
        }
        Aluno aluno = (Aluno) o;
        return id == aluno.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    private static void validarId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("O id deve ser maior do que zero.");
        }
    }
}
