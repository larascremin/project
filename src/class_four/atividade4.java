package class_four;

import javax.swing.JOptionPane;

public class atividade4 {

    public static void main(String[] args) {

        double[] numeros = new double[20];
        double soma = 0;
        double media = 0;

        for (int i = 0; i < 20; i++) {
            numeros[i] = Double
                    .parseDouble(JOptionPane.showInputDialog(null, "digite o numero: " + (i + 1) + "/20"));
            soma += numeros[i];
        }

        media = soma / 20;

        for (int i = 0; i < 20; i++) {
            if (numeros[i] < media) {
                numeros[i] = media;
                JOptionPane.showMessageDialog(null, "numero " + (i + 1) + " foi trocado pela media = " + media);
            }
        }
    }

}
