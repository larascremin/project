package class_four;

import javax.swing.JOptionPane;

public class atividade3 {
    public static void main(String[] args) {

        int funcionarios = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de funcionarios:"));

        String[] nome = new String[funcionarios];
        double[] salario = new double[funcionarios];

        for (int i = 0; i < funcionarios; i++) {
            nome[i] = JOptionPane.showInputDialog(null, "nome do funcionario " + (i + 1));
            salario[i] = Double.parseDouble(JOptionPane.showInputDialog(null, "salario do funcionario " + (i + 1)));

            if (salario[i] < 400) {
                salario[i] += (salario[i] * (25.0 / 100.0));
                JOptionPane.showMessageDialog(null, "salario de " + nome[i] + " = " + salario[i]);
            } else if (salario[i] < 600) {
                salario[i] += (salario[i] * (20.0 / 100.0));
                JOptionPane.showMessageDialog(null, "salario de " + nome[i] + " = " + salario[i]);
            } else if (salario[i] < 800) {
                salario[i] += (salario[i] * (15.0 / 100.0));
                JOptionPane.showMessageDialog(null, "salario de " + nome[i] + " = " + salario[i]);
            } else {
                salario[i] += (salario[i] * (10.0 / 100.0));
                JOptionPane.showMessageDialog(null, "salario de " + nome[i] + " = " + salario[i]);
            }
        }

    }

}
