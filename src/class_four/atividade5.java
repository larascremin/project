package class_four;

import javax.swing.JOptionPane;

public class atividade5 {
    public static void main(String[] args) {

        int cadastrados = 0;
        int opcao = 0;
        int menorEstoque = 0;

        String[] produtos = new String[50];
        int[] quantidades = new int[50];
        double[] preços = new double[50];

        String baixoEstoque = "";
        String preçoAlto = "";
        String menorEstoqueProduto = "";
        String maiorPrecoProduto = "";

        double maiorPreco = 0;
        double percentual = 0;
        double zerado = 0;
        double contagem = 0;

        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "1 - cadastrar item \n" +
                            "2 - baixo estoque \n " +
                            "3 - produtos com preço +100 e estoque +10 \n" +
                            "4 - produto com menor estoque \n" +
                            "5 - produto com maior preço \n" +
                            "6 - % de produtos com estoque zerado \n" +
                            "7 - sair"));

            if (opcao == 1) {
                produtos[cadastrados] = JOptionPane.showInputDialog(null, "nome do produto:");
                quantidades[cadastrados] = Integer
                        .parseInt(JOptionPane.showInputDialog(null, "quantidade de itens no estoque: "));
                preços[cadastrados] = Double.parseDouble(JOptionPane.showInputDialog(null, "preço do produto"));
                cadastrados++;
                contagem++;
            }

            if (opcao == 2) {
                for (int i = 0; i < cadastrados; i++) {
                    if (quantidades[i] < 10) {
                        baixoEstoque += produtos[i] + "; ";
                    }
                }
                JOptionPane.showMessageDialog(null, "item com estoque baixo: " + baixoEstoque);
            }

            if (opcao == 3) {
                for (int i = 0; i < cadastrados; i++) {
                    if (preços[i] > 100 && quantidades[i] > 10) {
                        preçoAlto += produtos[i] + "; ";
                    }
                }
                JOptionPane.showMessageDialog(null, "item com preço +100 e estoque +10: " + preçoAlto);
            }

            menorEstoque = quantidades[0];

            if (opcao == 4) {
                for (int i = 0; i < cadastrados; i++) {
                    if (quantidades[i] < menorEstoque) {
                        menorEstoque = quantidades[i];
                        menorEstoqueProduto = produtos[i];
                    }
                }
                JOptionPane.showMessageDialog(null, "produto com menor estoque: " + menorEstoqueProduto);
            }

            maiorPreco = preços[0];

            if (opcao == 5) {
                for (int i = 0; i < cadastrados; i++) {
                    if (preços[i] > maiorPreco) {
                        maiorPreco = preços[i];
                        maiorPrecoProduto = produtos[i];
                    }
                }
                JOptionPane.showMessageDialog(null, "produto com maior preço: " + maiorPrecoProduto);
            }

            if (opcao == 6) {
                for (int i = 0; i < cadastrados; i++) {
                    if (quantidades[i] == 0) {
                        zerado++;

                    }
                }
                percentual = (zerado / contagem) * 100;
                JOptionPane.showMessageDialog(null, "percentual de produtos com estoque zerado: " + percentual + "%");
            }

        } while (opcao != 7);
    }

}
