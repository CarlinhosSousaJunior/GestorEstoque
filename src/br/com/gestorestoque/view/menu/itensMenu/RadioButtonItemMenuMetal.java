package br.com.gestorestoque.view.menu.itensMenu;

import br.com.gestorestoque.util.FRMUtil;
import br.com.gestorestoque.view.FRMPrincipal;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author DG
 */
public class RadioButtonItemMenuMetal extends JRadioButtonMenuItem {

    public RadioButtonItemMenuMetal() {
        montarItemMenu();
    }

    public void montarItemMenu() {

        setText("Metal");

        addActionListener((e) -> {
            try {
        
                FRMUtil.alterarLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel", FRMPrincipal.getInstance());
                FRMUtil.uncheck((JPopupMenu)this.getParent());
                this.setSelected(true);

            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
                JOptionPane.showMessageDialog(this, "Ocorreu um erro ao alterar a aparência do sistema!\nErro: " + ex.getMessage(), "GGlass - Erro", 0);
            }
        });

    }

}
