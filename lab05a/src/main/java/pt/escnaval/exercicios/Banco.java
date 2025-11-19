package pt.escnaval.exercicios;

/**
 * Banco que gere contas usando arrays.
 */
public class Banco {
    private final String nome;
    private Conta[] contas;
    private int numContas;

    public Banco(String nome, int capacidadeInicial) {
        this.nome = nome == null ? "Sem nome" : nome.trim();
        this.contas = new Conta[capacidadeInicial > 0 ? capacidadeInicial : 10];
        this.numContas = 0;
    }

    public boolean abrirConta(Conta conta) {
        if (conta == null || !conta.isValida() || findByIban(conta.getIban()) != null) {
            return false;
        }
        if (numContas >= contas.length) {
            expandir();
        }
        contas[numContas++] = conta;
        return true;
    }

    public boolean fecharConta(Iban iban) {
        if (iban == null || !iban.isValid()) {
            return false;
        }
        for (int i = 0; i < numContas; i++) {
            if (contas[i].getIban().equals(iban)) {
                for (int j = i; j < numContas - 1; j++) {
                    contas[j] = contas[j + 1];
                }
                contas[numContas - 1] = null;
                numContas--;
                return true;
            }
        }
        return false;
    }

    public Conta findByIban(Iban iban) {
        if (iban == null || !iban.isValid()) {
            return null;
        }
        for (int i = 0; i < numContas; i++) {
            if (contas[i].getIban().equals(iban)) {
                return contas[i];
            }
        }
        return null;
    }

    public Conta[] getContas() {
        Conta[] copia = new Conta[numContas];
        for (int i = 0; i < numContas; i++) {
            copia[i] = contas[i];
        }
        return copia;
    }

    public int getNumContas() {
        return numContas;
    }

    public String getNome() {
        return nome;
    }

    private void expandir() {
        Conta[] nova = new Conta[contas.length * 2];
        for (int i = 0; i < contas.length; i++) {
            nova[i] = contas[i];
        }
        contas = nova;
    }

    @Override
    public String toString() {
        return nome + " com " + numContas + " contas";
    }
}
