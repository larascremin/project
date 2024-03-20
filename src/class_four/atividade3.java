package class_four;

import javax.swing.JOptionPane;

public class atividade3 {
    public static void main(String[] args) {

        int funcionarios = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de funcionarios:"));

        String[] nome = new String[funcionarios];
        int[] salario = new int[funcionarios];

        for (int i = 0; i < funcionarios; i++) {
            nome[i] = JOptionPane.showInputDialog(null, "nome do funcionario " + (i + 1));
            salario[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "salario do funcionario " + (i + 1)));

            if (salario[i] > 400) {
                salario[i] = salario[i] + (salario[i] * (25 / 100));

            }
        }

    }

}
