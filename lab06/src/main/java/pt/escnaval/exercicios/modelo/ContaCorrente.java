package pt.escnaval.exercicios.modelo;

import pt.escnaval.exercicios.exceptions.ContaBancariaException;
import pt.escnaval.exercicios.exceptions.ContaInvalidaException;
import pt.escnaval.exercicios.exceptions.SaldoInsuficienteException;

public class ContaCorrente extends ContaBancariaBase {
    private final double limiteDescoberto;

    public ContaCorrente(String numero, String titular, double saldoInicial, double limiteDescoberto) {
        super(numero, titular, saldoInicial);
        if (limiteDescoberto < 0) {
            throw new ContaInvalidaException("Limite de descoberto não pode ser negativo: " + limiteDescoberto);
        }
        this.limiteDescoberto = limiteDescoberto;
    }

    @Override
    public void levantar(double montante) throws ContaBancariaException {
        if (montante <= 0) {
            throw new ContaBancariaException("Montante a levantar deve ser maior que zero.");
        }

        double saldoDisponivel = saldo + limiteDescoberto;
        if (montante > saldoDisponivel) {
            throw new SaldoInsuficienteException(saldo, montante);
        }

        saldo -= montante;
    }

    @Override
    public String getTipo() {
        return "Conta Corrente";
    }

    public double getLimiteDescoberto() {
        return limiteDescoberto;
    }
}
