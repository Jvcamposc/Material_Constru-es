package MaterialConstrucao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PainelCadastrarProduto extends JPanel {

    public PainelCadastrarProduto(JFrame janela) {
        setLayout(new GridBagLayout());
        Font fonte = new Font("Arial", Font.BOLD, 14);
        
        JButton botaoCadastrarProdutoDetalhes = new JButton("Cadastrar Produto");
        botaoCadastrarProdutoDetalhes.setFont(fonte);
        
        JButton botaoEditarProduto = new JButton("Editar Produto");
        botaoEditarProduto.setFont(fonte);
        
        JButton botaoConsultarProduto = new JButton("Consultar Produto");
        botaoConsultarProduto.setFont(fonte);
        
        JButton botaoRemoverProduto = new JButton("Remover Produto");
        botaoRemoverProduto.setFont(fonte);

        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.setFont(fonte);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        gbc.gridx = 0; gbc.gridy = 0; add(botaoCadastrarProdutoDetalhes, gbc);
        gbc.gridx = 0; gbc.gridy = 1; add(botaoEditarProduto, gbc);
        gbc.gridx = 0; gbc.gridy = 2; add(botaoConsultarProduto, gbc);
        gbc.gridx = 0; gbc.gridy = 3; add(botaoRemoverProduto, gbc);
        gbc.gridx = 0; gbc.gridy = 4; add(botaoVoltar, gbc);

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

