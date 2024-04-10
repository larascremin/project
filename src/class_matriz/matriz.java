package class_matriz;

import java.util.Random;

public class matriz {
    public static void main(String[] args) {
        Random r = new Random();

        int[][] gastos = new int[12][4];

        for (int i = 0; i < gastos.length; i++) {
            for (int j = 0; j < gastos[0].length; j++) {
                gastos[i][j] = r.nextInt(2000);
            }
        }

        for (int i = 0; i < gastos.length; i++) {
            System.out.println("");
            for (int j = 0; j < gastos[0].length; j++) {
                System.out.print(gastos[i][j] + "\t");
            }
        }

        for (int i = 0; i < gastos.length; i++) {
            double totalMes = 0;
            for (int j = 0; j < gastos[0].length; j++) {
                totalMes += gastos[i][j];
            }
            System.out.println("Mes " + (i + 1) + ":" + totalMes);
        }
    }

}
