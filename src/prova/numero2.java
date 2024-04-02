package prova;

import javax.swing.JOptionPane;

public class numero2 {

    public static void main(String[] args) {

        int quantidade = Integer.parseInt(JOptionPane.showInputDialog(null, "quantidade de pessoas para cadastrar: "));

        int[] idades = new int[quantidade];
        String[] nomes = new String[quantidade];
        String pesquisa = "";

        for (int i = 0; i < quantidade; i++) {
            nomes[i] = JOptionPane.showInputDialog(null, "insira o nome da pessoa:" + (i + 1));
            idades[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "idade de: " + nomes[i]));
        }

        pesquisa = JOptionPane.showInputDialog(null, "pesquise pelo nome:");

        for (int i = 0; i < quantidade; i++) {
            if (pesquisa.equals(nomes[i])) {
                if (idades[i] >= 5 && idades[i] <= 7) {
                    JOptionPane.showMessageDialog(null, nomes[i] + " é da categoria: Intantil A");
                } else if (idades[i] >= 8 && idades[i] <= 10) {
                    JOptionPane.showMessageDialog(null, nomes[i] + " é da categoria: Intantil B");
                } else if (idades[i] >= 11 && idades[i] <= 17) {
                    JOptionPane.showMessageDialog(null, nomes[i] + " é da categoria: Juvenil");
                } else if (idades[i] >= 18) {
                    JOptionPane.showMessageDialog(null, nomes[i] + " é da categoria: Adulto");
                } else {
                    JOptionPane.showMessageDialog(null, nomes[i] + " não pode participar");

                }
            }
        }

    }

}
