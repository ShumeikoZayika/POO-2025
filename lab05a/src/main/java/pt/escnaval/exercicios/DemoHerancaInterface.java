package pt.escnaval.exercicios;

public class DemoHerancaInterface {
    public static void main(String[] args) {
        Banco banco = MainDemo.criarBancoDemo();
        for (Conta conta : banco.getContas()) {
            Cliente cliente = conta.getTitular();
            boolean autenticavel = cliente instanceof Autenticavel;
            System.out.println(conta.getClass().getSimpleName() + ": " + cliente + " autenticavel? " + autenticavel);
        }
    }
}
