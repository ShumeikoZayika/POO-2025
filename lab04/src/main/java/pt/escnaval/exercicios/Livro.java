package pt.escnaval.exercicios;

public class Livro {
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private String genero;
    private boolean disponibilidade;

    public Livro(String titulo, String autor, int anoPublicacao, String genero, boolean disponibilidade) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.genero = genero;
        this.disponibilidade = disponibilidade;
    }

    public Livro(String titulo, String autor) {
        this(titulo, autor, 0, "Não especificado", false);
    }

    public Livro() {
        this("Sem título", "Desconhecido", 0, "Não especificado", false);
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public int getAnoPublicacao() { return anoPublicacao; }
    public void setAnoPublicacao(int anoPublicacao) { this.anoPublicacao = anoPublicacao; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public boolean isDisponibilidade() { return disponibilidade; }
    public void setDisponibilidade(boolean disponibilidade) { this.disponibilidade = disponibilidade; }

    public String formatarInformacoes() {
        return "Título: " + titulo + "\n" +
               "Autor: " + autor + "\n" +
               "Ano de Publicação: " + anoPublicacao + "\n" +
               "Gênero: " + genero + "\n" +
               "Disponibilidade: " + (disponibilidade ? "Disponível" : "Indisponível");
    }

    public static void main(String[] args) {
        Livro livro1 = new Livro("1984", "George Orwell", 1949, "Distopia", true);
        Livro livro2 = new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", 1943, "Fábula", false);
        Livro livro3 = new Livro("Dom Quixote", "Miguel de Cervantes", 1605, "Romance", false);

        System.out.println("Livro 1:\n" + livro1.formatarInformacoes() + "\n");
        System.out.println("Livro 2:\n" + livro2.formatarInformacoes() + "\n");
        System.out.println("Livro 3:\n" + livro3.formatarInformacoes() + "\n");

        Livro[] livros = new Livro[10];
        for (int i = 0; i < livros.length; i++) {
            livros[i] = new Livro("Título " + (i + 1), "Autor " + (i + 1));
        }

        for (int i = 0; i < livros.length; i++) {
            System.out.println("Coleção Livro " + (i + 1) + ":\n" + livros[i].formatarInformacoes() + "\n");
        }
    }
}
package pt.escnaval.exercicios;

public class Livro {
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private String genero;
    private boolean disponibilidade;

    public Livro(String titulo, String autor, int anoPublicacao, String genero, boolean disponibilidade) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.genero = genero;
        this.disponibilidade = disponibilidade;
    }

    public Livro(String titulo, String autor) {
        this(titulo, autor, 0, "Não especificado", false);
    }

    public Livro() {
        this("Sem título", "Desconhecido", 0, "Não especificado", false);
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public int getAnoPublicacao() { return anoPublicacao; }
    public void setAnoPublicacao(int anoPublicacao) { this.anoPublicacao = anoPublicacao; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public boolean isDisponibilidade() { return disponibilidade; }
    public void setDisponibilidade(boolean disponibilidade) { this.disponibilidade = disponibilidade; }
package pt.escnaval.exercicios;

public class Livro {
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private String genero;
    private boolean disponibilidade;

    public Livro(String titulo, String autor, int anoPublicacao, String genero, boolean disponibilidade) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.genero = genero;
        this.disponibilidade = disponibilidade;
    }

    public Livro(String titulo, String autor) {
        this(titulo, autor, 0, "Não especificado", false);
    }

    public Livro() {
        this("Sem título", "Desconhecido", 0, "Não especificado", false);
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public int getAnoPublicacao() { return anoPublicacao; }
    public void setAnoPublicacao(int anoPublicacao) { this.anoPublicacao = anoPublicacao; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public boolean isDisponibilidade() { return disponibilidade; }
    public void setDisponibilidade(boolean disponibilidade) { this.disponibilidade = disponibilidade; }

    public String formatarInformacoes() {
        return "Título: " + titulo + "\n" +
               "Autor: " + autor + "\n" +
               "Ano de Publicação: " + anoPublicacao + "\n" +
               "Gênero: " + genero + "\n" +
               "Disponibilidade: " + (disponibilidade ? "Disponível" : "Indisponível");
    }

    public static void main(String[] args) {
        Livro livro1 = new Livro("1984", "George Orwell", 1949, "Distopia", true);
        Livro livro2 = new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", 1943, "Fábula", false);
        Livro livro3 = new Livro("Dom Quixote", "Miguel de Cervantes", 1605, "Romance", false);

        System.out.println("Livro 1:\n" + livro1.formatarInformacoes() + "\n");
        System.out.println("Livro 2:\n" + livro2.formatarInformacoes() + "\n");
        System.out.println("Livro 3:\n" + livro3.formatarInformacoes() + "\n");

        Livro[] livros = new Livro[10];
        for (int i = 0; i < livros.length; i++) {
            livros[i] = new Livro("Título " + (i + 1), "Autor " + (i + 1));
        }

        for (int i = 0; i < livros.length; i++) {
            System.out.println("Coleção Livro " + (i + 1) + ":\n" + livros[i].formatarInformacoes() + "\n");
        }
    }
}
	// Método para formatar a saída das informações do livro
