package class_metodo;

import javax.swing.JOptionPane;

public class Simulado {

    public static void main(String[] args) {

        int cadastros = 0;
        int opt;

        String[] nomes = new String[100];
        int[][] notas = new int[100][3];
        int[] idades = new int[100];
        String[] sexo = new String[100];
        String masculino = "M";
        String feminino = "F";

        do {
            opt = opcao();

            if (opt == 1) {
                cadastro(cadastros++, nomes, idades, sexo, notas);
            } else if (opt == 2) {
                mediaNova(cadastros, nomes, notas, cadastros);
            } else if (opt == 3) {
                status(cadastros, nomes, notas, opt);
            } else if (opt == 4) {

            }

        } while (opt != 8);

    }

    private static int opcao() {
        int opt = Integer.parseInt(JOptionPane.showInputDialog(null,
                "1 - cadastrar alunos \n" +
                        "2 - calcular a média de todos os alunos \n" +
                        "3 - exibir alunos e se estão aprovados, reprovaos ou em recuperação \n" +
                        "4 - percentual de mulheres e homens reprovados \n" +
                        "5 - media das idades da turma \n" +
                        "6 - listar alunos por sexo \n" +
                        "7 - listar alunos por idade \n" +
                        "8 - sair"));
        return opt;
    }

    private static void cadastro(int cadastros, String[] nomes, int[] idades, String[] sexo, int[][] notas) {
        nomes[cadastros] = JOptionPane.showInputDialog(null, "digite o nome da pessoa: " + (cadastros + 1));
        idades[cadastros] = Integer
                .parseInt(JOptionPane.showInputDialog(null, "digite a idade: "));
        sexo[cadastros] = JOptionPane.showInputDialog(null, "digite o sexo: (f/m)");
        cadastroNotas(cadastros, notas);
    }

    private static void buscarAluno(int cadastros, String[] nomes) {
        String pesquisa = JOptionPane.showInputDialog(null, "pesquisar nome: ");
        for (int i = 0; i < cadastros; i++) {
            if (pesquisa.equals(nomes[i])) {
                JOptionPane.showMessageDialog(null, nomes[i] + ": esta cadastrado");
            }
        }
    }

    private static void cadastroNotas(int cadastros, int[][] notas) {
        for (int i = 0; i < 3; i++) {
            notas[cadastros][i] = Integer.parseInt(JOptionPane.showInputDialog(null, "nota: " + (i + 1)));
        }
    }

    private static void media(int cadastrados, String[] nomes, int[][] notas) {

        for (int i = 0; i < cadastrados; i++) {
            int somaNota = 0;
            int media = 0;

            for (int j = 0; j < 3; j++) {
                somaNota += notas[i][j];
                media = somaNota / 3;
            }
            JOptionPane.showMessageDialog(null, nomes[i] + (i + 1) + ": " + media);
        }
    }

    private static int[] mediaNova(int cadastrados, String[] nomes, int[][] notas, int cadastros) {

        int[] mediaNotas = new int[cadastros];

        for (int i = 0; i < cadastrados; i++) {
            int somaNota = 0;
            int media = 0;

            for (int j = 0; j < 3; j++) {
                somaNota += notas[i][j];
                media = somaNota / 3;
            }
        }
        return mediaNotas;
    }

    private static void status(int cadastrados, String[] nomes, int[][] notas, int media) {

        for (int i = 0; i < cadastrados; i++) {
            if (media >= 7) {
                JOptionPane.showMessageDialog(null, nomes[i] + ": aprovado");
            } else if (media >= 3) {
                JOptionPane.showMessageDialog(null, nomes[i] + ": em recuperacao");
            } else {
                JOptionPane.showMessageDialog(null, nomes[i] + ": reprovado");
            }
        }
    }

}
