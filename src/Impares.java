import javax.swing.JOptionPane;

public class Impares {

    public static void main(String[] args) {

        int numInicial = Integer.parseInt(JOptionPane.showInputDialog(null, "Coloque o número inicial"));

        int numFinal = Integer.parseInt(JOptionPane.showInputDialog(null, "Coloque o número final"));

        for (int i = numInicial; i < numFinal; i++) {
            if (i % 2 == 1) {
                System.out.println(i);
            } else {
                System.out.println("Numeros não validos");
            }

        }
    }

}
