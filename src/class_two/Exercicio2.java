package class_two;

import javax.swing.JOptionPane;

public class Exercicio2 {
    public static void main(String[] args) {

        double salario = Double.parseDouble(JOptionPane.showInputDialog(null, "Insira seu salario:"));
        double vendas = Double.parseDouble(JOptionPane.showInputDialog(null, "Insira suas vendas:"));

        if (vendas > 50000) {
            double salariofinal = salario + (salario * (3.0 / 100));
            JOptionPane.showMessageDialog(null, "Seu salário é: " + salariofinal);
        } else {
            double salariofinal = salario + (salario * (1.5 / 100));
            JOptionPane.showMessageDialog(null, "Seu salário é: " + salariofinal);
        }
    }

}
