import java.util.Scanner;

// Programa para calcular a nota final de programação
public class NotaFinalProgramacao {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // Ler nota da avaliação periódica
        System.out.print("Introduza a nota da avaliação periódica (0 a 20): ");
        double notaPeriodica = teclado.nextDouble();

        // Ler nota da avaliação final
        System.out.print("Introduza a nota da avaliação final (0 a 20): ");
        double notaFinal = teclado.nextDouble();

        // Calcular média ponderada
        double mediaPonderada = notaPeriodica * 0.3 + notaFinal * 0.7;

        // Verificar se alguma nota é inferior a 6
        if (notaPeriodica < 6 || notaFinal < 6) {
            System.out.printf("Nota final: %.2f - Reprovado por uma das notas ser nota inferior à mínima\n", mediaPonderada);
        } else {
            System.out.printf("Nota final: %.2f\n", mediaPonderada);
        }

        teclado.close();
    }
}
