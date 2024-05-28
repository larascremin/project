package avaliacao;

import javax.swing.JOptionPane;

public class Questao1 {

    public static void main(String[] args) {

        int cadastrados = 0;
        int opcao = 0;

        String[] nomes = new String[100];
        int[] estoque = new int[100];
        double[] valoresProdutos = new double[100];
        int[][] vendas = new int[100][4];

        do {

            opcao = opcao();

            if (opcao == 1) {
                cadastrar(nomes, estoque, valoresProdutos, cadastrados, vendas);
                cadastrados++;
            } else if (opcao == 2) {
                lerNome(nomes, cadastrados, estoque, valoresProdutos, vendas);
            } else if (opcao == 3) {
                totalVendas(nomes, cadastrados, estoque, valoresProdutos, vendas);
            } else if (opcao == 4) {
                estoqueProdutos(nomes, cadastrados, estoque, valoresProdutos);
            } else {
                mensagemInvalida();
            }

        } while (opcao != 5);

    }

    // menu
    private static int opcao() {
        int opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
                "1 - cadastrar \n" +
                        "2 - buscar por nome \n" +
                        "3 - total de vendas do mes \n" +
                        "4 - estoque de todos produtos \n" +
                        "5 - sair"));
        return opcao;
    }

    // cadastrar produtos
    private static void cadastrar(String[] nomes, int[] estoque, double[] valoresProdutos, int cadastrados,
            int[][] vendas) {

        do {
            nomes[cadastrados] = JOptionPane.showInputDialog("nome do produto: ");
        } while (nomes[cadastrados].length() <= 3);

        do {
            estoque[cadastrados] = Integer.parseInt(JOptionPane.showInputDialog("quantidade em estoque: "));
        } while (estoque[cadastrados] <= 0);

        do {
            valoresProdutos[cadastrados] = Double.parseDouble(JOptionPane.showInputDialog("valor deste produto: "));
        } while (valoresProdutos[cadastrados] < 0);

        cadastrarVendas(nomes, estoque, valoresProdutos, cadastrados, vendas);

    }

    // cadastrar vendas
    private static void cadastrarVendas(String[] nomes, int[] estoque, double[] valoresProdutos, int cadastrados,
            int[][] vendas) {

        for (int i = 0; i < 4; i++) {

            do {
                vendas[cadastrados][i] = Integer.parseInt(JOptionPane.showInputDialog("vendas no mes: " + (i + 1)));
            } while (nomes[cadastrados].length() < 0);
        }
    }

    // buscar nome do produto
    private static void lerNome(String[] nomes, int cadastrados, int[] estoque, double[] valoresProdutos,
            int[][] vendas) {

        String pesquisaNome = JOptionPane.showInputDialog("pesquisar nome: ");
        String resultadoNome = "não encontrado";

        for (int i = 0; i < cadastrados; i++) {

            if (pesquisaNome.equalsIgnoreCase(nomes[i])) {
                resultadoNome = "quantidade em estoque: " + estoque[i] + "\n\n valor do produto: "
                        + valoresProdutos[i]
                        + "\n\n vendidos no mes 1: " + vendas[i][0] + "\n vendidos no mes 2: " + vendas[i][1]
                        + "\n vendidos no mes 3: " + vendas[i][2] + "\n vendidos no mes 3: " + vendas[i][3];
            }
            JOptionPane.showMessageDialog(null, resultadoNome);
        }
    }

    // total de vendas mes
    private static void totalVendas(String[] nomes, int cadastrados, int[] estoque, double[] valoresProdutos,
            int[][] vendas) {

        int mesEscolhido = Integer.parseInt(JOptionPane.showInputDialog("buscar vendas no mes: "));
        int totalVendas = 0;
        double valorFinal = 0;

        for (int i = 0; i < cadastrados; i++) {

            totalVendas += vendas[i][mesEscolhido];
            valorFinal = totalVendas * valoresProdutos[i];
        }
        JOptionPane.showMessageDialog(null, "total de vendas do mes " + mesEscolhido + ": " + valorFinal);
    }

    // estoque
    private static void estoqueProdutos(String[] nomes, int cadastrados, int[] estoque, double[] valoresProdutos) {
        String lista = "";

        for (int i = 0; i < cadastrados; i++) {
            if (estoque[i] >= 0) {
                lista += nomes[i] + ": " + estoque[i] + "; \n";
            }
        }
        JOptionPane.showMessageDialog(null, "estoque: \n\n" + lista);
    }

    // ler mensagem
    private static void mensagemInvalida() {
        JOptionPane.showMessageDialog(null, "opcao selecionada não é valida, escolha entre 1 - 5");
    }

}
