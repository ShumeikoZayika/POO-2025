package pt.escnaval.exercicios;

public class ContaPoupanca extends Conta {
    private final double taxaJuroAnual;

    public ContaPoupanca(Cliente titular, Iban iban, double taxaJuroAnual) {
        super(titular, iban);
        if (taxaJuroAnual < 0) {
            throw new IllegalArgumentException("taxa invalida");
        }
        this.taxaJuroAnual = taxaJuroAnual;
    }

    public double getTaxaJuroAnual() {
        return taxaJuroAnual;
    }

    public void capitalizar(int meses) {
        if (meses <= 0) {
            throw new IllegalArgumentException("meses tem de ser positivo");
        }
        double taxaMensal = taxaJuroAnual / 12.0;
        double saldoAtual = getSaldo();
        double novoSaldo = saldoAtual * Math.pow(1 + taxaMensal, meses);
        double juros = novoSaldo - saldoAtual;
        if (juros > 0) {
            depositar(juros);
        }
    }
}
