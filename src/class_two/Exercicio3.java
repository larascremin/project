package class_two;

import javax.swing.JOptionPane;

public class Exercicio3 {
    public static void main(String[] args) {

        int vezes = Integer.parseInt(JOptionPane.showInputDialog("quantos numeros serao digitados?"));
        int somaPar = 0;
        int somaImpar = 0;
        int qntdImpar = 0;

        double media = 0;

        String numeroPar = "";
        String numeroImpar = "";

        for (int i = 0; i < vezes; i++) {
            int numero = Integer.parseInt(JOptionPane.showInputDialog("digite o numero:"));
            if (numero % 2 == 0) {
                numeroPar += numero + "; ";
                somaPar += numero;
            } else {
                numeroImpar += numero + "; ";
                somaImpar += numero;
                qntdImpar++;
            }
        }

        if (media > 0) {
            media = somaImpar / qntdImpar;
        }

        JOptionPane.showMessageDialog(null, "Numeros pares: " + numeroPar);
        JOptionPane.showMessageDialog(null, "Soma: " + somaPar);
        JOptionPane.showMessageDialog(null, "Numeros impares: " + numeroImpar);
        JOptionPane.showMessageDialog(null, "Media: " + media);
    }
}
