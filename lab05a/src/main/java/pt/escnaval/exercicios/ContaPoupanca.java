package pt.escnaval.exercicios;

import java.util.Locale;

public class ContaPoupanca extends Conta {
    private final double taxaJuroAnual;

    public ContaPoupanca(Iban iban, Cliente titular, double saldoInicial, double taxaJuroAnual) {
        super(iban, titular, saldoInicial);
        this.taxaJuroAnual = taxaJuroAnual >= 0 ? taxaJuroAnual : 0;
    }

    public double getTaxaJuroAnual() {
        return taxaJuroAnual;
    }

    public double calcularJuros() {
        if (!isValida()) {
            return 0;
        }
        return saldo * (taxaJuroAnual / 100.0);
    }

    public boolean aplicarJuros() {
        double juros = calcularJuros();
        if (juros <= 0) {
            return false;
        }
        saldo += juros;
        return true;
    }

    @Override
    public String toString() {
        if (!isValida()) {
            return "[ContaPoupanca invalida]";
        }
        return String.format(Locale.US,
                "ContaPoupanca %s\t%-18s saldo=%.2f (taxa: %.2f%%)",
                getIban(), getTitular().getNome(), saldo, taxaJuroAnual);
    }
}
