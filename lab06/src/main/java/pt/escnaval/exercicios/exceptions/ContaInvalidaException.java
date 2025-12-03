package pt.escnaval.exercicios.exceptions;

/**
 * Exceção unchecked para violações de invariantes das contas.
 */
public class ContaInvalidaException extends RuntimeException {
    public ContaInvalidaException(String message) {
        super(message);
    }

    public ContaInvalidaException(String message, Throwable cause) {
        super(message, cause);
    }
}
