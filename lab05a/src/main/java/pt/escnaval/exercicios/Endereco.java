package pt.escnaval.exercicios;

import java.util.Objects;

/**
 * Objeto de valor imutavel que representa um endereco.
 */
public final class Endereco {
    private final String rua;
    private final String cidade;
    private final String codigoPostal;
    private final boolean valido;

    public Endereco(String rua, String cidade, String codigoPostal) {
        if (isBlank(rua) || isBlank(cidade) || isBlank(codigoPostal)) {
            this.rua = "";
            this.cidade = "";
            this.codigoPostal = "";
            this.valido = false;
        } else {
            this.rua = rua.trim();
            this.cidade = cidade.trim();
            this.codigoPostal = codigoPostal.trim();
            this.valido = true;
        }
    }

    private static boolean isBlank(String valor) {
        return valor == null || valor.trim().isEmpty();
    }

    public boolean isValido() {
        return valido;
    }

    public String getRua() {
        return rua;
    }

    public String getCidade() {
        return cidade;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    @Override
    public String toString() {
        if (!valido) {
            return "[Endereco invalido]";
        }
        return String.format("%s, %s (%s)", rua, cidade, codigoPostal);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Endereco)) {
            return false;
        }
        Endereco other = (Endereco) o;
        return valido == other.valido
                && Objects.equals(rua, other.rua)
                && Objects.equals(cidade, other.cidade)
                && Objects.equals(codigoPostal, other.codigoPostal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rua, cidade, codigoPostal, valido);
    }
}
