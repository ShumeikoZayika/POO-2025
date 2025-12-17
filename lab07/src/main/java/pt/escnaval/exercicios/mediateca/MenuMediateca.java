package pt.escnaval.exercicios.mediateca;

import pt.escnaval.exercicios.mediateca.modelo.Album;
import pt.escnaval.exercicios.mediateca.modelo.Faixa;
import pt.escnaval.exercicios.mediateca.servicos.Mediateca;
import pt.escnaval.exercicios.mediateca.servicos.Mp3Util;
import pt.escnaval.exercicios.mediateca.servicos.RepositorioTexto;
import pt.escnaval.exercicios.mediateca.utils.UtilsIO;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuMediateca {
    private static final Mediateca mediateca = new Mediateca();
    private static final Path DATA = Paths.get("lab07", "data", "mediateca.csv");
    private static final Path MEDIA_DIR = Paths.get("lab07", "media");

    public static void main(String[] args) {
        carregar();
        try (Scanner sc = new Scanner(System.in)) {
            int op;
            do {
                mostrarMenu();
                op = UtilsIO.lerOpcao(sc, 0, 7);
                try {
                    switch (op) {
                        case 1 -> listarAlbuns();
                        case 2 -> adicionarAlbum(sc);
                        case 3 -> adicionarFaixa(sc);
                        case 4 -> removerAlbum(sc);
                        case 5 -> procurarPorAutor(sc);
                        case 6 -> copiarMp3(sc);
                        case 7 -> salvar();
                        case 0 -> System.out.println("A terminar...");
                        default -> System.out.println("Opção inválida");
                    }
                } catch (Exception e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            } while (op != 0);
        }
    }

    private static void carregar() {
        try {
            ArrayList<Album> carregados = RepositorioTexto.carregar(DATA);
            carregados.forEach(mediateca::adicionarAlbum);
            System.out.println("Mediateca: " + mediateca.tamanho() + " álbum(es) carregado(s)");
        } catch (Exception e) {
            System.out.println("Aviso: não foi possível carregar mediateca: " + e.getMessage());
        }
    }

    private static void mostrarMenu() {
        System.out.println("========== MEDIATECA ==========");
        System.out.println("1) Listar álbuns");
        System.out.println("2) Adicionar álbum");
        System.out.println("3) Adicionar faixa a álbum");
        System.out.println("4) Remover álbum");
        System.out.println("5) Procurar por autor");
        System.out.println("6) Copiar ficheiro mp3 para repositório local");
        System.out.println("7) Guardar mediateca");
        System.out.println("0) Sair");
    }

    private static void listarAlbuns() {
        ArrayList<Album> l = mediateca.listarAlbuns();
        if (l.isEmpty()) {
            System.out.println("(nenhum álbum registado)");
            return;
        }
        System.out.println("=== ÁLBUNS ===");
        int i = 1;
        for (Album a : l) {
            System.out.printf("%d) %s%n", i++, a);
            a.getFaixas().forEach(f -> System.out.println("   " + f));
        }
    }

    private static void adicionarAlbum(Scanner sc) {
        System.out.println("--- Adicionar álbum ---");
        String id = UtilsIO.lerStringNaoVazia(sc, "ID: ");
        String titulo = UtilsIO.lerStringNaoVazia(sc, "Título: ");
        String autor = UtilsIO.lerStringNaoVazia(sc, "Autor: ");
        Album a = new Album(id, titulo, autor);
        mediateca.adicionarAlbum(a);
        System.out.println("Álbum adicionado: " + a.getTitulo());
    }

    private static void adicionarFaixa(Scanner sc) {
        System.out.println("--- Adicionar faixa ---");
        String id = UtilsIO.lerStringNaoVazia(sc, "ID do álbum: ");
        Album a = mediateca.buscarPorId(id);
        if (a == null) {
            System.out.println("Álbum não encontrado");
            return;
        }
        int num = UtilsIO.lerInt(sc, "Número da faixa: ");
        String titulo = UtilsIO.lerStringNaoVazia(sc, "Título da faixa: ");
        int dur = UtilsIO.lerInt(sc, "Duração (s): ");
        System.out.print("Caminho mp3 (opcional): ");
        String path = sc.nextLine().trim();
        if (path.isEmpty()) path = null;
        Faixa f = new Faixa(num, titulo, dur, path);
        a.adicionarFaixa(f);
        System.out.println("Faixa adicionada ao álbum " + a.getTitulo());
    }

    private static void removerAlbum(Scanner sc) {
        System.out.println("--- Remover álbum ---");
        String id = UtilsIO.lerStringNaoVazia(sc, "ID do álbum: ");
        boolean rem = mediateca.removerAlbum(id);
        System.out.println(rem ? "Álbum removido" : "Álbum não encontrado");
    }

    private static void procurarPorAutor(Scanner sc) {
        String autor = UtilsIO.lerStringNaoVazia(sc, "Autor: ");
        ArrayList<Album> r = mediateca.buscarPorAutor(autor);
        if (r.isEmpty()) {
            System.out.println("Nenhum álbum encontrado para autor: " + autor);
            return;
        }
        r.forEach(System.out::println);
    }

    private static void copiarMp3(Scanner sc) {
        System.out.println("--- Copiar mp3 ---");
        String origem = UtilsIO.lerStringNaoVazia(sc, "Caminho origem do mp3: ");
        String destinoNome = UtilsIO.lerStringNaoVazia(sc, "Nome destino (ex: exemplo.mp3): ");
        Path o = Paths.get(origem);
        Path d = MEDIA_DIR.resolve(destinoNome);
        try {
            Mp3Util.copy(o, d);
            System.out.println("Ficheiro copiado para: " + d.toAbsolutePath());
        } catch (Exception e) {
            System.out.println("Erro ao copiar mp3: " + e.getMessage());
        }
    }

    private static void salvar() {
        try {
            RepositorioTexto.salvar(DATA, mediateca.listarAlbuns());
            System.out.println("Mediateca guardada em: " + DATA.toAbsolutePath());
        } catch (Exception e) {
            System.out.println("Erro ao guardar: " + e.getMessage());
        }
    }
}
