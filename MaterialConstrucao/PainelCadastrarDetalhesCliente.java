package MaterialConstrucao;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PainelCadastrarDetalhesCliente extends JPanel {

    public PainelCadastrarDetalhesCliente(JFrame janela) {
        setLayout(new GridBagLayout());
        Font fonte = new Font("Arial", Font.BOLD, 14);

        // Campos do formulário de cadastro de cliente
        JLabel labelNome = new JLabel("Nome:");
        labelNome.setFont(fonte);
        JTextField campoNome = new JTextField(20);
        campoNome.setFont(fonte);

        JLabel labelCpf = new JLabel("CPF:");
        labelCpf.setFont(fonte);
        JTextField campoCpf = new JTextField(20);
        campoCpf.setFont(fonte);

        JLabel labelEmail = new JLabel("E-mail:");
        labelEmail.setFont(fonte);
        JTextField campoEmail = new JTextField(20);
        campoEmail.setFont(fonte);

        // Novo campo de Endereço
        JLabel labelEndereco = new JLabel("Endereço:");
        labelEndereco.setFont(fonte);
        JTextField campoEndereco = new JTextField(20);
        campoEndereco.setFont(fonte);

        // Novo campo de Cidade
        JLabel labelCidade = new JLabel("Cidade:");
        labelCidade.setFont(fonte);
        JTextField campoCidade = new JTextField(20);
        campoCidade.setFont(fonte);

        // Novo campo de UF (Unidade Federativa)
        JLabel labelUF = new JLabel("UF:");
        labelUF.setFont(fonte);
        String[] ufs = {"SP", "RJ", "MG", "RS", "BA", "PR", "SC", "PE", "CE", "ES", "GO", "MA", "MT", "MS", "PA", "PB", "PI", "PR", "RN", "RO", "RR", "SE", "AL", "AP", "TO"};
        JComboBox<String> comboBoxUF = new JComboBox<>(ufs);
        comboBoxUF.setFont(fonte);
        comboBoxUF.setSelectedIndex(0); // Define o primeiro estado como selecionado por padrão

        // Opções de cliente: Novo ou Antigo utilizando JComboBox
        JLabel labelTipoCliente = new JLabel("Tipo de Cliente:");
        labelTipoCliente.setFont(fonte);

        String[] tiposCliente = {"Cliente Novo", "Cliente Antigo"};
        JComboBox<String> comboBoxTipoCliente = new JComboBox<>(tiposCliente);
        comboBoxTipoCliente.setFont(fonte);
        comboBoxTipoCliente.setSelectedIndex(0); 
        JButton botaoSalvar = new JButton("Salvar");
        botaoSalvar.setFont(fonte);

        JButton botaoCancelar = new JButton("Cancelar");
        botaoCancelar.setFont(fonte);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0; gbc.gridy = 0; add(labelNome, gbc);
        gbc.gridx = 1; gbc.gridy = 0; add(campoNome, gbc);

        gbc.gridx = 0; gbc.gridy = 1; add(labelCpf, gbc);
        gbc.gridx = 1; gbc.gridy = 1; add(campoCpf, gbc);

        gbc.gridx = 0; gbc.gridy = 2; add(labelEmail, gbc);
        gbc.gridx = 1; gbc.gridy = 2; add(campoEmail, gbc);

        gbc.gridx = 0; gbc.gridy = 3; add(labelEndereco, gbc);
        gbc.gridx = 1; gbc.gridy = 3; add(campoEndereco, gbc);

        gbc.gridx = 0; gbc.gridy = 4; add(labelCidade, gbc);
        gbc.gridx = 1; gbc.gridy = 4; add(campoCidade, gbc);

        gbc.gridx = 0; gbc.gridy = 5; add(labelUF, gbc);
        gbc.gridx = 1; gbc.gridy = 5; add(comboBoxUF, gbc);

        gbc.gridx = 0; gbc.gridy = 6; add(labelTipoCliente, gbc);
        gbc.gridx = 1; gbc.gridy = 6; add(comboBoxTipoCliente, gbc);

        gbc.gridx = 0; gbc.gridy = 7; add(botaoSalvar, gbc);
        gbc.gridx = 1; gbc.gridy = 7; add(botaoCancelar, gbc);

        botaoCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janela.getContentPane().removeAll();
                PainelCadastrarCliente painelCadastrarCliente = new PainelCadastrarCliente(janela);
                janela.add(painelCadastrarCliente);
                janela.revalidate();
                janela.repaint();
            }
        });

        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipoCliente = (String) comboBoxTipoCliente.getSelectedItem();
                String uf = (String) comboBoxUF.getSelectedItem();
                JOptionPane.showMessageDialog(janela, "Cliente " + tipoCliente + " cadastrado com sucesso!\nUF: " + uf);

                janela.getContentPane().removeAll();
                PainelCadastrarCliente painelCadastrarCliente = new PainelCadastrarCliente(janela);
                janela.add(painelCadastrarCliente);
                janela.revalidate();
                janela.repaint();
            }
        });
    }
}
