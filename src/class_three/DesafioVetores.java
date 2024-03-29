package class_three;

import javax.swing.JOptionPane;

public class DesafioVetores {
    public static void main(String[] args) {

        int quantidade = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantidade de pessoas a cadastrar:"));

        String[] nomes = new String[quantidade];
        int[] alturas = new int[quantidade];
        String[] sexos = new String[quantidade];

        double media = 0;
        double mediaGeral = 0;

        int mulherAlturas = 0;
        int mulher = 0;
        int pessoasAlturas = 0;
        int pessoas = 0;

        String mulheresAltas = "";
        String pessoasBaixas = "";

        for (int i = 0; i < quantidade; i++) { // recebe valores
            nomes[i] = JOptionPane.showInputDialog(null, "Insira o nome: " + (i + 1));
            alturas[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira a altura de " + nomes[i]));
            sexos[i] = JOptionPane.showInputDialog(null,
                    "Insira o sexo de " + nomes[i] + " (F = feminino / M = masculino)");
        }

        String maisAlto = nomes[0];
        int maiorAltura = alturas[0];

        for (int i = 0; i < quantidade; i++) { // pessoa mais alta
            if (alturas[i] > maiorAltura) {
                maisAlto = nomes[i];
                maiorAltura = alturas[i];
            }
        }

        for (int i = 0; i < quantidade; i++) { // somar altura das mulheres
            if (sexos[i].equalsIgnoreCase("f")) {
                mulherAlturas += alturas[i];
                mulher++;
            }
        }

        media = mulherAlturas / mulher;

        for (int i = 0; i < quantidade; i++) { // mulheres acima da media
            if (sexos[i].equalsIgnoreCase("f")) {
                if (alturas[i] >= media) {
                    mulheresAltas += nomes[i] + "; ";
                }
            }
        }

        for (int i = 0; i < quantidade; i++) { // somar altura pessoas
            pessoasAlturas += alturas[i];
            pessoas++;
        }

        mediaGeral = pessoasAlturas / pessoas;

        for (int i = 0; i < quantidade; i++) { // pessoas abaixo da media
            if (alturas[i] < mediaGeral) {
                pessoasBaixas += nomes[i] + "; ";
            }
        }

        JOptionPane.showMessageDialog(null, "A pessoa mais alta é: " + maisAlto);
        JOptionPane.showMessageDialog(null, "Mulheres acima da média: " + mulheresAltas);
        JOptionPane.showMessageDialog(null, "Pessoas abaixo da média: " + pessoasBaixas);

    }

}
