package MaterialConstrucao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Map;

public class PainelCadastro extends JPanel {

    private JTextField campoNovoLogin;
    private JPasswordField campoNovaSenha;
    private JButton botaoCriarContaConfirmar, botaoVoltar;
    private Map<String, String> funcionarios;

    public PainelCadastro(Map<String, String> funcionarios, JFrame janela) {
        this.funcionarios = funcionarios;

        setLayout(new GridBagLayout());
        Font fonte = new Font("Arial", Font.BOLD, 14);

        JLabel labelNovoLogin = new JLabel("Novo Login:");
        labelNovoLogin.setFont(fonte);
        campoNovoLogin = new JTextField(15);
        campoNovoLogin.setFont(fonte);

        JLabel labelNovaSenha = new JLabel("Nova Senha:");
        labelNovaSenha.setFont(fonte);
        campoNovaSenha = new JPasswordField(15);
        campoNovaSenha.setFont(fonte);

        botaoCriarContaConfirmar = new JButton("Criar Conta");
        botaoCriarContaConfirmar.setFont(fonte);
        botaoVoltar = new JButton("Voltar");
        botaoVoltar.setFont(fonte);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0; gbc.gridy = 0; add(labelNovoLogin, gbc);
        gbc.gridx = 1; add(campoNovoLogin, gbc);

        gbc.gridx = 0; gbc.gridy = 1; add(labelNovaSenha, gbc);
        gbc.gridx = 1; add(campoNovaSenha, gbc);

        gbc.gridx = 1; gbc.gridy = 2; add(botaoCriarContaConfirmar, gbc);
        gbc.gridx = 1; gbc.gridy = 3; add(botaoVoltar, gbc);

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
                    mostrarLogin(janela);
                }
            }
        });

        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarLogin(janela);
            }
        });
    }

    private void mostrarLogin(JFrame janela) {
        janela.getContentPane().removeAll();
        PainelLogin painelLogin = new PainelLogin(funcionarios, janela);
        janela.add(painelLogin);
        janela.revalidate();
        janela.repaint();
    }
}

