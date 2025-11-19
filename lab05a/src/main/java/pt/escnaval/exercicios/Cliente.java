package pt.escnaval.exercicios;

import java.util.Objects;

public class Cliente implements Autenticavel {
    private final String nome;
    private final String documento;
    private final Endereco endereco;
    private final String pin;

    public Cliente(String nome, String documento, Endereco endereco, String pin) {
        this.nome = Objects.requireNonNull(nome, "nome");
        this.documento = Objects.requireNonNull(documento, "documento");
        this.endereco = Objects.requireNonNull(endereco, "endereco");
        this.pin = Objects.requireNonNull(pin, "pin");
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    @Override
    public boolean autenticar(String credencial) {
        return pin.equals(credencial);
    }

    @Override
    public String toString() {
        return nome + " (" + documento + ")";
    }
}
