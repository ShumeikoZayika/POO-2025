package pt.escnaval.exercicios;

import java.util.Scanner;

public class AnaliseProducao {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int totalPecas = 0; // Número total de peças produzidas
    int numDias = 0; // Número total de dias
    int diasInferior250 = 0; // Número de dias com produção inferior a 250

    System.out.println("Insira o número de peças produzidas por dia (-1 para terminar):");

    while (true) {
      int pecasDia = scanner.nextInt(); // Número de peças produzidas em um dia específico
      if (pecasDia == -1) {
        break; // Termina o loop se o usuário inserir -1
      }

      totalPecas += pecasDia; // Atualiza o total de peças
      numDias++; // Atualiza o número total de dias

      if (pecasDia < 250) {
        diasInferior250++; // Atualiza o número de dias com produção inferior a 250
      }
    }

    // Calcula a média de peças produzidas por dia
    double mediaPecas = (double) totalPecas / numDias;

    // Exibe as estatísticas
    System.out.println("Número total de peças produzidas: " + totalPecas);
    System.out.printf("Número médio de peças produzidas por dia: %.2f\n", mediaPecas);
    System.out.println("Número de dias com produção inferior a 250 peças: " + diasInferior250);

    scanner.close();
  }
}
