package pt.escnaval.exercicios;

import java.util.Scanner;

// Programa para converter milhas em quilómetros
public class MilhasParaQuilometros {
    public static void main(String[] args) {
        // Criar objeto Scanner para ler do teclado
        Scanner teclado = new Scanner(System.in);

        // Pedir ao utilizador a distância em milhas
        System.out.print("Introduza a distância em milhas: ");
        double milhas = teclado.nextDouble();

        // Converter milhas para quilómetros (1 milha = 1.609 km)
        double quilometros = milhas * 1.609;

        // Apresentar o resultado
        System.out.printf("%.2f milhas equivalem a %.2f quilómetros.%n", milhas, quilometros);

        // Fechar o Scanner
        teclado.close();
    }
}
