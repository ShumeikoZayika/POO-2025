package pt.escnaval.exercicios;

/**
 * Demonstra ordenacao e busca usando arrays.
 */
public class DemoOrdenacao {
    public static void main(String[] args) {
        Endereco end1 = new Endereco("Rua A", "Lisboa", "1000-001");
        Endereco end2 = new Endereco("Rua B", "Porto", "4000-001");
        Endereco end3 = new Endereco("Rua C", "Coimbra", "3000-001");

        Cliente[] clientes = new Cliente[5];
        clientes[0] = new Cliente(3, "Carlos Pereira", "carlos@example.com", end1, "aaaa");
        clientes[1] = new Cliente(1, "Ana Silva", "ana@example.com", end2, "bbbb");
        clientes[2] = new Cliente(5, "Bruno Costa", "bruno@example.com", end3, "cccc");
        clientes[3] = new Cliente(2, "Ana Santos", "ana.santos@example.com", end1, "dddd");
        clientes[4] = new Cliente(4, "Diana Lopes", "diana@example.com", end2, "eeee");

        System.out.println("=== Array Original ===");
        mostrar(clientes);

        ordenarPorNomeEId(clientes);
        System.out.println("\n=== Ordenado por nome (tie-break id) ===");
        mostrar(clientes);

        System.out.println("\nBusca sequencial por Bruno Costa: " + buscaSequencial(clientes, "Bruno Costa"));
        System.out.println("Busca sequencial por Joao: " + buscaSequencial(clientes, "Joao"));

        int indice = buscaBinariaPorNome(clientes, "Diana Lopes");
        System.out.println("\nBusca binaria por Diana Lopes: indice=" + indice);
    }

    private static void ordenarPorNomeEId(Cliente[] clientes) {
        int n = clientes.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                int cmp = clientes[j].getNome().compareTo(clientes[j + 1].getNome());
                boolean trocar = false;
                if (cmp > 0) {
                    trocar = true;
                } else if (cmp == 0 && clientes[j].getId() > clientes[j + 1].getId()) {
                    trocar = true;
                }
                if (trocar) {
                    Cliente tmp = clientes[j];
                    clientes[j] = clientes[j + 1];
                    clientes[j + 1] = tmp;
                }
            }
        }
    }

    private static Cliente buscaSequencial(Cliente[] clientes, String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equals(nome)) {
                return cliente;
            }
        }
        return null;
    }

    private static int buscaBinariaPorNome(Cliente[] clientes, String nome) {
        int esquerda = 0;
        int direita = clientes.length - 1;
        while (esquerda <= direita) {
            int meio = esquerda + (direita - esquerda) / 2;
            int cmp = clientes[meio].getNome().compareTo(nome);
            if (cmp == 0) {
                return meio;
            } else if (cmp < 0) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }
        return -1;
    }

    private static void mostrar(Cliente[] clientes) {
        for (int i = 0; i < clientes.length; i++) {
            System.out.printf("[%d] %s%n", i, clientes[i]);
        }
    }
}
