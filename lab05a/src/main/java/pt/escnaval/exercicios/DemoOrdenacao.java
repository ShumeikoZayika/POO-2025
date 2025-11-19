package pt.escnaval.exercicios;

public class DemoOrdenacao {
    public static void main(String[] args) {
        Banco banco = MainDemo.criarBancoDemo();
        banco.listarOrdenadoPorTitular()
                .forEach(conta -> System.out.println(conta.getTitular().getNome()));
    }
}
