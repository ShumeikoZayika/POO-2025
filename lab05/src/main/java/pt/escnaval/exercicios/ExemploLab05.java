package pt.escnaval.exercicios;

public class ExemploLab05 {
    public static void main(String[] args) {
        Conta[] contas = new Conta[10];
        for (int i = 0; i < 10; i++) {
            int j = i + 1;
            Cliente c = new Cliente(j, "Nome " + j, j / 100.0);
            String codPostal = j * 1000 + "" + j + " Localidade " + j;
            Endereco e = new Endereco("Rua " + j, j + 10, codPostal);
            contas[i] = new Conta(j, c, j * 1000.0, e);
        }
        for (Conta c : contas) {
            c.mostrar();
            c.getCliente().mostrar();
            c.mostrarEndereco();
            System.out.println();
        }
    }
}