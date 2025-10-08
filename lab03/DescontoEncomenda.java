import java.util.Scanner;

// Programa para calcular o valor a pagar com desconto numa encomenda
public class DescontoEncomenda {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // Ler número de peças encomendadas
        System.out.print("Introduza o número de peças encomendadas: ");
        int numeroPecas = teclado.nextInt();

        // Ler preço unitário
        System.out.print("Introduza o preço unitário (em euros): ");
        double precoUnitario = teclado.nextDouble();

        // Calcular valor da encomenda
        double valorEncomenda = numeroPecas * precoUnitario;
        double desconto;

        // Determinar desconto conforme a tabela
        if (valorEncomenda < 2000) {
            desconto = 0.02;
        } else if (valorEncomenda < 5000) {
            desconto = 0.04;
        } else {
            desconto = 0.075;
        }

        // Calcular valor final a pagar
        double valorFinal = valorEncomenda * (1 - desconto);

        // Apresentar resultado
        System.out.printf("Valor a pagar pelo cliente: %.2f euros\n", valorFinal);

        teclado.close();
    }
}
