package br.com.gestorestoque.view.menu.itensMenu;

import br.com.gestorestoque.util.FRMUtil;
import br.com.gestorestoque.view.FRMPrincipal;
import java.awt.Component;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author DG
 */
public class RadioButtonItemMenuLiquid extends JRadioButtonMenuItem {

    public RadioButtonItemMenuLiquid() {
        montarItemMenu();
    }

    public void montarItemMenu() {
        
        setText("Liquid");

        addActionListener((e) -> {
               try {
        
                FRMUtil.alterarLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel", FRMPrincipal.getInstance());
                FRMUtil.uncheck((JPopupMenu)this.getParent());
                this.setSelected(true);
                

            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
                JOptionPane.showMessageDialog(this, "Ocorreu um erro ao alterar a aparência do sistema!\nErro: " + ex.getMessage(), "GGlass - Erro", 0);
            }

        });

    }

}
