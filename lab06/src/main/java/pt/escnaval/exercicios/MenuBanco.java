package pt.escnaval.exercicios;

import java.util.Locale;
import java.util.Scanner;
import pt.escnaval.exercicios.exceptions.ContaBancariaException;
import pt.escnaval.exercicios.exceptions.SaldoInsuficienteException;
import pt.escnaval.exercicios.modelo.ContaBancaria;
import pt.escnaval.exercicios.modelo.ContaCorrente;
import pt.escnaval.exercicios.modelo.ContaPoupanca;
import pt.escnaval.exercicios.servicos.Banco;
import pt.escnaval.exercicios.utils.UtilsIO;

public class MenuBanco {
    private static final Banco banco = new Banco();

    public static void main(String[] args) {
        Locale.setDefault(Locale.forLanguageTag("pt-PT"));

        try (Scanner sc = new Scanner(System.in)) {
            int opcao;
            do {
                mostrarMenu();
                opcao = UtilsIO.lerOpcao(sc, 0, 8);
                try {
                    switch (opcao) {
                        case 1:
                            listarContas();
                            break;
                        case 2:
                            criarContaCorrente(sc);
                            break;
                        case 3:
                            criarContaPoupanca(sc);
                            break;
                        case 4:
                            depositar(sc);
                            break;
                        case 5:
                            levantar(sc);
                            break;
                        case 6:
                            consultarSaldo(sc);
                            break;
                        case 7:
                            removerConta(sc);
                            break;
                        case 8:
                            mostrarEstatisticas();
                            break;
                        case 0:
                            System.out.println("A terminar...");
                            break;
                        default:
                            System.out.println("Opção inválida.");
                            break;
                    }
                } catch (SaldoInsuficienteException e) {
                    System.err.println("ERRO: " + e.getMessage());
                    System.err.printf("Saldo disponível: %.2f€%n", e.getSaldoAtual());
                } catch (ContaBancariaException e) {
                    System.err.println("ERRO: " + e.getMessage());
                } catch (RuntimeException e) {
                    System.err.println("ERRO INESPERADO: " + e.getMessage());
                    e.printStackTrace();
                }
                System.out.println();
            } while (opcao != 0);
        }
    }

    private static void mostrarMenu() {
        System.out.println("═══════════════════════════════════");
        System.out.println("      SISTEMA BANCÁRIO - MENU      ");
        System.out.println("═══════════════════════════════════");
        System.out.println("1) Listar contas");
        System.out.println("2) Criar Conta Corrente");
        System.out.println("3) Criar Conta Poupança");
        System.out.println("4) Depositar");
        System.out.println("5) Levantar");
        System.out.println("6) Consultar saldo");
        System.out.println("7) Remover conta");
        System.out.println("8) Estatísticas");
        System.out.println("0) Sair");
        System.out.print("Opção → ");
    }

    private static void listarContas() {
        banco.listarContas();
    }

    private static void criarContaCorrente(Scanner sc) {
        System.out.println("\n--- CRIAR CONTA CORRENTE ---");
        String numero = UtilsIO.lerStringNaoVazia(sc, "Número da conta (PTXX-YYYY-ZZZZZZZZ): ");
        String titular = UtilsIO.lerStringNaoVazia(sc, "Titular: ");
        double saldoInicial = UtilsIO.lerDouble(sc, "Saldo inicial: ");
        double limite = UtilsIO.lerDouble(sc, "Limite de descoberto: ");

        ContaCorrente conta = new ContaCorrente(numero, titular, saldoInicial, limite);
        banco.adicionarConta(conta);
        System.out.println("✓ Conta corrente criada com sucesso.");
    }

    private static void criarContaPoupanca(Scanner sc) {
        System.out.println("\n--- CRIAR CONTA POUPANÇA ---");
        String numero = UtilsIO.lerStringNaoVazia(sc, "Número da conta (PTXX-YYYY-ZZZZZZZZ): ");
        String titular = UtilsIO.lerStringNaoVazia(sc, "Titular: ");
        double saldoInicial = UtilsIO.lerDouble(sc, "Saldo inicial: ");

        ContaPoupanca conta = new ContaPoupanca(numero, titular, saldoInicial);
        banco.adicionarConta(conta);
        System.out.println("✓ Conta poupança criada com sucesso.");
    }

    private static void depositar(Scanner sc) throws ContaBancariaException {
        System.out.println("\n--- DEPOSITAR ---");
        String numero = UtilsIO.lerStringNaoVazia(sc, "Número da conta: ");
        ContaBancaria conta = banco.buscarContaPorNumero(numero);
        if (conta == null) {
            System.out.println("✗ Conta não encontrada.");
            return;
        }
        double montante = UtilsIO.lerDouble(sc, "Montante a depositar: ");
        conta.depositar(montante);
        System.out.printf("✓ Depósito realizado. Novo saldo: %.2f€%n", conta.getSaldo());
    }

    private static void levantar(Scanner sc) throws ContaBancariaException {
        System.out.println("\n--- LEVANTAR ---");
        String numero = UtilsIO.lerStringNaoVazia(sc, "Número da conta: ");
        ContaBancaria conta = banco.buscarContaPorNumero(numero);
        if (conta == null) {
            System.out.println("✗ Conta não encontrada.");
            return;
        }
        double montante = UtilsIO.lerDouble(sc, "Montante a levantar: ");
        conta.levantar(montante);
        System.out.printf("✓ Levantamento realizado. Novo saldo: %.2f€%n", conta.getSaldo());
    }

    private static void consultarSaldo(Scanner sc) {
        System.out.println("\n--- CONSULTAR SALDO ---");
        String numero = UtilsIO.lerStringNaoVazia(sc, "Número da conta: ");
        ContaBancaria conta = banco.buscarContaPorNumero(numero);
        if (conta == null) {
            System.out.println("✗ Conta não encontrada.");
            return;
        }
        System.out.printf("Saldo atual: %.2f€%n", conta.getSaldo());
        System.out.println("Detalhes: " + conta);
    }

    private static void removerConta(Scanner sc) {
        System.out.println("\n--- REMOVER CONTA ---");
        String numero = UtilsIO.lerStringNaoVazia(sc, "Número da conta a remover: ");
        boolean removida = banco.removerConta(numero);
        System.out.println(removida ? "✓ Conta removida." : "✗ Conta não encontrada.");
    }

    private static void mostrarEstatisticas() {
        System.out.println("\n=== ESTATÍSTICAS ===");
        System.out.printf("Total de contas: %d%n", banco.getNumeroContas());
        System.out.printf("Saldo total: %.2f€%n", banco.saldoTotal());
        banco.listarContasComDescoberto();
    }
}
