package array;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ExercicioJogador {
    public static void main(String[] args) {

        ArrayList<Jogador> listaJogadores = new ArrayList<Jogador>();

        int opt = 0;

        do {
            opt = menu();

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

}
