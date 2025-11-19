package pt.escnaval.exercicios;

public class DemoIdentidade {
    public static void main(String[] args) {
        System.out.println("=== Demonstracao de Identidade vs Valor ===\n");

        Endereco end1 = new Endereco("Rua A", "Lisboa", "1000-001");
        Endereco end2 = new Endereco("Rua B", "Porto", "4000-001");

        Cliente c1a = new Cliente(1, "Ana Silva", "ana@example.com", end1, "1234");
        Cliente c1b = new Cliente(1, "Ana Silva", "ana@example.com", end2, "1234");
        Cliente c2 = new Cliente(2, "Bruno Costa", "bruno@example.com", end1, "9999");

        System.out.println("--- Cliente (identidade por id) ---");
        System.out.println("c1a.equals(c1b)? " + c1a.equals(c1b));
        System.out.println("c1a.equals(c2)? " + c1a.equals(c2));

        Endereco endA1 = new Endereco("Rua das Flores", "Lisboa", "1000-001");
        Endereco endA2 = new Endereco("Rua das Flores", "Lisboa", "1000-001");
        Endereco endB = new Endereco("Rua das Rosas", "Lisboa", "1000-002");

        System.out.println("\n--- Endereco (valor imutavel) ---");
        System.out.println("endA1.equals(endA2)? " + endA1.equals(endA2));
        System.out.println("endA1.equals(endB)? " + endA1.equals(endB));

        Iban iban1 = new Iban("PT50000000000000000000000");
        Iban iban2 = new Iban("PT60000000000000000000000");

        Conta conta1a = new Conta(iban1, c1a, 100);
        Conta conta1b = new Conta(iban1, c2, 200);
        Conta conta2 = new Conta(iban2, c1a, 100);

        System.out.println("\n--- Conta (identidade por IBAN) ---");
        System.out.println("conta1a.equals(conta1b)? " + conta1a.equals(conta1b));
        System.out.println("conta1a.equals(conta2)? " + conta1a.equals(conta2));

        System.out.println("\n--- Saldo nao afeta equals ---");
        double saldoAntes = conta1a.getSaldo();
        int hashAntes = conta1a.hashCode();
        conta1a.depositar(50);
        System.out.println("Saldo antes: " + saldoAntes + ", depois: " + conta1a.getSaldo());
        System.out.println("Hash mudou? " + (hashAntes != conta1a.hashCode()));

        System.out.println("\n--- Array simulando conjunto sem duplicados ---");
        Conta[] conjunto = new Conta[5];
        int tamanho = 0;
        tamanho += adicionar(conjunto, tamanho, conta1a) ? 1 : 0;
        tamanho += adicionar(conjunto, tamanho, conta1b) ? 1 : 0;
        tamanho += adicionar(conjunto, tamanho, conta2) ? 1 : 0;
        System.out.println("Tamanho final: " + tamanho + " (esperado 2)");
    }

    private static boolean adicionar(Conta[] contas, int tamanho, Conta nova) {
        for (int i = 0; i < tamanho; i++) {
            if (contas[i].equals(nova)) {
                System.out.println("  Duplicado rejeitado: " + nova.getIban());
                return false;
            }
        }
        if (tamanho < contas.length) {
            contas[tamanho] = nova;
            System.out.println("  Adicionado: " + nova.getIban());
            return true;
        }
        return false;
    }
}
