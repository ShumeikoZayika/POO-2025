package pt.escnaval.exercicios;

public class DemoIdentidade {
    public static void main(String[] args) {
        Banco banco = MainDemo.criarBancoDemo();
        banco.getContas().forEach(conta -> {
            Cliente cliente = conta.getTitular();
            boolean autenticado = cliente.autenticar("1234");
            System.out.println(cliente + " autenticado? " + autenticado);
        });
    }
}
