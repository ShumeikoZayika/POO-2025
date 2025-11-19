package pt.escnaval.exercicios;

import java.util.Objects;

public class Endereco {
    private final String rua;
    private final String numero;
    private final String cidade;
    private final String codigoPostal;

    public Endereco(String rua, String numero, String cidade, String codigoPostal) {
        this.rua = Objects.requireNonNull(rua, "rua");
        this.numero = Objects.requireNonNull(numero, "numero");
        this.cidade = Objects.requireNonNull(cidade, "cidade");
        this.codigoPostal = Objects.requireNonNull(codigoPostal, "codigoPostal");
    }

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }

    public String getCidade() {
        return cidade;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    @Override
    public String toString() {
        return rua + ", " + numero + " - " + codigoPostal + " " + cidade;
    }
}
