package class_two;

import javax.swing.JOptionPane;

public class Exercicio5 {

    public static void main(String[] args) {

        int quantidade = Integer.parseInt(JOptionPane.showInputDialog(null, "quantos carros deseja cadastrar?"));
        int azul = 0;
        int preto = 0;
        int producao = 0;

        String carro = "";
        String ano = "";
        String cor = "";

        for (int i = 0; i < quantidade; i++) {

            String nomeCarro = JOptionPane.showInputDialog(null, "digite o nome do carro: ");
            int anoCarro = Integer.parseInt(JOptionPane.showInputDialog(null, "digite o ano do carro: "));
            String corCarro = JOptionPane.showInputDialog(null, "digite a cor do carro: ");

            carro += nomeCarro + "; ";
            ano += anoCarro + "; ";
            cor += corCarro + "; ";

            if ("azul".equals(corCarro)) {
                azul++;
            }
            if ((anoCarro == 2021) && ("preto".equals(corCarro))) {
                preto++;
            }
            if ((anoCarro >= 2010) && (anoCarro <= 2020)) {
                producao++;
            }
        }

        JOptionPane.showMessageDialog(null, "Nome dos carros: " + carro);
        JOptionPane.showMessageDialog(null, "Ano dos carros: " + ano);
        JOptionPane.showMessageDialog(null, "Cor dos carros: " + cor);

        JOptionPane.showMessageDialog(null, "Carros azuis: " + azul);
        JOptionPane.showMessageDialog(null, "Carros pretos de 2021: " + preto);
        JOptionPane.showMessageDialog(null, "Carros entre 2010 e 2020: " + producao);

    }

}
