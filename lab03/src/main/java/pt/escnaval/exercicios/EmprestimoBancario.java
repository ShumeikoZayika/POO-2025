package pt.escnaval.exercicios;

import java.util.Scanner;

// Programa para calcular mensalidade e total a pagar de um empréstimo bancário
public class EmprestimoBancario {
    public static void main(String[] args) {
        // Criar objeto Scanner para ler do teclado
        Scanner teclado = new Scanner(System.in);

        // Ler valor do empréstimo
        System.out.print("Introduza o valor do empréstimo (em euros): ");
        double valorEmprestimo = teclado.nextDouble();

        // Ler duração em anos
        System.out.print("Introduza a duração do empréstimo (em anos): ");
        int anos = teclado.nextInt();

        // Ler taxa de juro anual (percentagem entre 0 e 1)
        System.out.print("Introduza a taxa de juro anual (entre 0 e 1): ");
        double taxaJuro = teclado.nextDouble();

        // Calcular número de meses
        int numMeses = anos * 12;
        // Calcular juro mensal
        double juroMes = taxaJuro / 12.0;
        // Calcular base mensal
        double baseMes = 1.0 + juroMes;

        // Calcular mensalidade
        double mensalidade = (juroMes * Math.pow(baseMes, numMeses) * valorEmprestimo) / (-1 + Math.pow(baseMes, numMeses));
        // Calcular total a pagar
        double totalAPagar = mensalidade * numMeses;

        // Apresentar resultados
        System.out.printf("Mensalidade a pagar: %.2f euros\n", mensalidade);
        System.out.printf("Total a pagar: %.2f euros\n", totalAPagar);

        // Fechar o Scanner
        teclado.close();
    }
}
