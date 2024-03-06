package class_two;

import javax.swing.JOptionPane;

public class ExercicioUm {
    public static void main(String[] args) {

        double deposito = Double.parseDouble(JOptionPane.showInputDialog(null, "Valor de Deposito:"));
        double contas = Double.parseDouble(JOptionPane.showInputDialog(null, "Valor das Contas:"));

        double saldo = (deposito * (7 / 100)) + deposito - contas;

        if (saldo > 0) {
            JOptionPane.showMessageDialog(null, "Saldo suficiente para as contas do mês");
        } else {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente, adquirir emprestimo");
        }

    }

}
