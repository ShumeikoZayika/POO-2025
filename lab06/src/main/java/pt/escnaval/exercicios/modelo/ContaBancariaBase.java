package pt.escnaval.exercicios.modelo;

import java.util.Locale;
import java.util.Objects;
import pt.escnaval.exercicios.exceptions.ContaBancariaException;
import pt.escnaval.exercicios.exceptions.ContaInvalidaException;

public abstract class ContaBancariaBase implements ContaBancaria {
    private final String numero;
    private final String titular;
    protected double saldo;

    protected ContaBancariaBase(String numero, String titular, double saldoInicial) {
        Objects.requireNonNull(numero, "Número da conta não pode ser null");
        Objects.requireNonNull(titular, "Titular não pode ser null");

        String numeroNormalizado = numero.trim();
        String titularNormalizado = titular.trim();

        if (numeroNormalizado.isBlank()) {
            throw new ContaInvalidaException("Número da conta vazio");
        }
        if (!numeroNormalizado.matches("PT\\d{2}-\\d{4}-\\d{8}")) {
            throw new ContaInvalidaException("Formato de número inválido: " + numeroNormalizado);
        }
        if (titularNormalizado.isBlank()) {
            throw new ContaInvalidaException("Titular vazio");
        }
        if (saldoInicial < 0) {
            throw new ContaInvalidaException("Saldo inicial não pode ser negativo: " + saldoInicial);
        }

        this.numero = numeroNormalizado;
        this.titular = titularNormalizado;
        this.saldo = saldoInicial;
    }

    @Override
    public final String getNumero() {
        return numero;
    }

    @Override
    public final String getTitular() {
        return titular;
    }

    @Override
    public final double getSaldo() {
        return saldo;
    }

    @Override
    public void depositar(double montante) throws ContaBancariaException {
        if (montante <= 0) {
            throw new ContaBancariaException("Montante a depositar deve ser maior que zero.");
        }
        saldo += montante;
    }

    @Override
    public abstract void levantar(double montante) throws ContaBancariaException;

    @Override
    public String toString() {
        Locale locale = Locale.forLanguageTag("pt-PT");
        return String.format(locale, "%s %s (%s) saldo=%.2f€", getTipo(), numero, titular, saldo);
    }
}
