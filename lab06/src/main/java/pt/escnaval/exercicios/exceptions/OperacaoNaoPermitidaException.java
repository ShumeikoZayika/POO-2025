package pt.escnaval.exercicios.exceptions;

/**
 * Exceção unchecked para operações que violam regras de negócio.
 */
public class OperacaoNaoPermitidaException extends RuntimeException {
    public OperacaoNaoPermitidaException(String message) {
        super(message);
    }

    public OperacaoNaoPermitidaException(String message, Throwable cause) {
        super(message, cause);
    }
}
