package class_four;

import javax.swing.JOptionPane;

public class atividade {

    public static void main(String[] args) {

        String cores[] = new String[5];

        for (int i = 0; i < 5; i++) {
            cores[i] = JOptionPane.showInputDialog(null, "informe a cor");
        }

        for (int i = 4; i >= 0; i--) {
            System.out.println(cores[i]);
        }

    }

}
