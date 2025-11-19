package pt.escnaval.exercicios;

import java.util.Locale;
import java.util.Objects;

public final class Iban {
    private final String valor;

    private Iban(String valor) {
        this.valor = valor;
    }

    public static Iban of(String valorBruto) {
        Objects.requireNonNull(valorBruto, "valorBruto");
        String normalizado = valorBruto.replaceAll("\\s+", "").toUpperCase(Locale.ROOT);
        if (!normalizado.matches("[A-Z]{2}\\d{2}[A-Z0-9]{1,30}")) {
            throw new IllegalArgumentException("IBAN invalido: " + valorBruto);
        }
        return new Iban(normalizado);
    }

    public String getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return valor;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Iban other = (Iban) obj;
        return valor.equals(other.valor);
    }

    @Override
    public int hashCode() {
        return valor.hashCode();
    }
}
