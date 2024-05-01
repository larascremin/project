package class_metodo;

import javax.swing.JOptionPane;

public class Exercicio {

    public static void main(String[] args) {

        int cadastros = 0;
        int opt;

        String[] nomes = new String[100];
        int[] idades = new int[100];
        String[] sexo = new String[100];
        String masculino = "m";
        String feminino = "f";

        do {
            opt = option();
            if (opt == 1) {
                cadastro(cadastros++, nomes, idades, sexo);
            } else if (opt == 2) {
                buscarNome(cadastros, nomes);
            } else if (opt == 3) {
                mediaSexo(cadastros, idades, sexo, masculino);
            } else if (opt == 4) {
                mediaSexo(cadastros, idades, sexo, feminino);
            } else if (opt == 5) {
                meninas(cadastros, sexo, idades, feminino);
            }
        } while (opt != 6);

    }

    private static int option() {
        int opt = Integer.parseInt(JOptionPane.showInputDialog(null,
                "1 - cadastrar pessoas \n" +
                        "2 - buscar contato por nome \n" +
                        "3 - media idade homens \n" +
                        "4 - media idade mulheres \n" +
                        "5 - quantidade de mulheres menores de 18 \n" +
                        "6 - sair"));
        return opt;
    }

    private static void cadastro(int cadastros, String[] nomes, int[] idades, String[] sexo) {
        nomes[cadastros] = JOptionPane.showInputDialog(null, "digite o nome da pessoa: " + (cadastros + 1));
        idades[cadastros] = Integer
                .parseInt(JOptionPane.showInputDialog(null, "digite a idade de " + nomes[cadastros]));
        sexo[cadastros] = JOptionPane.showInputDialog(null, "digite o sexo: (f/m)");

    }

    private static void buscarNome(int cadastros, String[] nomes) {
        String pesquisa = JOptionPane.showInputDialog(null, "pesquisar nome: ");
        for (int i = 0; i < cadastros; i++) {
            if (pesquisa.equals(nomes[i])) {
                JOptionPane.showMessageDialog(null, nomes[i] + ": esta cadastrado");
            } else {
                JOptionPane.showMessageDialog(null, ": não esta cadastrado");
            }
        }
    }

    private static void mediaSexo(int cadastros, int[] idades, String[] sexo, String escolha) {
        int somaIdades = 0;
        int somaSexo = 0;
        for (int i = 0; i < cadastros; i++) {
            if (escolha.equals(sexo[i])) {
                somaIdades += idades[i];
                somaSexo++;
            }
        }
        int media = somaIdades / somaSexo;
        JOptionPane.showMessageDialog(null, "a media é: " + media);
    }

    public static void meninas(int cadastros, String[] sexo, int[] idades, String feminino) {
        int somaMeninas = 0;
        for (int i = 0; i < cadastros; i++) {
            if (feminino.equals(sexo[i])) {
                if (idades[i] < 18) {
                    somaMeninas++;
                }
            }

        }
        JOptionPane.showMessageDialog(null, "meninas menores de 18: " + somaMeninas);
    }

}
