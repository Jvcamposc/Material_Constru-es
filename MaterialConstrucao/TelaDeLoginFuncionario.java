package MaterialConstrucao;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class TelaDeLoginFuncionario {
    
    private static JFrame janela;
    private static Map<String, String> funcionarios;

    public static void main(String[] args) {
        // Criando o "banco de dados" simulado de login e senha
        funcionarios = new HashMap<>();
        funcionarios.put("123", "123"); // Exemplo de login pré-cadastrado
        
        // Configuração da janela principal
        janela = new JFrame("Tela de Login - Funcionário");
        janela.setSize(600, 400);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null); // Centraliza a janela na tela
        
        // Criando os painéis
        PainelLogin painelLogin = new PainelLogin(funcionarios, janela);
        PainelCadastro painelCadastro = new PainelCadastro(funcionarios, janela);
        PainelLoja painelLoja = new PainelLoja(janela);
        PainelCadastrarProduto painelCadastrarProduto = new PainelCadastrarProduto(janela);
        PainelCadastrarCliente painelCadastrarCliente = new PainelCadastrarCliente(janela);

        // Exibindo a tela de login inicialmente
        janela.add(painelLogin);
        janela.setVisible(true);
    }
}
