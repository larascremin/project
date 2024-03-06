package class_one;

import javax.swing.JOptionPane;

public class Idade {
    public static void main(String[] args) throws Exception {

        int idade = Integer.parseInt(JOptionPane.showInputDialog(null, "teste"));

        if (idade >= 60) {
            JOptionPane.showMessageDialog(null, "Você é idoso");
        } else if (idade >= 18) {
            JOptionPane.showMessageDialog(null, "Você é adulto");
        } else if (idade > 12) {
            JOptionPane.showMessageDialog(null, "Você é jovem");
        } else {
            JOptionPane.showMessageDialog(null, "Você é uma criança");
        }
    }
}