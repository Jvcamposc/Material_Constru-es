package MaterialConstrucao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Map;

public class PainelLogin extends JPanel {

    private JTextField campoLogin;
    private JPasswordField campoSenha;
    private JButton botaoLogin, botaoCriarConta;
    private JLabel mensagem;
    private Map<String, String> funcionarios;

    public PainelLogin(Map<String, String> funcionarios, JFrame janela) {
        this.funcionarios = funcionarios;

        setLayout(new GridBagLayout());
        Font fonte = new Font("Arial", Font.BOLD, 14);

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

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        gbc.gridx = 0; gbc.gridy = 0; add(labelLogin, gbc);
        gbc.gridx = 1; add(campoLogin, gbc);

        gbc.gridx = 0; gbc.gridy = 1; add(labelSenha, gbc);
        gbc.gridx = 1; add(campoSenha, gbc);

        gbc.gridx = 1; gbc.gridy = 2; add(botaoLogin, gbc);
        gbc.gridx = 1; gbc.gridy = 3; add(mensagem, gbc);
        gbc.gridx = 1; gbc.gridy = 4; add(botaoCriarConta, gbc);

        botaoLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = campoLogin.getText();
                String senha = new String(campoSenha.getPassword());
                if (funcionarios.containsKey(login) && funcionarios.get(login).equals(senha)) {
                    mensagem.setText("Login bem-sucedido!");
                    mostrarLoja(janela);
                } else {
                    mensagem.setText("Login ou senha incorretos.");
                }
            }
        });

        botaoCriarConta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarCadastroFuncionario(janela);
            }
        });
    }

    private void mostrarLoja(JFrame janela) {
        janela.getContentPane().removeAll();
        PainelLoja painelLoja = new PainelLoja(janela);
        janela.add(painelLoja);
        janela.revalidate();
        janela.repaint();
    }

    private void mostrarCadastroFuncionario(JFrame janela) {
        janela.getContentPane().removeAll();
        PainelCadastro painelCadastro = new PainelCadastro(funcionarios, janela);
        janela.add(painelCadastro);
        janela.revalidate();
        janela.repaint();
    }
}
