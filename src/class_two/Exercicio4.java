package class_two;

public class Exercicio4 {

    public static void main(String[] args) {

        double chico = 1.50;
        double ze = 1.10;
        double anos = 0;

        while (ze < chico) {
            chico = chico + 0.2;
            ze = ze + 0.3;
            anos++;

            System.out.println(anos);
        }

    }

}
