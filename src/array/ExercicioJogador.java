package array;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ExercicioJogador {
    public static void main(String[] args) {

        ArrayList<Jogador> jogadores = new ArrayList<Jogador>();

        int opt = 0;

        do {
            opt = menu();

            if (opt == 1)
                jogadores.add(cadastrarJogador());
            if (opt == 2)
                buscaMaiorGols(jogadores);
            if (opt == 3)
                buscaMenorGols(jogadores);

        } while (opt != 5);
    }

    public static int menu() {
        String op = "1 - cadastrar jogador \n" +
                "2 - dados do jogador com maior número de gols \n" +
                "3 - dados do jogador com menor número de gols \n" +
                "4 - dados de todos os goleiros que fizeram algum gol no campeonato \n" +
                "5 - jogadores que utilizaram a camisa número 10 \n" +
                "6 - sair";

        return Integer.parseInt(JOptionPane.showInputDialog(null, op));
    }

    public static Jogador cadastrarJogador() {
        Jogador j = new Jogador();

        j.nome = cadNome();
        j.numeroCamisa = cadCamisa();
        j.posicao = cadPosicao();
        j.time = cadTime();
        j.golsMarcados = cadGols();

        return j;
    }

    public static void buscaMaiorGols(ArrayList<Jogador> jogadores) {
        int jogadorMaisGols = 0;

        for (Jogador j : jogadores) {
            if (j.golsMarcados > jogadorMaisGols) {
                jogadorMaisGols = j.golsMarcados;
            }
            JOptionPane.showMessageDialog(null, "nome: " + j.nome + "\n" + "gols: " + j.golsMarcados + "\n" + "time: "
                    + j.time + "\n" + "posicao: " + j.posicao + "\n");
        }

    }

    public static void buscaMenorGols(ArrayList<Jogador> jogadores) {
        int jogadorMenosGols = 0;

        for (Jogador j : jogadores) {

            if (j.golsMarcados < jogadorMenosGols) {
                jogadorMenosGols = j.golsMarcados;
            }
            JOptionPane.showMessageDialog(null, "nome: " + j.nome + "\n" + "gols: " + j.golsMarcados + "\n" + "time: "
                    + j.time + "\n" + "posicao: " + j.posicao + "\n");
        }

    }

    public static void jogadorComGols(ArrayList<Jogador> jogadores) {
        int jogadorMaisGols = 0;

        for (Jogador j : jogadores) {
            if (j.golsMarcados > jogadorMaisGols) {
                jogadorMaisGols = j.golsMarcados;
            }
            JOptionPane.showMessageDialog(null, "nome: " + j.nome + "\n" + "gols: " + j.golsMarcados + "\n" + "time: "
                    + j.time + "\n" + "posicao: " + j.posicao + "\n");
        }

    }

    public static String cadNome() {
        String nome = JOptionPane.showInputDialog(null, "Digite o nome do produto: ");
        if (nome.trim().length() < 3) {
            return cadNome();
        }
        return nome;
    }

    public static int cadCamisa() {
        int qtd = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade: "));
        if (qtd < 0)
            return cadCamisa();

        return qtd;
    }

    public static String cadPosicao() {
        String nome = JOptionPane.showInputDialog(null, "Digite o nome do jogador: ");
        if (nome.trim().length() < 3) {
            return cadPosicao();
        }
        return nome;
    }

    public static String cadTime() {
        String qtd = JOptionPane.showInputDialog(null, "Digite a quantidade: ");
        return qtd;
    }

    public static int cadGols() {
        int qtd = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade de gols: "));
        if (qtd < 0)
            return cadGols();

        return qtd;
    }

}
