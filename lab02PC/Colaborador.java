import java.time.LocalDate;

public class Colaborador extends Pessoa {
    private double salario;
    private LocalDate dataContratacao;

    public Colaborador(String nome, int idade, double salario, int ano, int mes, int dia) {
        super(nome, idade);
        this.salario = salario;
        this.dataContratacao = LocalDate.of(ano, mes, dia);
    }

    public double getSalario() {
        return salario;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public String getDescricao() {
        return String.format("um colaborador com o salário de $%.2f", salario);
    }

    public void aumentarSalario(double percentual) {
        double aumento = salario * percentual / 100;
        salario += aumento;
    }

    @Override
    public String toString() {
        return String.format("%s, Salário: $%.2f, Data de Contratação: %s",
                             super.toString(), salario, dataContratacao.toString());
    }
}
