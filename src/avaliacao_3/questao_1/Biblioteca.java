package avaliacao_3.questao_1;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Biblioteca {
    public static void main(String[] args) {
        ArrayList<Livro> biblioteca = new ArrayList<>();
        int opcao = 0;
        do {
            opcao = menu();
            if (opcao == 1) {
                biblioteca.add(cadastrarLivro());
            }
            if (opcao == 2) {
                buscarISBN(biblioteca);
            }
            if (opcao == 3) {
                buscarLivrosDoUsuario(biblioteca);
            }
            if (opcao == 4) {
                mostrarDadosDeTodosOsLivrosPublicadosEm2020(biblioteca);
            }
            if (opcao == 5) {
                buscarLivrosPorGenero(biblioteca);
            }
        } while (opcao != 6);
    }

    public static Livro cadastrarLivro() {
        Livro novoLivro = new Livro();
        novoLivro.titulo = lerString("Título do livro:");
        novoLivro.autor = lerString("Autor do livro:");
        novoLivro.anoPublicacao = lerInt("Ano de publicação:");
        novoLivro.genero = lerString("Gênero do livro:");
        novoLivro.isbn = lerISBN("ISBN do livro:");
        novoLivro.pessoasQuePegaramEmprestado = lerPessoasQuePegaramEmprestado();
        imprimir("Livro cadastrado com sucesso!");
        return novoLivro;
    }

    public static int menu() {
        String opcao = "1 - Cadastrar livro \n" +
                "2 - Localizar livro pelo ISBN e mostrar quem pegou emprestado \n" +
                "3 - Buscar livros emprestados para um usuário \n" +
                "4 - Dados de todos os livros publicados em 2020 \n" +
                "5 - Todos os livros de um genero \n" +
                "6 - Sair";
        return lerInt(opcao);
    }

    private static void imprimir(String txt) {
        JOptionPane.showMessageDialog(null, txt);
    }

    private static String lerString(String txt) {
        String str = JOptionPane.showInputDialog(txt);
        if (str.trim().equals("")) {
            imprimir("Texto não pode ser vazio!");
            return lerString(txt);
        }
        return str.toUpperCase();
    }

    private static int lerInt(String txt) {
        int numero = Integer.parseInt(JOptionPane.showInputDialog(txt));
        if (numero < 0) {
            imprimir("Digite um número válido!");
            return lerInt(txt);
        }
        return numero;
    }

    private static String lerISBN(String isbn) {
        String str = lerString(isbn);
        if (str.length() != 13) {
            imprimir("ISBN incorreto! Digite novamente!");
            return lerISBN(isbn);
        }
        return str;
    }

    private static String[] lerPessoasQuePegaramEmprestado() {
        int quantidadeDeCadastros = lerInt("Digite a quantidade de pessoas que pegaram o livro emprestado");
        String[] pessoasQuePegaramEmprestado = new String[quantidadeDeCadastros];
        if (quantidadeDeCadastros < 1) {
            return lerPessoasQuePegaramEmprestado();
        }
        for (int i = 0; i < quantidadeDeCadastros; i++) {
            pessoasQuePegaramEmprestado[i] = lerString("Nome da pessoa #" + (i + 1));
        }
        return pessoasQuePegaramEmprestado;
    }

    private static void buscarISBN(ArrayList<Livro> biblioteca) {
        String pesquisa = lerISBN("Digite o ISBN:");
        String resultado = "PESSOAS QUE PEGARAM EMPRESTADO:\n";
        for (Livro livro : biblioteca) {
            if (livro.isbn.equals(pesquisa)) {
                for (int i = 0; i < livro.pessoasQuePegaramEmprestado.length; i++) {
                    resultado += livro.pessoasQuePegaramEmprestado[i] + "\n";
                }
            }
        }
        if (resultado.equals("")) {
            resultado = "Livro não encontrado.";
        }
        imprimir(resultado);
    }

    private static void buscarLivrosDoUsuario(ArrayList<Livro> biblioteca) {
        String pesquisa = lerString("Buscar por usuário: ");
        String resultado = "Livros emprestados para " + pesquisa + ":\n\n";
        for (Livro livro : biblioteca) {
            for (int i = 0; i < livro.pessoasQuePegaramEmprestado.length; i++) {
                if (livro.pessoasQuePegaramEmprestado[i].equals(pesquisa)) {
                    resultado += livro.titulo + "\n";
                }
            }
        }
        imprimir(resultado);
    }

    private static void mostrarDadosDeTodosOsLivrosPublicadosEm2020(ArrayList<Livro> biblioteca) {
        String resultado = "Livros publicados em 2020:\n\n";
        for (Livro livro : biblioteca) {
            if (livro.anoPublicacao == 2020)
                resultado += mostrarDadosDoLivro(livro) + "\n";
        }
        imprimir(resultado);
    }

    private static void buscarLivrosPorGenero(ArrayList<Livro> biblioteca) {
        String pesquisa = lerString("Buscar gênero: ");
        String resultado = "Livros do gênero " + pesquisa + ":\n\n";
        for (Livro livro : biblioteca) {
            if (livro.genero.equals(pesquisa)) {
                resultado += livro.titulo + "\n";
            }
        }
        imprimir(resultado);
    }

    private static String mostrarDadosDoLivro(Livro livro) {
        String dados = "[\nTítulo: " + livro.titulo + "\n" +
                "Autor: " + livro.autor + "\n" +
                "Ano de Publicação: " + livro.anoPublicacao + "\n" +
                "Gênero: " + livro.genero + "\n" +
                "ISBN: " + livro.isbn + "\n" +
                "Pessoas que pegaram emprestado: \n";
        if (livro.pessoasQuePegaramEmprestado.length > 0) {
            for (int i = 0; i < livro.pessoasQuePegaramEmprestado.length; i++) {
                dados += "- " + livro.pessoasQuePegaramEmprestado[i] + "\n";
            }
        } else {
            dados += "Nenhuma pessoa pegou este livro emprestado.\n";
        }
        dados += "]";
        return dados;
    }
}
