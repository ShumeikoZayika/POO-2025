package pt.escnaval.exercicios.exceptions;

/**
 * Exceção base (checked) para operações bancárias.
 */
public class ContaBancariaException extends Exception {
    public ContaBancariaException(String message) {
        super(message);
    }

    public ContaBancariaException(String message, Throwable cause) {
        super(message, cause);
    }
}
