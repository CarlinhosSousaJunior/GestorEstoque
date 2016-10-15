/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestorestoque.view;

import br.com.gestorestoque.util.FRMUtil;
import br.com.gestorestoque.view.menu.fabrica.AbstractFabricaMenus;
import br.com.gestorestoque.view.menu.fabrica.BarraMenu;
import br.com.gestorestoque.view.menu.fabrica.CriadorFabricaMenu;
import br.com.gestorestoque.view.menu.fabrica.TipoMenu;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Matheus
 */
public class FRMPrincipal extends javax.swing.JFrame {
    
    
    private static FRMPrincipal fRMPrincipalUnicaInstancia;

    /**
     * Creates new form FRMPrincipal
     */
    public FRMPrincipal() {
        new FRMUtil().setarIcone(this, null);
        initComponents();
        getContentPane().setBackground(Color.WHITE);
        setExtendedState(MAXIMIZED_BOTH);
        prepararComponentes();
    }

    public static synchronized FRMPrincipal getInstance() {

        if (fRMPrincipalUnicaInstancia == null)
			fRMPrincipalUnicaInstancia = new FRMPrincipal();

		return fRMPrincipalUnicaInstancia;
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

        jLImagemPrincipal = new javax.swing.JLabel();
        jmbPrincipal = new javax.swing.JMenuBar();
        jmCadastros = new javax.swing.JMenu();
        jmiProduto = new javax.swing.JMenuItem();
        jmiUnidadeMedida = new javax.swing.JMenuItem();
        jmiArmazem = new javax.swing.JMenuItem();
        jmiFornecedor = new javax.swing.JMenuItem();
        jmMovimentacao = new javax.swing.JMenu();
        jmiEntrada = new javax.swing.JMenuItem();
        jmiSaida = new javax.swing.JMenuItem();
        jmiInventario = new javax.swing.JMenuItem();
        jmiSaldo_Estoque = new javax.swing.JMenuItem();
        jmiMovimentacoesEstoque = new javax.swing.JMenuItem();
        jmSistema = new javax.swing.JMenu();
        jMenuAparencia = new javax.swing.JMenu();
        jmiWindows = new javax.swing.JRadioButtonMenuItem();
        jmiWindowsClassic = new javax.swing.JRadioButtonMenuItem();
        jmiMotif = new javax.swing.JRadioButtonMenuItem();
        jmiNimbus = new javax.swing.JRadioButtonMenuItem();
        jmiLiquid = new javax.swing.JRadioButtonMenuItem();
        jmiMetal = new javax.swing.JRadioButtonMenuItem();
        jmiSynthetica = new javax.swing.JRadioButtonMenuItem();
        jmiWebLaf = new javax.swing.JRadioButtonMenuItem();
        jmiSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestor de estoque - Início");
        setSize(new java.awt.Dimension(591, 355));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLImagemPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gestorestoque/view/Imagens/gestor-estoque-transparente.png"))); // NOI18N
        jLImagemPrincipal.setName(""); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(jLImagemPrincipal, gridBagConstraints);

        jmCadastros.setText("Cadastros");

        jmiProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gestorestoque/view/Imagens/estoque-16.png"))); // NOI18N
        jmiProduto.setText("Produto");
        jmCadastros.add(jmiProduto);

        jmiUnidadeMedida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gestorestoque/view/Imagens/medida.png"))); // NOI18N
        jmiUnidadeMedida.setText("Unidade de Medida");
        jmCadastros.add(jmiUnidadeMedida);

        jmiArmazem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gestorestoque/view/Imagens/armazem.png"))); // NOI18N
        jmiArmazem.setText("Armazém");
        jmCadastros.add(jmiArmazem);

        jmiFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gestorestoque/view/Imagens/fornecedor.png"))); // NOI18N
        jmiFornecedor.setText("Fornecedor");
        jmCadastros.add(jmiFornecedor);

        jmbPrincipal.add(jmCadastros);

        jmMovimentacao.setText("Estoque");

        jmiEntrada.setBackground(new java.awt.Color(204, 204, 204));
        jmiEntrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gestorestoque/view/Imagens/entrada-16.png"))); // NOI18N
        jmiEntrada.setText("Entrada");
        jmMovimentacao.add(jmiEntrada);

        jmiSaida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gestorestoque/view/Imagens/saida-16.png"))); // NOI18N
        jmiSaida.setText("Saida");
        jmMovimentacao.add(jmiSaida);

        jmiInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gestorestoque/view/Imagens/inventario-16.png"))); // NOI18N
        jmiInventario.setText("Inventário");
        jmMovimentacao.add(jmiInventario);

        jmiSaldo_Estoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gestorestoque/view/Imagens/estoque-16.png"))); // NOI18N
        jmiSaldo_Estoque.setText("Saldos em Estoque");
        jmMovimentacao.add(jmiSaldo_Estoque);

        jmiMovimentacoesEstoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gestorestoque/view/Imagens/historicoMovimentacao.png"))); // NOI18N
        jmiMovimentacoesEstoque.setText("Histórico de Movimentações");
        jmMovimentacao.add(jmiMovimentacoesEstoque);

        jmbPrincipal.add(jmMovimentacao);

        jmSistema.setText("Sistema");

        jMenuAparencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gestorestoque/view/Imagens/looknfeel.png"))); // NOI18N
        jMenuAparencia.setText("Aparência");

        jmiWindows.setText("Windows");
        jMenuAparencia.add(jmiWindows);

        jmiWindowsClassic.setText("Windows Classic");
        jMenuAparencia.add(jmiWindowsClassic);

        jmiMotif.setText("Motif");
        jMenuAparencia.add(jmiMotif);

        jmiNimbus.setText("Nimbus");
        jMenuAparencia.add(jmiNimbus);

        jmiLiquid.setText("Liquid");
        jMenuAparencia.add(jmiLiquid);

        jmiMetal.setText("Metal");
        jMenuAparencia.add(jmiMetal);

        jmiSynthetica.setText("Synthetica");
        jMenuAparencia.add(jmiSynthetica);

        jmiWebLaf.setSelected(true);
        jmiWebLaf.setText("WebLaf");
        jMenuAparencia.add(jmiWebLaf);

        jmSistema.add(jMenuAparencia);

        jmiSobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gestorestoque/view/Imagens/sobre.png"))); // NOI18N
        jmiSobre.setText("Sobre");
        jmSistema.add(jmiSobre);

        jmbPrincipal.add(jmSistema);

        setJMenuBar(jmbPrincipal);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void menuMovimentacaoEntradaClicado() {

        new FRMCadastroEntradaSaida(this, true, true, "Entrada de produtos").setVisible(true);
    }

    private void menuMovimentacaoSaidaClicado() {
        new FRMCadastroEntradaSaida(this, true, false, "Saída de produtos").setVisible(true);
    }

    private void menuCadastroInventarioClicado() {
        new FRMInventario(this, true).setVisible(true);
    }

    private void menuRelatorioSaldoEstoqueClicado() {
        new FRMRelatorioSaldoEstoque(this, true).setVisible(true);
    }

    public void menuCadastroProdutoClicado() {
        new FRMCadastroProduto(this, true).setVisible(true);
    }

    public void menuCadastroUnidadeMediadaClicado() {
        new FRMCadastroUnidadeMedida(this, true).setVisible(true);
    }

    public void menuCadastroArmazemClicado() {
        new FRMCadastroArmazem(this, true).setVisible(true);
    }

    private void menuCadastroFornecedorClicado() {
        new FRMCadastroFornecedor(this, true).setVisible(true);
    }

    private void menuSobreClicado() {
        new FRMSobre(this, true).setVisible(true);
    }

    private void menuHistoricoMovimentacoesClicado() {
        new FRMMovimentacao(this, true).setVisible(true);
    }

    public void prepararComponentes() {

         AbstractFabricaMenus fabricaMenus = CriadorFabricaMenu.getMenuComponent(TipoMenu.ADMIN); 
         BarraMenu barraMenu = fabricaMenus.criaBarraMenu();
         //this.jmbPrincipal = fabricaMenus.criaBarraMenu();
         this.setJMenuBar(barraMenu.montarMenu());
        
        
        jmiMovimentacoesEstoque.addActionListener((e) -> {
            menuHistoricoMovimentacoesClicado();
        });

        jmiProduto.addActionListener((e) -> {
            menuCadastroProdutoClicado();
        });

        jmiUnidadeMedida.addActionListener((e) -> {
            menuCadastroUnidadeMediadaClicado();
        });
        jmiArmazem.addActionListener((e) -> {
            menuCadastroArmazemClicado();
        });
        jmiFornecedor.addActionListener((e) -> {
            menuCadastroFornecedorClicado();
        });

        jmiEntrada.addActionListener((e) -> {
            menuMovimentacaoEntradaClicado();
        });

        jmiSaida.addActionListener((e) -> {
            menuMovimentacaoSaidaClicado();
        });

        jmiInventario.addActionListener((e) -> {
            menuCadastroInventarioClicado();
        });

        jmiSaldo_Estoque.addActionListener((e) -> {
            menuRelatorioSaldoEstoqueClicado();
        });
        jmiSobre.addActionListener((e) -> {
            menuSobreClicado();
        });

        //=====================================
        //Itens de menu da aparência do sistema
        //=====================================
        //Windows
        jmiWindows.addActionListener((e) -> {
            try {
                FRMUtil.alterarLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel", this);
                uncheck();
                jmiWindows.setSelected(true);
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
                JOptionPane.showMessageDialog(this, "Ocorreu um erro ao alterar a aparência do sistema!\nErro: " + ex.getMessage(), "GGlass - Erro", 0);
            }
        });

        //Windows Classic
        jmiWindowsClassic.addActionListener((e) -> {
            try {
                FRMUtil.alterarLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel", this);
                uncheck();
                jmiWindowsClassic.setSelected(true);
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
                JOptionPane.showMessageDialog(this, "Ocorreu um erro ao alterar a aparência do sistema!\nErro: " + ex.getMessage(), "GGlass - Erro", 0);
            }
        });

        // Motif
        jmiMotif.addActionListener((e) -> {
            try {
                FRMUtil.alterarLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel", this);
                uncheck();
                jmiMotif .setSelected(true);
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
                JOptionPane.showMessageDialog(this, "Ocorreu um erro ao alterar a aparência do sistema!\nErro: " + ex.getMessage(), "GGlass - Erro", 0);
            }
        });

        // Nimbus
        jmiNimbus.addActionListener((e) -> {
            try {
                FRMUtil.alterarLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel", this);
                uncheck();
                jmiNimbus.setSelected(true);
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
                JOptionPane.showMessageDialog(this, "Ocorreu um erro ao alterar a aparência do sistema!\nErro: " + ex.getMessage(), "GGlass - Erro", 0);
            }
        });

        // Liquid
        jmiLiquid.addActionListener((e) -> {
            try {
                FRMUtil.alterarLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel", this);
                uncheck();
                jmiLiquid.setSelected(true);
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
                JOptionPane.showMessageDialog(this, "Ocorreu um erro ao alterar a aparência do sistema!\nErro: " + ex.getMessage(), "GGlass - Erro", 0);
            }
        });

        // Metal
        jmiMetal.addActionListener((e) -> {
            try {
                FRMUtil.alterarLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel", this);
                uncheck();
                jmiMetal .setSelected(true);
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
                JOptionPane.showMessageDialog(this, "Ocorreu um erro ao alterar a aparência do sistema!\nErro: " + ex.getMessage(), "GGlass - Erro", 0);
            }
        });

        // Synthetica
        jmiSynthetica.addActionListener((e) -> {
            try {
                FRMUtil.alterarLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaStandardLookAndFeel", this);
                uncheck();
                jmiSynthetica.setSelected(true);
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
                JOptionPane.showMessageDialog(this, "Ocorreu um erro ao alterar a aparência do sistema!\nErro: " + ex.getMessage(), "GGlass - Erro", 0);
            }
        });

        // WebLaf
        jmiWebLaf.addActionListener((e) -> {
            try {
                FRMUtil.alterarLookAndFeel("com.alee.laf.WebLookAndFeel", this);
                uncheck();
                jmiWebLaf.setSelected(true);
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
                JOptionPane.showMessageDialog(this, "Ocorreu um erro ao alterar a aparência do sistema!\nErro: " + ex.getMessage(), "GGlass - Erro", 0);
            }
        });
    }

    private void uncheck() {
        for (Component radio : jMenuAparencia.getMenuComponents()) {
            JRadioButtonMenuItem jr = (JRadioButtonMenuItem) radio;
            if (jr.isSelected()) {
                jr.setSelected(false);
            }

        }
    }

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
            java.util.logging.Logger.getLogger(FRMPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRMPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRMPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRMPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRMPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLImagemPrincipal;
    private javax.swing.JMenu jMenuAparencia;
    private javax.swing.JMenu jmCadastros;
    private javax.swing.JMenu jmMovimentacao;
    private javax.swing.JMenu jmSistema;
    private javax.swing.JMenuBar jmbPrincipal;
    private javax.swing.JMenuItem jmiArmazem;
    private javax.swing.JMenuItem jmiEntrada;
    private javax.swing.JMenuItem jmiFornecedor;
    private javax.swing.JMenuItem jmiInventario;
    private javax.swing.JRadioButtonMenuItem jmiLiquid;
    private javax.swing.JRadioButtonMenuItem jmiMetal;
    private javax.swing.JRadioButtonMenuItem jmiMotif;
    private javax.swing.JMenuItem jmiMovimentacoesEstoque;
    private javax.swing.JRadioButtonMenuItem jmiNimbus;
    private javax.swing.JMenuItem jmiProduto;
    private javax.swing.JMenuItem jmiSaida;
    private javax.swing.JMenuItem jmiSaldo_Estoque;
    private javax.swing.JMenuItem jmiSobre;
    private javax.swing.JRadioButtonMenuItem jmiSynthetica;
    private javax.swing.JMenuItem jmiUnidadeMedida;
    private javax.swing.JRadioButtonMenuItem jmiWebLaf;
    private javax.swing.JRadioButtonMenuItem jmiWindows;
    private javax.swing.JRadioButtonMenuItem jmiWindowsClassic;
    // End of variables declaration//GEN-END:variables

}
