/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestorestoque.view.menu.menus;

import javax.swing.JMenu;

/**
 *
 * @author DG
 */
public class MenuCadastros extends JMenu{

    public MenuCadastros() {
    montarMenu();
    }
    
    public void montarMenu(){
        setText("Cadastros");
    }
    
}
