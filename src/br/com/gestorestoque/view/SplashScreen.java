package br.com.gestorestoque.view;

import br.com.gestorestoque.banco.Conexao;
import br.com.gestorestoque.util.FRMUtil;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.UnsupportedLookAndFeelException;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author Matheus
 */
public class SplashScreen extends JWindow {

    AbsoluteLayout absoluto;
    AbsoluteConstraints absBarra, absImagem, absMensagem;
    ImageIcon imagem;
    JLabel label = new JLabel();
    JProgressBar barra = new JProgressBar();
    boolean conectado = false;
    int i =0,qtdTestes = 0;
    
    public SplashScreen() {

        absoluto = new AbsoluteLayout();
        absImagem = new AbsoluteConstraints(0, 0);
        absBarra = new AbsoluteConstraints(0, 310);
        imagem = new ImageIcon(this.getClass().getResource("Imagens//gestao-de-estoque.png"));

        barra.setPreferredSize(new Dimension(591, 20));
        java.awt.Color cor = new java.awt.Color(164, 36, 41);
        barra.setForeground(cor);
        barra.setBorderPainted(false);
        barra.setBackground(java.awt.Color.WHITE);
        barra.setStringPainted(true);
        barra.setString("Testando Conexão com o banco de dados ...");
        label.setIcon(imagem);
        this.setAlwaysOnTop(true);
        this.getContentPane().setLayout(absoluto);
        this.getContentPane().add(label, absImagem);
        this.getContentPane().add(barra, absBarra);
        
        
        
        
        new Thread() {
            @Override
            public void run() {
                int k;
                try {                  
                    for (k = 1; k <= 100; k++) {
                        barra.setValue(k);
                        
                       if(k == 1 || k == 25 || k == 50 || k == 75)
                       {
                           testar();
                       }
                       sleep(30);
                    }
                    if(conectado){
                            SplashScreen.this.setAlwaysOnTop(false);
                            FRMPrincipal janelaPrincipal = new FRMPrincipal();
                            FRMUtil.alterarLookAndFeel("com.alee.laf.WebLookAndFeel", janelaPrincipal);
                            janelaPrincipal.setAlwaysOnTop(true);
                            janelaPrincipal.setVisible(true);
                            janelaPrincipal.setAlwaysOnTop(false);
                            SplashScreen.this.setVisible(false);
                    }else{
                        SplashScreen.this.setAlwaysOnTop(false);
                        JOptionPane.showMessageDialog(null, "Erro: Não foi possivel se conectar com o banco de dados!\nVerifique a sua conexão com a internet e inicie o programa novamente." , "Erro!", JOptionPane.ERROR_MESSAGE);
                        System.exit(0);
                    }
                                                        
                        } catch (HeadlessException | ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException | InterruptedException e) {

                            JOptionPane.showMessageDialog(null, "Erro: " + e, "Erro!", JOptionPane.ERROR_MESSAGE);

                        }
                    }
          
        }.start();
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
                
                

    }

private void testar()
    {
       
             
            try {
                if(qtdTestes >= 4)
                {
                    return;
                }
                conectado = Conexao.testarConexao();
                System.out.println("Tentativa "+i++ +" sucedida");
                qtdTestes++;
            } catch (SQLException ex) {
                conectado = false;
                qtdTestes++;
                System.err.println("Tentativa "+i++ +" Falhou.");
            }
         
    }
}
