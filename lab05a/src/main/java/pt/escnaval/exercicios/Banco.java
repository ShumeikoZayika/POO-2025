package pt.escnaval.exercicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Banco {
    private final String nome;
    private final List<Conta> contas = new ArrayList<>();

    public Banco(String nome) {
        this.nome = Objects.requireNonNull(nome, "nome");
    }

    public void adicionarConta(Conta conta) {
        Objects.requireNonNull(conta, "conta");
        if (procurarConta(conta.getIban().getValor()).isPresent()) {
            throw new IllegalArgumentException("IBAN duplicado");
        }
        contas.add(conta);
    }

    public Optional<Conta> procurarConta(String iban) {
        return contas.stream()
                .filter(c -> c.getIban().getValor().equals(iban))
                .findFirst();
    }

    public List<Conta> listarOrdenadoPorTitular() {
        return contas.stream()
                .sorted(Comparator.comparing(c -> c.getTitular().getNome()))
                .collect(Collectors.toList());
    }

    public double totalDepositos() {
        return contas.stream().mapToDouble(Conta::getSaldo).sum();
    }

    public List<Conta> getContas() {
        return Collections.unmodifiableList(contas);
    }

    @Override
    public String toString() {
        return nome + " com " + contas.size() + " contas";
    }
}
