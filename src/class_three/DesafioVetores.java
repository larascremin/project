package class_three;

import javax.swing.JOptionPane;

public class DesafioVetores {
    public static void main(String[] args) {

        int quantidade = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantidade de pessoas a cadastrar:"));

        String[] nomes = new String[quantidade];
        int[] alturas = new int[quantidade];
        String[] sexos = new String[quantidade];
        double media = 0;
        int somaAltura = 0;
        int mulher = 0;

        for (int i = 0; i < quantidade; i++) {
            nomes[i] = JOptionPane.showInputDialog(null, "Insira o nome: " + (i + 1));
            alturas[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira a altura de " + nomes[i]));
            sexos[i] = JOptionPane.showInputDialog(null,
                    "Insira o sexo de " + nomes[i] + " utilizando m para masculino e f para feminino");
            somaAltura += alturas[i];
        }

        String maisAlto = nomes[0];
        int maiorAltura = alturas[0];

        for (int i = 0; i < quantidade; i++) {
            if (alturas[i] > maiorAltura) {
                maisAlto = nomes[i];
                maiorAltura = alturas[i];
            }

        }
        JOptionPane.showMessageDialog(null, "pessoa mais alta: " + maisAlto);

    }

}
