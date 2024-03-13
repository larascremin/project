package class_three;

import javax.swing.JOptionPane;

public class Exemplo1 {

    public static void main(String[] args) {

        String[] nomes = new String[10];
        int[] idades = new int[10];

        for (int i = 0; i < 10; i++) {
            nomes[i] = JOptionPane.showInputDialog("insira o nome: " + (i + 1));
            idades[i] = Integer.parseInt(JOptionPane.showInputDialog("insira a idade de: " + nomes[i]));
        }

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                System.out.println(nomes[i]);
            }
        }

        String nomeVelho = nomes[0];
        int idadeVelho = idades[0];

        for (int i = 0; i < 10; i++) {
            if (idades[i] > idadeVelho) {
                nomeVelho = nomes[i];
                idadeVelho = idades[i];
            }

        }
        JOptionPane.showMessageDialog(null, "pessoa mais velha: " + nomeVelho);
    }
}
