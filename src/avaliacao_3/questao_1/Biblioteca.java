package avaliacao_3.questao_1;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class Biblioteca {

    public static void main(String[] args) {

        ArrayList<Livro> livrosBiblioteca = new ArrayList<Livro>();

        int opcao = 0;

        do {
            opcao = menu();

            if (opcao == 1)
                lerLivro();
            if (opcao == 2)
                buscarISBN(livrosBiblioteca);

        } while (opcao != 5);

    }

    public static int menu() {
        String opcao = "1 - cadastrar livro \n" +
                "2 - localizar livro pelo ISBN e mostrar quem pegou emprestado \n" +
                "3 - buscar nome e quais livros leu \n" +
                "4 - dados de todos os livros publicados em 2020 \n" +
                "5 - todos os livros de um genero \n" +
                "6 - sair";

        return Integer.parseInt(JOptionPane.showInputDialog(null, opcao));
    }

    // cadastrar o livro

    private static Livro lerLivro() {
        Livro unidade = new Livro();
        unidade.titulo = lerString("titulo do livro: ");
        unidade.autor = lerString("nome do autor: ");
        unidade.ano = lerInt("ano de publicação: ");
        unidade.genero = lerString("genero do livro: ");
        unidade.isbn = lerISBN("numero isbn: ");

        return unidade;
    }

    private static void imprimir(String txt) {
        JOptionPane.showMessageDialog((Component) null, txt);
    }

    private static String lerString(String txt) {
        String str = JOptionPane.showInputDialog(txt);
        return str.trim().equals("") ? lerString(txt) : str.toUpperCase();
    }

    private static int lerInt(String txt) {
        int i = Integer.parseInt(JOptionPane.showInputDialog(txt));
        return i < 0 ? lerInt(txt) : i;
    }

    private static String lerISBN(String txt) {
        String str = JOptionPane.showInputDialog(txt);
        return str.length() != 13 ? lerISBN(txt) : str;
    }

    // localizar livro pelo codigo e mostra leitores

    private static void buscarISBN(ArrayList<Livro> livrosBiblioteca) {

        String pesquisa = JOptionPane.showInputDialog("pesquisar por isbm: ");

        String resultado = "";
        Iterator<Livro> livros = livrosBiblioteca.iterator();

        while (livros.hasNext()) {
            Livro unidade = (Livro) livros.next();
            if (unidade.isbn.equals(pesquisa)) {
                resultado = resultado + unidade.leitor + "\n\n";
            } else {
                imprimir("isbn não encontrado");
            }
        }

        imprimir(resultado);

    }

}