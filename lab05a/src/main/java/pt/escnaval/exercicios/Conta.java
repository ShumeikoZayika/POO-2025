package pt.escnaval.exercicios;

import java.util.Objects;

public abstract class Conta {
    private final Cliente titular;
    private final Iban iban;
    private double saldo;

    protected Conta(Cliente titular, Iban iban) {
        this.titular = Objects.requireNonNull(titular, "titular");
        this.iban = Objects.requireNonNull(iban, "iban");
    }

    public Cliente getTitular() {
        return titular;
    }

    public Iban getIban() {
        return iban;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        validarValor(valor);
        saldo += valor;
    }

    public void levantar(double valor) {
        validarValor(valor);
        if (!podeLevantar(valor)) {
            throw new IllegalStateException("Saldo insuficiente para " + valor);
        }
        saldo -= valor;
    }

    public void transferir(double valor, Conta destino) {
        Objects.requireNonNull(destino, "destino");
        if (this == destino) {
            throw new IllegalArgumentException("Conta de destino nao pode ser a mesma");
        }
        this.levantar(valor);
        destino.depositar(valor);
    }

    protected boolean podeLevantar(double valor) {
        return saldo >= valor;
    }

    private static void validarValor(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor tem de ser positivo");
        }
    }

    @Override
    public String toString() {
        return titular + " - " + iban + " => saldo: " + String.format("%.2f", saldo);
    }
}
