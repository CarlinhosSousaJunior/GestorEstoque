/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestorestoque.view;

import java.util.HashMap;
import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author DG
 */
public class FRMRelatorio extends javax.swing.JDialog {

    /**
     * Creates new form FRMRelatorio
     * @param parent
     * @param modal
     * @param jrRS
     * @param nomeRelatorio
     */
    public FRMRelatorio(java.awt.Dialog parent, boolean modal,JRResultSetDataSource jrRS,String nomeRelatorio) {
        super(parent, modal);
        initComponents();

        vizualizarRelatorio(jrRS,nomeRelatorio);
    }

    private void vizualizarRelatorio(JRResultSetDataSource jrRS,String nomeRelatorio) {
        try {
            
            
            JasperPrint jasperPrint = JasperFillManager.fillReport("src/br/com/gestorestoque/relatorio/"+nomeRelatorio+".jasper", new HashMap(), jrRS);
            JasperViewer jrViewer = new JasperViewer(jasperPrint, true);
            jrViewer.setSize(1200, 700);
            //Adicionando o relatorio no Jdialog  
            this.getContentPane().add(jrViewer.getContentPane());
            this.revalidate();
            //Deixar True para exibir a tela no sistema  
            //this.setVisible(true);
        }catch (JRRuntimeException  e){
            JOptionPane.showMessageDialog(null, "Não foi possível gerar/salvar o relatório! \nErro:"+e.getMessage(),"Erro",0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível gerar o relatório! \nErro:"+e.getMessage(),"Erro",0);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório");

        setSize(new java.awt.Dimension(1200, 700));
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
            java.util.logging.Logger.getLogger(FRMRelatorio.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRMRelatorio.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRMRelatorio.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRMRelatorio.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FRMRelatorio dialog = new FRMRelatorio(new javax.swing.JDialog(), true,null,"");
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
    // End of variables declaration//GEN-END:variables
}
