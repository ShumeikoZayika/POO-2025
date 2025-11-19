package pt.escnaval.exercicios;

public class DemoArmadilhas {
    public static void main(String[] args) {
        Banco banco = MainDemo.criarBancoDemo();
        Conta conta = banco.getContas().get(0);
        try {
            conta.levantar(10_000);
        } catch (Exception e) {
            System.out.println("Falhou levantamento: " + e.getMessage());
        }

        try {
            conta.transferir(-5, banco.getContas().get(1));
        } catch (Exception e) {
            System.out.println("Transferencia invalida: " + e.getMessage());
        }
    }
}
