package MaterialConstrucao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PainelLoja extends JPanel {

    private JButton botaoCadastrarProduto, botaoCadastrarCliente;
    
    public PainelLoja(JFrame janela) {
        setLayout(new GridBagLayout());
        Font fonte = new Font("Arial", Font.BOLD, 14);

        botaoCadastrarProduto = new JButton("Produtos");
        botaoCadastrarProduto.setFont(fonte);

        botaoCadastrarCliente = new JButton("Clientes");
        botaoCadastrarCliente.setFont(fonte);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0; gbc.gridy = 0; add(botaoCadastrarProduto, gbc);
        gbc.gridx = 0; gbc.gridy = 1; add(botaoCadastrarCliente, gbc);

        botaoCadastrarProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarCadastrarProduto(janela);
            }
        });

        botaoCadastrarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarCadastrarCliente(janela);
            }
        });
    }

    private void mostrarCadastrarProduto(JFrame janela) {
        janela.getContentPane().removeAll();
        PainelCadastrarProduto painelCadastrarProduto = new PainelCadastrarProduto(janela);
        janela.add(painelCadastrarProduto);
        janela.revalidate();
        janela.repaint();
    }

    private void mostrarCadastrarCliente(JFrame janela) {
        janela.getContentPane().removeAll();
        PainelCadastrarCliente painelCadastrarCliente = new PainelCadastrarCliente(janela);
        janela.add(painelCadastrarCliente);
        janela.revalidate();
        janela.repaint();
    }
}

