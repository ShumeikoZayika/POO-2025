package pt.escnaval.exercicios;

/**
 * Interface que define o contrato para objetos autenticaveis.
 */
public interface Autenticavel {
    boolean autenticar(String senha);

    String getIdentificador();
}
