package pt.escnaval.exercicios;

public class DemoHerancaInterface {
    public static void main(String[] args) {
        Endereco end = new Endereco("Rua Azul", "Faro", "8000-100");
        Cliente c1 = new Cliente(1, "Ana", "ana@example.com", end, "aaaa");
        Cliente c2 = new Cliente(2, "Bruno", "bruno@example.com", end, "bbbb");

        System.out.println("=== Interface Autenticavel ===");
        Autenticavel auth = c1;
        System.out.println("ID: " + auth.getIdentificador());
        System.out.println("Autenticar correto: " + auth.autenticar("aaaa"));
        System.out.println("Autenticar errado: " + auth.autenticar("1234"));

        Iban iban1 = new Iban("PT50000000000000000000001");
        Iban iban2 = new Iban("PT50000000000000000000002");
        Iban iban3 = new Iban("PT50000000000000000000003");

        Conta[] contas = new Conta[3];
        contas[0] = new Conta(iban1, c1, 100);
        contas[1] = new ContaOrdem(iban2, c2, 50, 500);
        contas[2] = new ContaPoupanca(iban3, c1, 1000, 3.5);

        System.out.println("\n=== Polimorfismo (Conta[]) ===");
        for (Conta conta : contas) {
            System.out.println(conta);
        }

        System.out.println("\nDepositar 50 em todas");
        for (Conta conta : contas) {
            conta.depositar(50);
            System.out.println(conta.getIban() + " -> " + conta.getSaldo());
        }

        System.out.println("\nOperacoes especificas");
        if (contas[1] instanceof ContaOrdem) {
            ContaOrdem ordem = (ContaOrdem) contas[1];
            System.out.println("Levantamento 600 (limite 500): " + ordem.levantar(600));
            System.out.println("Saldo atual: " + ordem.getSaldo());
        }
        if (contas[2] instanceof ContaPoupanca) {
            ContaPoupanca poup = (ContaPoupanca) contas[2];
            System.out.println("Juros calculados: " + poup.calcularJuros());
            poup.aplicarJuros();
            System.out.println("Saldo apos juros: " + poup.getSaldo());
        }

        System.out.println("\nIdentidade preservada");
        Conta novaRef = new Conta(iban1, c2, 999);
        System.out.println("contas[0].equals(novaRef)? " + contas[0].equals(novaRef));
    }
}
