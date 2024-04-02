package prova;

import javax.swing.JOptionPane;

public class numero3 {

    public static void main(String[] args) {

        int quantidade = Integer.parseInt(JOptionPane.showInputDialog(null, "quantidade de inteiros a cadastrar:"));

        double[] vetorA = new double[quantidade];
        double[] vetorB = new double[quantidade];

        double[] somas = new double[quantidade];
        double[] subtracoes = new double[quantidade];
        double[] multiplicacao = new double[quantidade];
        double[] divisao = new double[quantidade];

        for (int i = 0; i < quantidade; i++) {
            vetorA[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "vetor A numero: " + (i + 1)));

        }

        for (int i = 0; i < quantidade; i++) {
            vetorB[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "vetor B numero: " + (i + 1)));

        }

        for (int i = 0; i < quantidade; i++) {

            somas[i] = vetorA[i] + vetorB[i];
            subtracoes[i] = vetorA[i] - vetorB[i];
            multiplicacao[i] = vetorA[i] * vetorB[i];
            divisao[i] = vetorA[i] / vetorB[i];
        }

        for (int i = 0; i < quantidade; i++) {
            JOptionPane.showMessageDialog(null, "Posição " + (i + 1) + "\n soma: " + somas[i] + "\n subtração: "
                    + subtracoes[i] + "\n multiplicação: " + multiplicacao[i] + "\n divisao: " + divisao[i]);
        }

    }

}
