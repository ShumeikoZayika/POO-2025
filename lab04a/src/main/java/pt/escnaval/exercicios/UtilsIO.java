package pt.escnaval.exercicios;

import java.util.Scanner;

public final class UtilsIO {
    private UtilsIO() {
    }

    public static int lerInt(Scanner sc, String prompt) {
        System.out.print(prompt);
        while (true) {
            String linha = sc.nextLine();
            if (ehInteiro(linha)) {
                return Integer.parseInt(linha.trim());
            }
            System.out.print("Inteiro inválido. Tente novamente: ");
        }
    }

    public static int lerOpcao(Scanner sc, int minimo, int maximo) {
        while (true) {
            String linha = sc.nextLine();
            if (!ehInteiro(linha)) {
                System.out.print("Opção inválida. Introduza um número: ");
                continue;
            }
            int valor = Integer.parseInt(linha.trim());
            if (valor < minimo || valor > maximo) {
                System.out.printf("Opção fora do intervalo (%d..%d). Tente de novo: ", minimo, maximo);
                continue;
            }
            return valor;
        }
    }

    public static String lerLinhaObrigatoria(Scanner sc, String prompt) {
        System.out.print(prompt);
        while (true) {
            String linha = sc.nextLine();
            if (linha != null) {
                String normalizada = linha.trim();
                if (!normalizada.isEmpty()) {
                    return normalizada;
                }
            }
            System.out.print("Valor obrigatório. Tente novamente: ");
        }
    }

    private static boolean ehInteiro(String valor) {
        if (valor == null) {
            return false;
        }
        String texto = valor.trim();
        if (texto.isEmpty()) {
            return false;
        }
        int inicio = texto.startsWith("-") ? 1 : 0;
        if (inicio == texto.length()) {
            return false;
        }
        for (int i = inicio; i < texto.length(); i++) {
            if (!Character.isDigit(texto.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
