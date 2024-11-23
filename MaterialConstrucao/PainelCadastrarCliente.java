package MaterialConstrucao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PainelCadastrarCliente extends JPanel {

    public PainelCadastrarCliente(JFrame janela) {
        setLayout(new GridBagLayout());
        Font fonte = new Font("Arial", Font.BOLD, 14);

        JButton botaoCadastrarClienteDetalhes = new JButton("Cadastrar Cliente");
        botaoCadastrarClienteDetalhes.setFont(fonte);

        JButton botaoEditarCliente = new JButton("Editar Cliente");
        botaoEditarCliente.setFont(fonte);

        JButton botaoConsultarCliente = new JButton("Consultar Cliente");
        botaoConsultarCliente.setFont(fonte);

        JButton botaoRemoverCliente = new JButton("Remover Cliente");
        botaoRemoverCliente.setFont(fonte);

        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.setFont(fonte);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0; gbc.gridy = 0; add(botaoCadastrarClienteDetalhes, gbc);
        gbc.gridx = 0; gbc.gridy = 1; add(botaoEditarCliente, gbc);
        gbc.gridx = 0; gbc.gridy = 2; add(botaoConsultarCliente, gbc);
        gbc.gridx = 0; gbc.gridy = 3; add(botaoRemoverCliente, gbc);
        gbc.gridx = 0; gbc.gridy = 4; add(botaoVoltar, gbc);

        // Ação do botão "Cadastrar Cliente"
        botaoCadastrarClienteDetalhes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Remove todos os componentes atuais da janela
                janela.getContentPane().removeAll();
                
                // Cria e adiciona o painel de cadastro de cliente
                PainelCadastrarDetalhesCliente painelCadastro = new PainelCadastrarDetalhesCliente(janela);
                janela.add(painelCadastro);
                
                // Atualiza a janela
                janela.revalidate();
                janela.repaint();
            }
        });

        // Ação do botão "Voltar"
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janela.getContentPane().removeAll();
                PainelLoja painelLoja = new PainelLoja(janela);
                janela.add(painelLoja);
                janela.revalidate();
                janela.repaint();
            }
        });
    }
}
