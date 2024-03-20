package class_four;

import javax.swing.JOptionPane;

public class atividade2 {
    public static void main(String[] args) {

        int quantidade = 0;
        int opcao = 0;

        String marcasCarros[] = new String[20];
        String placaCarros[] = new String[20];
        int anoCarros[] = new int[20];

        int carroNovo = 0;
        String placaNovo = "";
        String marcaNovo = "";

        String verificacao = "";

        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "1 - Cadastrar carro \n 2 - Carro mais novo \n 3 - Buscar Placa \n 4 - Sair"));

            if (opcao == 1) {
                marcasCarros[quantidade] = JOptionPane.showInputDialog("Insira a marca do carro:");
                placaCarros[quantidade] = JOptionPane.showInputDialog("Insira a placa do carro:");
                anoCarros[quantidade] = Integer.parseInt(JOptionPane.showInputDialog("Insira o ano do carro:"));
                quantidade++;
            }

            if (opcao == 2) {
                for (int i = 0; i < quantidade; i++) {
                    if (anoCarros[i] > carroNovo) {
                        carroNovo = anoCarros[i];
                        marcaNovo = marcasCarros[i];
                        placaNovo = placaCarros[i];
                    }
                }
                JOptionPane.showMessageDialog(null, "carro novo = " + marcaNovo + " e " + placaNovo);
            }

            if (opcao == 3) {
                verificacao = JOptionPane.showInputDialog("Insira a placa:");
                for (int i = 0; i < quantidade; i++) {
                    if (verificacao.equals(placaCarros[i])) {
                        JOptionPane.showMessageDialog(null,
                                "Ano da placa: " + anoCarros[i] + " Marca da placa: " + marcasCarros[i]);
                    }
                }
            }

            System.out.print(quantidade);
            System.out.print(opcao);

        } while (opcao != 4);
    }

}
