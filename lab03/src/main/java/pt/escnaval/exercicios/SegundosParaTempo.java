package pt.escnaval.exercicios;

import java.util.Scanner;

// Programa para converter segundos em formato hh:mm:ss
public class SegundosParaTempo {
    public static void main(String[] args) {
        // Criar objeto Scanner para ler do teclado
        Scanner teclado = new Scanner(System.in);

        // Ler valor em segundos
        System.out.print("Introduza o valor em segundos: ");
        int segundos = teclado.nextInt();

        // Calcular horas, minutos e segundos
        int horas = segundos / 3600;
        int minutos = (segundos % 3600) / 60;
        int segundosRestantes = segundos % 60;

        // Apresentar resultado no formato hh:mm:ss
        System.out.printf("%02d:%02d:%02d\n", horas, minutos, segundosRestantes);

        // Fechar o Scanner
        teclado.close();
    }
}
