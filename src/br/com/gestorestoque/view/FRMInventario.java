/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestorestoque.view;

import br.com.gestorestoque.controller.Controlador;
import br.com.gestorestoque.controller.ControladorMovimentacao;
import br.com.gestorestoque.controller.ControladorProdutoArmazenado;
import br.com.gestorestoque.model.Movimentacao;
import br.com.gestorestoque.model.Produto;
import br.com.gestorestoque.model.ProdutoArmazenado;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;


/**
 *
 * @author Carlinhos
 */
public class FRMInventario extends javax.swing.JDialog {

    ProdutoArmazenado produtoArmazenado = new ProdutoArmazenado();
    Produto produto = new Produto();
    Controlador controlador;
    

    /**
     * Creates new form FRMInventario
     * @param parent
     * @param modal
     */
    public FRMInventario(java.awt.Frame parent, boolean modal) {
        
        super(parent, modal);
        this.controlador = new ControladorProdutoArmazenado();
        initComponents();
        prepararComponentes();
    }

    public FRMInventario(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        this.controlador = new ControladorProdutoArmazenado();
        initComponents();
        prepararComponentes();
    }

    private void prepararComponentes() {

        jbtnSalvar.addActionListener(
                (e) -> {
                    Salvar();
                }
        );

        jbtnLimpar.addActionListener(
                (e) -> {
                    btnLimparClicado();
                }
        );        

        jbtnPesquisarProduto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pesquisaProduto();
            }
        });
        
        //jdialogInventario
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (verificarComponentesPreenchidos()) {
                    if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Há itens que não foram salvos!\n Deseja mesmo sair?", "Fechar", JOptionPane.YES_NO_OPTION, 3)) {
                        dispose();
                    }
                } else {
                    dispose();
                }
            }

        });

    }
    
    private boolean verificarComponentesPreenchidos() {

        if (!jtfNomeArmazem.getText().equalsIgnoreCase("")) {
            return true;
        }

        if (!jtfArmazem.getText().equalsIgnoreCase("")) {
            return true;
        }

        if (!jtfLote.getText().equalsIgnoreCase("")) {
            return true;
        }

        if (!jtfProduto.getText().equalsIgnoreCase("")) {
            return true;
        }

        if (!jtfNomeProduto.getText().equalsIgnoreCase("")) {
            return true;
        }

        return false;
    }


    private void pesquisaArmazem() {
        FRMCadastroArmazem cadastroArmazem = new FRMCadastroArmazem(this, true);
        cadastroArmazem.setVisible(true);
        cadastroArmazem.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                jtfArmazem.setText("" + cadastroArmazem.armazemAlterarExcluir.getCodigo());
                jtfNomeArmazem.setText(cadastroArmazem.armazemAlterarExcluir.getDescricao());
            }
        });
    }

    private void pesquisaProduto() {

        FRMRelatorioSaldoEstoque frmSaldo = new FRMRelatorioSaldoEstoque(this, true);
        frmSaldo.jbtEntradaProduto.setEnabled(false);
        frmSaldo.jbtSaidaProduto.setEnabled(false);
        frmSaldo.jbtnventario.setEnabled(false);
        frmSaldo.jtProdutosArmazenados.setToolTipText("Duplo clique para selecionar um produto!");
        frmSaldo.setVisible(true);

        frmSaldo.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {

                try{
                produtoArmazenado = new ProdutoArmazenado();
                produtoArmazenado = frmSaldo.produtoArmazenadoPesquisa;
                
                if (produtoArmazenado.getProduto().isControladoPorLote()) {
                    jtfLote.setEnabled(true);
                    jtfLote.setText(produtoArmazenado.getLote());
                } else {
                    jtfLote.setEnabled(false);
                    jtfLote.setText("");
                }
                jtfArmazem.setText("" + produtoArmazenado.getArmazem().getCodigo());
                jtfNomeArmazem.setText(produtoArmazenado.getArmazem().getDescricao());
                jtfProduto.setText("" + produtoArmazenado.getProduto().getCodigo());
                jtfNomeProduto.setText(produtoArmazenado.getProduto().getNome());
                jsQtd.setValue(produtoArmazenado.getQuantidade());

            }catch(Exception ex){
                  //  System.out.println("Erro: "+ ex.getMessage());
            }
            
            
        }
            
        });

    }

    private void Salvar() {

        if (this.jsQtd.getValue().equals(0) || jtfArmazem.getText().equalsIgnoreCase("") || jtfProduto.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos necessários !", "Atenção!", 2);
            return;
        }

        try {

            produtoArmazenado.setQuantidade(Double.parseDouble(jsQtd.getValue().toString()));

            controlador.atualizarPorCodigo(produtoArmazenado);
            
            //Salvar movimentação
            controlador = new ControladorMovimentacao();
            controlador.inserir(new Movimentacao( produtoArmazenado.getLote(), produtoArmazenado.getQuantidade(), produtoArmazenado.getNotaFiscal(),"I", new Date(), produtoArmazenado, produtoArmazenado.getArmazem()));
            JOptionPane.showMessageDialog(null, "Inventário realizado com sucesso! ", "Inventário", JOptionPane.INFORMATION_MESSAGE);
            btnLimparClicado();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível concluir a operação: " + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnLimparClicado() {
        jtfProduto.setText("");
        jtfNomeProduto.setText("");
        jtfArmazem.setText("");
        jtfNomeArmazem.setText("");
        jtfLote.setText("");
        jsQtd.setValue(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jlDescricao = new javax.swing.JLabel();
        jtfLote = new javax.swing.JTextField();
        jlDescricao3 = new javax.swing.JLabel();
        jsQtd = new javax.swing.JSpinner();
        jlArmazem1 = new javax.swing.JLabel();
        jtfNomeArmazem = new javax.swing.JTextField();
        jlProduto = new javax.swing.JLabel();
        jtfNomeProduto = new javax.swing.JTextField();
        jbtnPesquisarProduto = new javax.swing.JButton();
        jbtnSalvar = new javax.swing.JButton();
        jbtnLimpar = new javax.swing.JButton();
        jtfArmazem = new javax.swing.JTextField();
        jtfProduto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inventário");
        setPreferredSize(new java.awt.Dimension(480, 380));

        java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
        jPanel1Layout.columnWidths = new int[] {0, 12, 0, 12, 0, 12, 0, 12, 0, 12, 0, 12, 0, 12, 0, 12, 0, 12, 0, 12, 0};
        jPanel1Layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        jPanel1.setLayout(jPanel1Layout);

        jlDescricao.setText("Lote:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jlDescricao, gridBagConstraints);

        jtfLote.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        jPanel1.add(jtfLote, gridBagConstraints);

        jlDescricao3.setText("Qtd:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jlDescricao3, gridBagConstraints);

        jsQtd.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        jsQtd.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        jPanel1.add(jsQtd, gridBagConstraints);

        jlArmazem1.setText("Armazem:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jlArmazem1, gridBagConstraints);

        jtfNomeArmazem.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 2, 5, 2);
        jPanel1.add(jtfNomeArmazem, gridBagConstraints);

        jlProduto.setText("Produto:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jlProduto, gridBagConstraints);

        jtfNomeProduto.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 2, 5, 2);
        jPanel1.add(jtfNomeProduto, gridBagConstraints);

        jbtnPesquisarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gestorestoque/view/Imagens/search-16.png"))); // NOI18N
        jbtnPesquisarProduto.setToolTipText("Abre a tela de produtos. (duplo clique na tabela para selecionar um produto)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 18;
        gridBagConstraints.gridy = 6;
        jPanel1.add(jbtnPesquisarProduto, gridBagConstraints);

        jbtnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gestorestoque/view/Imagens/save_accept.png"))); // NOI18N
        jbtnSalvar.setText("Salvar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 28;
        jPanel1.add(jbtnSalvar, gridBagConstraints);

        jbtnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gestorestoque/view/Imagens/edit-clear.png"))); // NOI18N
        jbtnLimpar.setText("Limpar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 28;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jbtnLimpar, gridBagConstraints);

        jtfArmazem.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jtfArmazem, gridBagConstraints);

        jtfProduto.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jtfProduto, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(591, 366));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FRMInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRMInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRMInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRMInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FRMInventario dialog = new FRMInventario(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtnLimpar;
    private javax.swing.JButton jbtnPesquisarProduto;
    private javax.swing.JButton jbtnSalvar;
    private javax.swing.JLabel jlArmazem1;
    private javax.swing.JLabel jlDescricao;
    private javax.swing.JLabel jlDescricao3;
    private javax.swing.JLabel jlProduto;
    private javax.swing.JSpinner jsQtd;
    private javax.swing.JTextField jtfArmazem;
    private javax.swing.JTextField jtfLote;
    private javax.swing.JTextField jtfNomeArmazem;
    private javax.swing.JTextField jtfNomeProduto;
    private javax.swing.JTextField jtfProduto;
    // End of variables declaration//GEN-END:variables
}
