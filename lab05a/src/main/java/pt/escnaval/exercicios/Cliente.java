package pt.escnaval.exercicios;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Cliente e uma entidade identificada por id.
 */
public class Cliente implements Autenticavel {
    private final int id;
    private String nome;
    private String email;
    private Endereco endereco;
    private String senha;
    private final boolean valido;

    private static final Pattern EMAIL_RE =
            Pattern.compile("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");

    public Cliente(int id, String nome, String email, Endereco endereco, String senha) {
        this.id = id;
        if (id <= 0 || isBlank(nome) || !emailValido(email) || endereco == null || !endereco.isValido()
                || senha == null || senha.trim().length() < 4) {
            this.nome = "";
            this.email = "";
            this.endereco = null;
            this.senha = "";
            this.valido = false;
        } else {
            this.nome = nome.trim();
            this.email = email.trim();
            this.endereco = endereco;
            this.senha = senha.trim();
            this.valido = true;
        }
    }

    private static boolean isBlank(String valor) {
        return valor == null || valor.trim().isEmpty();
    }

    private static boolean emailValido(String email) {
        return email != null && EMAIL_RE.matcher(email.trim()).matches();
    }

    public boolean isValido() {
        return valido;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public boolean mudarEmail(String novoEmail) {
        if (!valido || !emailValido(novoEmail)) {
            return false;
        }
        this.email = novoEmail.trim();
        return true;
    }

    public boolean mudarEndereco(Endereco novoEndereco) {
        if (!valido || novoEndereco == null || !novoEndereco.isValido()) {
            return false;
        }
        this.endereco = novoEndereco;
        return true;
    }

    public boolean mudarSenha(String senhaAtual, String novaSenha) {
        if (!autenticar(senhaAtual) || novaSenha == null || novaSenha.trim().length() < 4) {
            return false;
        }
        this.senha = novaSenha.trim();
        return true;
    }

    @Override
    public boolean autenticar(String senhaInformada) {
        return valido && senhaInformada != null && senha.equals(senhaInformada.trim());
    }

    @Override
    public String getIdentificador() {
        return email;
    }

    @Override
    public String toString() {
        if (!valido) {
            return "[Cliente invalido]";
        }
        return String.format("%d\t%-18s <%s> @ %s", id, nome, email, endereco);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) o;
        return id == other.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
