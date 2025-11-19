package pt.escnaval.exercicios;

import java.util.Locale;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * IBAN simplificado (valor imutavel).
 */
public final class Iban {
    private static final Pattern IBAN_PT = Pattern.compile("^PT[0-9A-Z]{23}$");

    private final String codigo;

    public Iban(String codigoBruto) {
        if (codigoBruto == null) {
            this.codigo = null;
        } else {
            String normalizado = codigoBruto.trim().toUpperCase(Locale.ROOT);
            this.codigo = IBAN_PT.matcher(normalizado).matches() ? normalizado : null;
        }
    }

    public boolean isValid() {
        return codigo != null;
    }

    public String codigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return isValid() ? codigo : "INVALID";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Iban)) {
            return false;
        }
        Iban other = (Iban) obj;
        return Objects.equals(codigo, other.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }
}
