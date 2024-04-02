package prova;

import javax.swing.JOptionPane;

public class numero4 {

    public static void main(String[] args) {

        String[] nomes = new String[100];
        int[] cpfs = new int[100];
        int opcao = 0;
        int cadastros = 0;
        String buscaNome;
        int buscaCpf = 0;

        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "1 - cadastrar pessoa \n" +
                            "2 - buscar por nome \n" +
                            "3 - buscar por cpf \n" +
                            "4 - sair"));

            if (opcao == 1) {
                nomes[cadastros] = JOptionPane.showInputDialog(null, "digite o nome da pessoa: " + (cadastros + 1));
                cpfs[cadastros] = Integer
                        .parseInt(JOptionPane.showInputDialog(null, "digite o cpf da pessoa " + nomes[cadastros]));
                cadastros++;
            }

            if (opcao == 2) {
                buscaNome = JOptionPane.showInputDialog(null, "pesquisar nome: ");
                for (int i = 0; i < cadastros; i++) {
                    if (buscaNome.equals(nomes[i])) {
                        JOptionPane.showMessageDialog(null, nomes[i] + ": " + cpfs[i]);
                    } else {
                        JOptionPane.showMessageDialog(null, "nome não encontrado");
                    }
                }
            }

            if (opcao == 3) {
                String res = "cpf não encontrado";
                buscaCpf = Integer.parseInt(JOptionPane.showInputDialog(null, "pesquisar cpf: "));
                for (int i = 0; i < cadastros; i++) {
                    if (buscaCpf == cpfs[i]) {
                        res = nomes[i] + ": " + cpfs[i];
                    } else {
                        JOptionPane.showMessageDialog(null, "cpf não encontrado");
                    }
                }
                JOptionPane.showMessageDialog(null, res);
            }
        } while (opcao != 4);
    }

}
