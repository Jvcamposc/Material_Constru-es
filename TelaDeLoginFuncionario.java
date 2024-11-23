import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class TelaDeLoginFuncionario {

    private static JFrame janela;
    private static JPanel painelLogin, painelCadastro, painelLoja, painelCadastrarProduto, painelCadastrarCliente;
    private static JTextField campoLogin;
    private static JPasswordField campoSenha;
    private static JButton botaoLogin, botaoCriarConta;
    private static JLabel mensagem;
    
    private static Map<String, String> funcionarios;

    public static void main(String[] args) {
        // Criando o "banco de dados" simulado de login e senha
        funcionarios = new HashMap<>();
        funcionarios.put("funcionario1", "senha123"); // Exemplo de login pré-cadastrado
        
        // Configuração da janela principal
        janela = new JFrame("Tela de Login - Funcionário");
        janela.setSize(600, 400);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Corrigido aqui
        janela.setLocationRelativeTo(null); // Centraliza a janela na tela
        
        // Criando os painéis
        painelLogin = new JPanel(new GridBagLayout());
        painelCadastro = new JPanel(new GridBagLayout());
        painelLoja = new JPanel(new GridBagLayout());
        painelCadastrarProduto = new JPanel(new GridBagLayout());
        painelCadastrarCliente = new JPanel(new GridBagLayout());
        
        // Fontes
        Font fonte = new Font("Arial", Font.BOLD, 14);
        
        // Inicializando componentes do painel de login
        JLabel labelLogin = new JLabel("Login:");
        labelLogin.setFont(fonte);
        
        campoLogin = new JTextField(15);
        campoLogin.setFont(fonte);
        
        JLabel labelSenha = new JLabel("Senha:");
        labelSenha.setFont(fonte);
        
        campoSenha = new JPasswordField(15);
        campoSenha.setFont(fonte);
        
        botaoLogin = new JButton("Entrar");
        botaoLogin.setFont(fonte);
        
        botaoCriarConta = new JButton("Criar Conta");
        botaoCriarConta.setFont(fonte);
        
        mensagem = new JLabel("");
        mensagem.setFont(new Font("Arial", Font.PLAIN, 12));
        mensagem.setForeground(Color.RED);
        
        // Adicionando os componentes ao painel de login
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        gbc.gridx = 0; gbc.gridy = 0; painelLogin.add(labelLogin, gbc);
        gbc.gridx = 1; painelLogin.add(campoLogin, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1; painelLogin.add(labelSenha, gbc);
        gbc.gridx = 1; painelLogin.add(campoSenha, gbc);
        
        gbc.gridx = 1; gbc.gridy = 2; painelLogin.add(botaoLogin, gbc);
        
        gbc.gridx = 1; gbc.gridy = 3; painelLogin.add(mensagem, gbc);
        
        gbc.gridx = 1; gbc.gridy = 4; painelLogin.add(botaoCriarConta, gbc);

        // Inicializando componentes do painel de cadastro de funcionário
        JLabel labelNovoLogin = new JLabel("Novo Login:");
        labelNovoLogin.setFont(fonte);
        
        JTextField campoNovoLogin = new JTextField(15);
        campoNovoLogin.setFont(fonte);
        
        JLabel labelNovaSenha = new JLabel("Nova Senha:");
        labelNovaSenha.setFont(fonte);
        
        JPasswordField campoNovaSenha = new JPasswordField(15);
        campoNovaSenha.setFont(fonte);
        
        JButton botaoCriarContaConfirmar = new JButton("Criar Conta");
        botaoCriarContaConfirmar.setFont(fonte);
        
        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.setFont(fonte);
        
        // Adicionando os componentes ao painel de cadastro de funcionário
        gbc.gridx = 0; gbc.gridy = 0; painelCadastro.add(labelNovoLogin, gbc);
        gbc.gridx = 1; painelCadastro.add(campoNovoLogin, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1; painelCadastro.add(labelNovaSenha, gbc);
        gbc.gridx = 1; painelCadastro.add(campoNovaSenha, gbc);
        
        gbc.gridx = 1; gbc.gridy = 2; painelCadastro.add(botaoCriarContaConfirmar, gbc);
        gbc.gridx = 1; gbc.gridy = 3; painelCadastro.add(botaoVoltar, gbc);

        // Inicializando componentes do painel de loja (após login)
        JButton botaoCadastrarProduto = new JButton("Cadastrar Produto");
        botaoCadastrarProduto.setFont(fonte);
        
        JButton botaoCadastrarCliente = new JButton("Cadastrar Cliente");
        botaoCadastrarCliente.setFont(fonte);

        // Adicionando os componentes ao painel de loja
        gbc.gridx = 0; gbc.gridy = 0; painelLoja.add(botaoCadastrarProduto, gbc);
        gbc.gridx = 0; gbc.gridy = 1; painelLoja.add(botaoCadastrarCliente, gbc);

        // Inicializando componentes do painel de cadastro de produto
        JButton botaoCadastrarProdutoDetalhes = new JButton("Cadastrar Produto");
        botaoCadastrarProdutoDetalhes.setFont(fonte);
        
        JButton botaoEditarProduto = new JButton("Editar Produto");
        botaoEditarProduto.setFont(fonte);
        
        JButton botaoConsultarProduto = new JButton("Consultar Produto");
        botaoConsultarProduto.setFont(fonte);
        
        JButton botaoRemoverProduto = new JButton("Remover Produto");
        botaoRemoverProduto.setFont(fonte);

        // Adicionando os componentes ao painel de cadastro de produto
        gbc.gridx = 0; gbc.gridy = 0; painelCadastrarProduto.add(botaoCadastrarProdutoDetalhes, gbc);
        gbc.gridx = 0; gbc.gridy = 1; painelCadastrarProduto.add(botaoEditarProduto, gbc);
        gbc.gridx = 0; gbc.gridy = 2; painelCadastrarProduto.add(botaoConsultarProduto, gbc);
        gbc.gridx = 0; gbc.gridy = 3; painelCadastrarProduto.add(botaoRemoverProduto, gbc);

        // Botão Voltar para painel de loja
        JButton botaoVoltarProduto = new JButton("Voltar");
        botaoVoltarProduto.setFont(fonte);
        gbc.gridx = 0; gbc.gridy = 4; painelCadastrarProduto.add(botaoVoltarProduto, gbc);

        // Inicializando componentes do painel de cadastro de cliente
        JButton botaoCadastrarClienteDetalhes = new JButton("Cadastrar Cliente");
        botaoCadastrarClienteDetalhes.setFont(fonte);
        
        JButton botaoEditarCliente = new JButton("Editar Cliente");
        botaoEditarCliente.setFont(fonte);
        
        JButton botaoConsultarCliente = new JButton("Consultar Cliente");
        botaoConsultarCliente.setFont(fonte);
        
        JButton botaoRemoverCliente = new JButton("Remover Cliente");
        botaoRemoverCliente.setFont(fonte);

        // Adicionando os componentes ao painel de cadastro de cliente
        gbc.gridx = 0; gbc.gridy = 0; painelCadastrarCliente.add(botaoCadastrarClienteDetalhes, gbc);
        gbc.gridx = 0; gbc.gridy = 1; painelCadastrarCliente.add(botaoEditarCliente, gbc);
        gbc.gridx = 0; gbc.gridy = 2; painelCadastrarCliente.add(botaoConsultarCliente, gbc);
        gbc.gridx = 0; gbc.gridy = 3; painelCadastrarCliente.add(botaoRemoverCliente, gbc);

        // Botão Voltar para painel de loja
        JButton botaoVoltarCliente = new JButton("Voltar");
        botaoVoltarCliente.setFont(fonte);
        gbc.gridx = 0; gbc.gridy = 4; painelCadastrarCliente.add(botaoVoltarCliente, gbc);

        // Exibindo a tela de login inicialmente
        janela.add(painelLogin);
        janela.setVisible(true);

        // Ação para o botão de login
        botaoLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = campoLogin.getText();
                String senha = new String(campoSenha.getPassword());

                // Verificando se o login existe e a senha está correta
                if (funcionarios.containsKey(login) && funcionarios.get(login).equals(senha)) {
                    mensagem.setText("Login bem-sucedido!");
                    mostrarLoja();
                } else {
                    mensagem.setText("Login ou senha incorretos.");
                }
            }
        });

        // Ação para o botão de criar conta
        botaoCriarConta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarCadastroFuncionario();
            }
        });

        // Ação para o botão de criar conta confirmada
        botaoCriarContaConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String novoLogin = campoNovoLogin.getText();
                String novaSenha = new String(campoNovaSenha.getPassword());

                if (novoLogin.isEmpty() || novaSenha.isEmpty()) {
                    JOptionPane.showMessageDialog(janela, "Preencha todos os campos!");
                } else if (funcionarios.containsKey(novoLogin)) {
                    JOptionPane.showMessageDialog(janela, "Login já existe. Tente outro.");
                } else {
                    funcionarios.put(novoLogin, novaSenha);
                    JOptionPane.showMessageDialog(janela, "Conta criada com sucesso!");
                    mostrarLogin();
                }
            }
        });

        // Ação para o botão de voltar no cadastro de produto
        botaoVoltarProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarLoja();
            }
        });

        // Ação para o botão de voltar no cadastro de cliente
        botaoVoltarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarLoja();
            }
        });

        // Ação para o botão de "Cadastrar Produto" (no painel de loja)
        botaoCadastrarProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarCadastrarProduto();
            }
        });

        // Ação para o botão de "Cadastrar Cliente" (no painel de loja)
        botaoCadastrarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarCadastrarCliente();
            }
        });
    }

    // Métodos para mostrar os painéis
    public static void mostrarLogin() {
        janela.getContentPane().removeAll();
        janela.add(painelLogin);
        janela.revalidate();
        janela.repaint();
    }

    public static void mostrarCadastroFuncionario() {
        janela.getContentPane().removeAll();
        janela.add(painelCadastro);
        janela.revalidate();
        janela.repaint();
    }

    public static void mostrarLoja() {
        janela.getContentPane().removeAll();
        janela.add(painelLoja);
        janela.revalidate();
        janela.repaint();
    }

    public static void mostrarCadastrarProduto() {
        janela.getContentPane().removeAll();
        janela.add(painelCadastrarProduto);
        janela.revalidate();
        janela.repaint();
    }

    public static void mostrarCadastrarCliente() {
        janela.getContentPane().removeAll();
        janela.add(painelCadastrarCliente);
        janela.revalidate();
        janela.repaint();
    }
}
