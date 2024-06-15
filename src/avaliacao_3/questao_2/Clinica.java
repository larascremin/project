package avaliacao_3.questao_2;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Clinica {
    public static int menu() {
        String opcao = "1 - Cadastrar paciente \n" +
                "2 - Localizar paciente pelo número do SUS \n" +
                "3 - Buscar diagnósticos do paciente \n" +
                "4 - Dados de todos os pacientes nascidos no ano 2000 \n" +
                "5 - Listar todos os pacientes de um gênero \n" +
                "6 - Sair";
        return lerInt(opcao);
    }

    public static void main(String[] args) {
        ArrayList<Paciente> pacientes = new ArrayList<>();
        int opcao = 0;
        do {
            opcao = menu();
            if (opcao == 1) {
                pacientes.add(cadastrarPaciente());
            }
            if (opcao == 2) {
                mostrarDiagnosticosDoPacientePeloCartaoDoSUS(pacientes);
            }
            if (opcao == 3) {
                mostrarDiagnosticosDoPacientePeloNome(pacientes);
            }
            if (opcao == 4) {
                mostrarDadosDeTodosOsPacientesNascidosNoAnoDe2000(pacientes);
            }
            if (opcao == 5) {
                buscarPacientesPorGenero(pacientes);
            }
        } while (opcao != 6);
    }

    public static Paciente cadastrarPaciente() {
        Paciente novoPaciente = new Paciente();
        novoPaciente.nome = lerString("Nome do Paciente:");
        novoPaciente.dataNascimento = lerInt("Data de nascimento:");
        novoPaciente.genero = lerString("Gênero do Paciente:");
        novoPaciente.cartaoSUS = lerCartaoSUS("Cartão do SUS do paciente:");
        novoPaciente.diagnosticos = lerDiagnosticos();
        imprimir("Paciente cadastrado com sucesso!");
        return novoPaciente;
    }

    private static String[] lerDiagnosticos() {
        int quantidadeDeCadastros = lerInt("Digite a quantidade de diagnósticos a serem cadastrados: ");
        String[] diagnosticos = new String[quantidadeDeCadastros];
        if (quantidadeDeCadastros < 1) {
            return lerDiagnosticos();
        }
        for (int i = 0; i < quantidadeDeCadastros; i++) {
            diagnosticos[i] = lerString("Diagnóstico #" + (i + 1));
        }
        return diagnosticos;
    }

    private static String lerCartaoSUS(String numeroDoCartao) {
        String str = lerString(numeroDoCartao);
        if (str.length() != 15) {
            imprimir("Número do cartão do SUS incorreto! Digite novamente!");
            return lerCartaoSUS(numeroDoCartao);
        }
        return str;
    }

    private static void mostrarDiagnosticosDoPacientePeloCartaoDoSUS(ArrayList<Paciente> clinica) {
        String pesquisa = lerCartaoSUS("Buscar paciente por cartão do SUS: ");
        String resultado = "Diagnósticos do paciente\n\n";
        for (Paciente paciente : clinica) {
            if (paciente.cartaoSUS.equals(pesquisa)) {
                for (int i = 0; i < paciente.diagnosticos.length; i++) {
                    resultado += paciente.diagnosticos[i] + "\n";
                }
            }
        }
        imprimir(resultado);
    }

    private static void mostrarDiagnosticosDoPacientePeloNome(ArrayList<Paciente> clinica) {
        String pesquisa = lerString("Buscar paciente pelo nome: ");
        String resultado = "Diagnósticos do paciente\n\n";
        for (Paciente paciente : clinica) {
            if (paciente.nome.equals(pesquisa)) {
                for (int i = 0; i < paciente.diagnosticos.length; i++) {
                    resultado += paciente.diagnosticos[i] + "\n";
                }
            }
        }
        imprimir(resultado);
    }

    private static void mostrarDadosDeTodosOsPacientesNascidosNoAnoDe2000(ArrayList<Paciente> clinica) {
        String resultado = "Pacientes nascidos em 2000:\n\n";
        for (Paciente paciente : clinica) {
            if (paciente.dataNascimento == 2000) {
                resultado += mostrarDadosDoPaciente(paciente) + "\n";
            }
        }
        imprimir(resultado);
    }

    private static void buscarPacientesPorGenero(ArrayList<Paciente> clinica) {
        String pesquisa = lerString("Buscar gênero: ");
        String resultado = "Pacientes do gênero " + pesquisa + ":\n\n";
        for (Paciente paciente : clinica) {
            if (paciente.genero.equals(pesquisa)) {
                resultado += paciente.nome + "\n";
            }
        }
        imprimir(resultado);
    }

    private static String mostrarDadosDoPaciente(Paciente paciente) {
        String dados = "[\nNome: " + paciente.nome + "\n" +
                "Data de Nascimento: " + paciente.dataNascimento + "\n" +
                "Gênero: " + paciente.genero + "\n" +
                "Cartão SUS: " + paciente.cartaoSUS + "\n" +
                "Diagnósticos: \n";

        if (paciente.diagnosticos.length > 0) {
            for (int i = 0; i < paciente.diagnosticos.length; i++) {
                dados += "- " + paciente.diagnosticos[i] + "\n";
            }
        } else {
            dados += "Nenhum diagnóstico registrado.\n";
        }

        dados += "]";
        return dados;
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
}
