package class_one;

import javax.swing.JOptionPane;

public class Clima {

    public static void main(String[] args) {

        String clima = JOptionPane.showInputDialog(null, "Está chovendo?");

        String filme = JOptionPane.showInputDialog(null, "Está passando um bom filme?");

        if (((clima.equals("s")) || (clima.equals("n"))) && ((filme.equals("s")) || (filme.equals("n")))) {
            if ((clima.equals("s")) && (filme.equals("s"))) {
                JOptionPane.showMessageDialog(null, "Assitir Filme");
            } else if (clima.equals("n")) {
                JOptionPane.showMessageDialog(null, "Jogar bola");
            } else if ((clima.equals("s")) && (filme.equals("n"))) {
                JOptionPane.showMessageDialog(null, "Correr");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Valor invalido");
        }

    }

}
