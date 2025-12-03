package pt.escnaval.exercicios.servicos;

import java.util.Arrays;
import pt.escnaval.exercicios.modelo.ContaBancaria;

public class Banco {
    private static final int CAPACIDADE_INICIAL = 10;
    private ContaBancaria[] contas;
    private int numeroContas;

    public Banco() {
        this.contas = new ContaBancaria[CAPACIDADE_INICIAL];
        this.numeroContas = 0;
    }

    public void adicionarConta(ContaBancaria conta) {
        if (conta == null) {
            throw new IllegalArgumentException("Conta não pode ser null");
        }
        if (numeroContas == contas.length) {
            redimensionar();
        }
        contas[numeroContas++] = conta;
    }

    public boolean removerConta(String numero) {
        for (int i = 0; i < numeroContas; i++) {
            if (contas[i].getNumero().equals(numero)) {
                for (int j = i; j < numeroContas - 1; j++) {
                    contas[j] = contas[j + 1];
                }
                contas[--numeroContas] = null;
                return true;
            }
        }
        return false;
    }

    public ContaBancaria buscarContaPorNumero(String numero) {
        for (int i = 0; i < numeroContas; i++) {
            if (contas[i].getNumero().equals(numero)) {
                return contas[i];
            }
        }
        return null;
    }

    public void listarContas() {
        if (numeroContas == 0) {
            System.out.println("(nenhuma conta registada)");
            return;
        }
        System.out.println("=== CONTAS REGISTADAS ===");
        for (int i = 0; i < numeroContas; i++) {
            System.out.printf("%d) %s%n", i + 1, contas[i]);
        }
    }

    public double saldoTotal() {
        double total = 0.0;
        for (int i = 0; i < numeroContas; i++) {
            total += contas[i].getSaldo();
        }
        return total;
    }

    public void listarContasComDescoberto() {
        System.out.println("=== CONTAS COM DESCOBERTO ===");
        boolean encontrou = false;
        for (int i = 0; i < numeroContas; i++) {
            if (contas[i].getSaldo() < 0) {
                System.out.println(contas[i]);
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("(nenhuma conta com descoberto)");
        }
    }

    public int getNumeroContas() {
        return numeroContas;
    }

    private void redimensionar() {
        contas = Arrays.copyOf(contas, contas.length * 2);
    }
}
