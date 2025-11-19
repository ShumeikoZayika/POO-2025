package pt.escnaval.exercicios;

/**
 * Demonstracao principal do dominio.
 */
public class MainDemo {
    public static void main(String[] args) {
        Banco banco = new Banco("Banco EscNaval", 10);

        Endereco end1 = new Endereco("Rua das Flores 10", "Lisboa", "1000-001");
        Endereco end2 = new Endereco("Av. dos Aliados 25", "Porto", "4000-002");

        Cliente c1 = new Cliente(1, "Ana Silva", "ana@example.com", end1, "senha123");
        Cliente c2 = new Cliente(2, "Bruno Costa", "bruno@example.com", end2, "pass456");

        if (!c1.isValido() || !c2.isValido()) {
            System.out.println("Erro: clientes invalidos");
            return;
        }

        Iban iban1 = new Iban("PT50000000000000000000000");
        Iban iban2 = new Iban("PT60000000000000000000000");

        Conta a1 = new Conta(iban1, c1, 100.0);
        Conta a2 = new Conta(iban2, c2, 20.0);

        banco.abrirConta(a1);
        banco.abrirConta(a2);

        System.out.println("=== Estado Inicial ===");
        mostrarContas(banco);

        System.out.println("\n=== Deposito de 25 em a1 ===");
        System.out.println("Sucesso? " + a1.depositar(25));
        mostrarContas(banco);

        System.out.println("\n=== Levantamento invalido (-10) ===");
        System.out.println("Sucesso? " + a1.levantar(-10));

        System.out.println("\n=== Transferencia 300 (deve falhar) ===");
        System.out.println("Sucesso? " + a1.transferirPara(a2, 300));

        System.out.println("\n=== Transferencia 30 ===");
        System.out.println("Sucesso? " + a1.transferirPara(a2, 30));
        mostrarContas(banco);

        System.out.println("\n=== Abrir conta duplicada ===");
        Conta duplicada = new Conta(iban1, c2, 50);
        System.out.println("Sucesso? " + banco.abrirConta(duplicada));

        System.out.println("\n=== Fechar conta de Bruno ===");
        System.out.println("Sucesso? " + banco.fecharConta(iban2));
        mostrarContas(banco);

        System.out.println("\n=== Buscar conta por IBAN ===");
        Conta encontrada = banco.findByIban(iban1);
        System.out.println(encontrada != null ? encontrada : "Conta nao encontrada");
    }

    private static void mostrarContas(Banco banco) {
        System.out.println(banco);
        Conta[] contas = banco.getContas();
        for (Conta conta : contas) {
            System.out.println("  " + conta);
        }
    }
}
