package pt.escnaval.exercicios;

import java.util.Scanner;

// Programa para converter temperaturas entre Celsius e Fahrenheit
public class ConversaoTemperatura {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // Ler temperatura
        System.out.print("Introduza a temperatura: ");
        double temperatura = teclado.nextDouble();

        // Ler tipo de temperatura
        System.out.print("Introduza o tipo de temperatura ('C' para Celsius ou 'F' para Fahrenheit): ");
        char tipo = teclado.next().toUpperCase().charAt(0);

        if (tipo == 'C') {
            // Converter Celsius para Fahrenheit
            double fahrenheit = 1.8 * temperatura + 32;
            System.out.printf("%.2fº Celsius é equivalente a %.2fº Fahrenheit\n", temperatura, fahrenheit);
        } else if (tipo == 'F') {
            // Converter Fahrenheit para Celsius
            double celsius = (temperatura - 32) / 1.8;
            System.out.printf("%.2fº Fahrenheit é equivalente a %.2fº Celsius\n", temperatura, celsius);
        } else {
            System.out.println("Tipo de temperatura inválido. Use 'C' ou 'F'.");
        }

        teclado.close();
    }
}
