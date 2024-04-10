package class_matriz;

import java.text.DecimalFormat;
import java.util.Random;

import javax.swing.JOptionPane;

public class exercicioMatriz {

    public static void main(String[] args) {
        Random r = new Random();
        DecimalFormat df = new DecimalFormat("#.00");

        int alunosQntd = Integer.parseInt(JOptionPane.showInputDialog(null, "quantidade de alunos: "));
        int provasQntd = Integer.parseInt(JOptionPane.showInputDialog(null, "quantidade de provas: "));

        double[][] notas = new double[alunosQntd][provasQntd];

        for (int i = 0; i < alunosQntd; i++) {
            for (int j = 0; j < provasQntd; j++) {
                notas[i][j] = new Random().nextDouble() * 10;
            }
        }

        for (int i = 0; i < alunosQntd; i++) {
            double somaNota = 0;
            double media = 0;
            for (int j = 0; j < provasQntd; j++) {
                somaNota += notas[i][j];
                media = somaNota / provasQntd;
            }

            System.out.println("Soma da nota do aluno " + (i + 1) + ": " + (df.format(somaNota)));
            System.out.println("Media do aluno " + (i + 1) + ": " + (df.format(media)));

        }

    }

}
