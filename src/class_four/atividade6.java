package class_four;

import javax.swing.JOptionPane;

public class atividade6 {
    public static void main(String[] args) {

        int cadastros = 0;
        int opcao = 0;

        String[] nomes = new String[100];
        int[] telefones = new int[100];

        String buscaNome = "";
        int buscaTelefone = 0;

        do {

            opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "1 - cadastrar contato \n" +
                            "2 - buscar contato por nome \n" +
                            "3 - buscar contato por numero \n" +
                            "4 - sair"));

            if (opcao == 1) {
                nomes[cadastros] = JOptionPane.showInputDialog(null, "digite o nome do contato: " + (cadastros + 1));
                telefones[cadastros] = Integer
                        .parseInt(JOptionPane.showInputDialog(null, "digite o numero para " + nomes[cadastros]));
                cadastros++;
            }

            if (opcao == 2) {
                buscaNome = JOptionPane.showInputDialog(null, "pesquisar nome: ");
                for (int i = 0; i < cadastros; i++) {
                    if (buscaNome.equals(nomes[i])) {
                        JOptionPane.showMessageDialog(null, nomes[i] + ": " + telefones[i]);
                    } else {
                        JOptionPane.showMessageDialog(null, "nome não encontrado");
                    }
                }
            }

            if (opcao == 3) {
                String res = "telefone não encontrado";
                buscaTelefone = Integer.parseInt(JOptionPane.showInputDialog(null, "pesquisar telefone: "));
                for (int i = 0; i < cadastros; i++) {
                    if (buscaTelefone == telefones[i]) {
                        res = nomes[i] + ": " + telefones[i];
                    } else {
                        JOptionPane.showMessageDialog(null, "telefone não encontrado");
                    }
                }
                JOptionPane.showMessageDialog(null, res);
            }

        } while (opcao != 4);
    }

}
