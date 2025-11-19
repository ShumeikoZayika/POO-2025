package pt.escnaval.exercicios;

public class DemoArmadilhas {

    static class SemHash {
        final int id;

        SemHash(int id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            return (o instanceof SemHash) && ((SemHash) o).id == id;
        }
        // hashCode ausente (armadilha)
    }

    static class HashMutavel {
        int valor;

        HashMutavel(int valor) {
            this.valor = valor;
        }

        @Override
        public boolean equals(Object o) {
            return (o instanceof HashMutavel) && ((HashMutavel) o).valor == valor;
        }

        @Override
        public int hashCode() {
            return Integer.hashCode(valor);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Armadilhas de equals/hashCode ===\n");

        SemHash sh1 = new SemHash(1);
        SemHash sh2 = new SemHash(1);
        System.out.println("--- equals sem hashCode ---");
        System.out.println("sh1.equals(sh2)? " + sh1.equals(sh2));
        System.out.println("hashCodes iguais? " + (sh1.hashCode() == sh2.hashCode()));
        System.out.println("Problema: objetos iguais podem ter hashes diferentes\n");

        System.out.println("--- hashCode com campo mutavel ---");
        HashMutavel hm = new HashMutavel(10);
        int hashAntes = hm.hashCode();
        System.out.println("Hash inicial: " + hashAntes);
        hm.valor = 20;
        int hashDepois = hm.hashCode();
        System.out.println("Hash apos mutacao: " + hashDepois);
        System.out.println("Hash mudou? " + (hashAntes != hashDepois));
    }
}
