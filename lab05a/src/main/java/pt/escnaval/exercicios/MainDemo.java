package pt.escnaval.exercicios;

public final class MainDemo {
    private MainDemo() {
    }

    public static void main(String[] args) {
        Banco banco = criarBancoDemo();
        System.out.println(banco);
        banco.getContas().forEach(System.out::println);
        System.out.println("Total depositos: " + banco.totalDepositos());
    }

    static Banco criarBancoDemo() {
        Banco banco = new Banco("Banco EscNaval");

        Endereco lisboa = new Endereco("Rua das Flores", "10", "Lisboa", "1000-001");
        Endereco porto = new Endereco("Av. Aliados", "200", "Porto", "4000-001");

        Cliente ana = new Cliente("Ana Costa", "123456789", lisboa, "1234");
        Cliente bruno = new Cliente("Bruno Lima", "987654321", porto, "9999");
        Cliente carla = new Cliente("Carla Alves", "456789123", lisboa, "0000");

        ContaOrdem contaAna = new ContaOrdem(ana, Iban.of("PT50000201231234567890154"), 200);
        ContaPoupanca contaBruno = new ContaPoupanca(bruno, Iban.of("PT50000201231234567890155"), 0.03);
        ContaOrdem contaCarla = new ContaOrdem(carla, Iban.of("PT50000201231234567890156"), 0);

        contaAna.depositar(1500);
        contaBruno.depositar(2300);
        contaCarla.depositar(500);

        banco.adicionarConta(contaAna);
        banco.adicionarConta(contaBruno);
        banco.adicionarConta(contaCarla);
        return banco;
    }
}
