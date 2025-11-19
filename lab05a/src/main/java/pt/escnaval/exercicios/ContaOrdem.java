package pt.escnaval.exercicios;

public class ContaOrdem extends Conta {
    private final double limiteDescoberto;

    public ContaOrdem(Cliente titular, Iban iban, double limiteDescoberto) {
        super(titular, iban);
        if (limiteDescoberto < 0) {
            throw new IllegalArgumentException("Limite tem de ser >= 0");
        }
        this.limiteDescoberto = limiteDescoberto;
    }

    public double getLimiteDescoberto() {
        return limiteDescoberto;
    }

    @Override
    protected boolean podeLevantar(double valor) {
        return getSaldo() - valor >= -limiteDescoberto;
    }
}
