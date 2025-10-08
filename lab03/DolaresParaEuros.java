import java.util.Scanner;

// Programa para converter dólares em euros com comissão fixa
public class DolaresParaEuros {
    public static void main(String[] args) {
        // Criar objeto Scanner para ler do teclado
        Scanner teclado = new Scanner(System.in);

        // Pedir ao utilizador a quantia em dólares
        System.out.print("Introduza a quantia em dólares: ");
        double dolares = teclado.nextDouble();

        // Converter dólares para euros (1€ = $1.2)
        double euros = dolares / 1.2;

        // Subtrair comissão fixa de 2 euros
        double eurosFinal = euros - 2;

        // Apresentar o resultado
        System.out.printf("O valor em euros após comissão é: %.2f euros.%n", eurosFinal);

        // Fechar o Scanner
        teclado.close();
    }
}
