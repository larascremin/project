
package class_metodo;

import javax.swing.JOptionPane;

public class SimuladoClavison {

    public static void main(String[] args) {

        int cadastros = 0;
        int opt;

        String[] nomes = new String[100];
        double[][] notas = new double[100][3];
        int[] idades = new int[100];
        double[] mediasNota = new double[100];
        String[] sexo = new String[100];

        do {
            opt = opcao();

            if (opt == 1) {
                cadastro(cadastros++, nomes, idades, sexo, notas);
            } else if (opt == 2) {
                mensagemMedia(cadastros, nomes, notas, mediasNota);
            } else if (opt == 3) {
                status(cadastros, nomes, notas, mediasNota);
            } else if (opt == 4) {
                percentuais(cadastros, nomes, notas, mediasNota, sexo);
            } else if (opt == 5) {
                mediaIdades(cadastros, idades);
            } else if (opt == 6) {
                listaSexo(cadastros, nomes, sexo);
            } else if (opt == 7) {
                listaIdade(cadastros, nomes, idades);
            }

        } while (opt != 8);

    }

    // menu

    private static int opcao() {
        int opt = Integer.parseInt(JOptionPane.showInputDialog(null,
                "1 - cadastrar alunos \n" +
                        "2 - calcular a média de todos os alunos \n" +
                        "3 - exibir alunos aprovados, reprovados ou em recuperação \n" +
                        "4 - percentual de mulheres e homens reprovados \n" +
                        "5 - media das idades da turma \n" +
                        "6 - listar alunos por sexo \n" +
                        "7 - listar alunos por idade \n" +
                        "8 - sair"));
        return opt;
    }

    // opcao 1: cadastrar aluno e nota separado

    private static void cadastro(int cadastros, String[] nomes, int[] idades, String[] sexo, double[][] notas) {
        do {
            nomes[cadastros] = JOptionPane.showInputDialog(null,
                    "(campo obrigatorio) digite o nome da pessoa: " + (cadastros + 1));
        } while (nomes[cadastros].isEmpty());

        do {
            idades[cadastros] = Integer
                    .parseInt(JOptionPane.showInputDialog(null, "digite a idade: (17 - 99)"));
        } while (idades[cadastros] <= 17 || idades[cadastros] >= 99);

        sexo[cadastros] = JOptionPane.showInputDialog(null, "digite o sexo: (m/f)");
        cadastroNotas(cadastros, notas);
    }

    private static void cadastroNotas(int cadastros, double[][] notas) {
        for (int i = 0; i < 3; i++) {
            do {
                notas[cadastros][i] = Double.parseDouble(JOptionPane.showInputDialog(null, "nota: " + (i + 1)));
            } while (notas[cadastros][i] < 0 || notas[cadastros][i] > 10);

        }
    }

    // opcao 2: media alunos

    private static void mediaNotas(int cadastrados, String[] nomes, double[][] notas, double[] mediasNota) {
        for (int i = 0; i < cadastrados; i++) {
            double somaNota = 0;
            mediasNota[i] = 0;

            for (int j = 0; j < 3; j++) {
                somaNota += notas[i][j];
                mediasNota[i] = somaNota / 3;
            }
        }
    }

    private static void mensagemMedia(int cadastrados, String[] nomes, double[][] notas, double[] mediasNota) {
        mediaNotas(cadastrados, nomes, notas, mediasNota);
        for (int i = 0; i < cadastrados; i++) {
            JOptionPane.showMessageDialog(null, nomes[i] + ": " + mediasNota[i]);
        }
    }

    // opcao 3: status dos alunos

    private static void status(int cadastrados, String[] nomes, double[][] notas, double[] mediasNota) {
        mediaNotas(cadastrados, nomes, notas, mediasNota);
        for (int i = 0; i < cadastrados; i++) {
            if (mediasNota[i] >= 7) {
                JOptionPane.showMessageDialog(null, nomes[i] + ": aprovado");
            } else if (mediasNota[i] <= 3) {
                JOptionPane.showMessageDialog(null, nomes[i] + ": reprovado");
            } else {
                JOptionPane.showMessageDialog(null, nomes[i] + ": em recuperação");
            }
        }
    }

    // opcao 4: percentual reprovados

    private static void percentuais(int cadastrados, String[] nomes, double[][] notas, double[] mediasNota,
            String[] sexo) {
        mediaNotas(cadastrados, sexo, notas, mediasNota);
        double fem = 0;
        double masc = 0;
        double femReprovadas = 0;
        double mascReprovados = 0;

        for (int i = 0; i < cadastrados; i++) {
            if (sexo[i].equalsIgnoreCase("m")) {
                masc++;
                if (mediasNota[i] <= 3) {
                    mascReprovados++;
                }
            } else if (sexo[i].equalsIgnoreCase("f")) {
                fem++;
                if (mediasNota[i] <= 3) {
                    femReprovadas++;
                }
            }
        }

        double femPercentual = (femReprovadas / fem) * 100;
        double mascPercentual = (mascReprovados / masc) * 100;

        JOptionPane.showMessageDialog(null, "homens reprovados: " + mascPercentual + "%");
        JOptionPane.showMessageDialog(null, "mulheres reprovadas: " + femPercentual + "%");
    }

    // opcao 5: media idade

    private static void mediaIdades(int cadastrados, int[] idade) {
        int idadeTotal = 0;

        for (int i = 0; i < cadastrados; i++) {
            idadeTotal += idade[i];
        }

        int mediaIdade = idadeTotal / cadastrados;

        JOptionPane.showMessageDialog(null, "media idade: " + mediaIdade);
    }

    // opcao 6: listar por sexo

    private static void listaSexo(int cadastrados, String[] nomes, String[] sexo) {
        String escolha = JOptionPane.showInputDialog(null, "pesquisar sexo: (m/f)");
        String lista = "";

        for (int i = 0; i < cadastrados; i++) {
            if (sexo[i].equalsIgnoreCase(escolha)) {
                lista += nomes[i] + "; \n";
            }
        }

        if (escolha.equalsIgnoreCase("f")) {
            JOptionPane.showMessageDialog(null, "lista de mulheres: \n\n" + lista);
        } else if (escolha.equalsIgnoreCase("m")) {
            JOptionPane.showMessageDialog(null, "lista de homens: \n\n" + lista);
        } else {
            JOptionPane.showMessageDialog(null, "argumento invalido, tente novamente");
        }
    }

    // opcao 7: lista por idade

    private static void listaIdade(int cadastrados, String[] nomes, int[] idades) {
        int escolha = Integer.parseInt(JOptionPane.showInputDialog(null, "pesquisar idade: "));
        String lista = "";

        for (int i = 0; i < cadastrados; i++) {
            if (idades[i] == escolha) {
                lista += nomes[i] + "; \n";
            }
        }
        JOptionPane.showMessageDialog(null, "pessoas com essa idade:" + lista);
    }

}
