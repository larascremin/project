package prova;

import javax.swing.JOptionPane;

public class numero1 {

    public static void main(String[] args) {

        int mes = 0;
        String[] nomeMes = new String[12];
        double[] acidentes = new double[12];
        double total = 0;
        double fevereiro = 0;

        int maisAcidentes = 0;
        String mesMaisAcidentes = "";

        for (int i = 0; i < 12; i++) {
            nomeMes[i] = JOptionPane.showInputDialog(null, "nome do mes: ");
            acidentes[i] = Double
                    .parseDouble(JOptionPane.showInputDialog(null, "quantidade de acidentes no mes de: " + nomeMes[i]));
            mes++;
            total += acidentes[i];

        }

        for (int i = 0; i < 12; i++) {
            if (acidentes[i] > maisAcidentes) {
                mesMaisAcidentes = nomeMes[i];
            }

        }
        JOptionPane.showMessageDialog(null, "mes com maior acidentes:" + mesMaisAcidentes);

        double menosAcidentes = acidentes[0];
        String mesMenosAcidentes = nomeMes[0];

        for (int i = 0; i < 12; i++) {
            if (acidentes[i] < menosAcidentes) {
                menosAcidentes = acidentes[i];
                mesMenosAcidentes = nomeMes[i];
            }
        }
        JOptionPane.showMessageDialog(null, "mes com menos acidentes:" + mesMenosAcidentes);

        JOptionPane.showMessageDialog(null, "total de acidentes:" + total);

        fevereiro = (acidentes[1] / total) * 100;

        JOptionPane.showMessageDialog(null, "percentual de acidentes em fevereito: " + fevereiro + "%");

    }
}