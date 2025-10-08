package pt.escnaval.exercicios;

import java.util.Scanner;

// Programa para calcular o número de horas e minutos trabalhados num dia
public class HorasTrabalhadas {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // Ler horários de entrada e saída
        System.out.print("Hora de entrada de manhã (hh mm): ");
        int horaEntradaManha = teclado.nextInt();
        int minutoEntradaManha = teclado.nextInt();

        System.out.print("Hora de saída para almoço (hh mm): ");
        int horaSaidaAlmoco = teclado.nextInt();
        int minutoSaidaAlmoco = teclado.nextInt();

        System.out.print("Hora de entrada depois do almoço (hh mm): ");
        int horaEntradaAlmoco = teclado.nextInt();
        int minutoEntradaAlmoco = teclado.nextInt();

        System.out.print("Hora de saída final do dia (hh mm): ");
        int horaSaidaFinal = teclado.nextInt();
        int minutoSaidaFinal = teclado.nextInt();

        // Calcular minutos trabalhados de manhã
        int minutosManha = (horaSaidaAlmoco * 60 + minutoSaidaAlmoco) - (horaEntradaManha * 60 + minutoEntradaManha);
        // Calcular minutos trabalhados à tarde
        int minutosTarde = (horaSaidaFinal * 60 + minutoSaidaFinal) - (horaEntradaAlmoco * 60 + minutoEntradaAlmoco);
        // Total de minutos trabalhados
        int minutosTotais = minutosManha + minutosTarde;

        int horasTrabalhadas = minutosTotais / 60;
        int minutosRestantes = minutosTotais % 60;

        // Apresentar resultado
        System.out.printf("Tempo total trabalhado: %d horas e %d minutos.\n", horasTrabalhadas, minutosRestantes);

        teclado.close();
    }
}
