/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestorestoque.controller;

import br.com.gestorestoque.banco.CRUD;
import br.com.gestorestoque.model.Fornecedor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matheus
 */

public class ControladorFornecedor {
   
    /**
     * @return List < Fornecedor > fornecedores 
     * @throws SQLException 
     */
    public static List<Fornecedor> selecionarTodosFornecedores()throws SQLException
    {
       List<Fornecedor> fornecedores = new ArrayList<>();
        ResultSet rs = CRUD.select("fornecedor");
        while (rs.next()) {
            Fornecedor fornecedor = new Fornecedor(rs.getInt("idfornecedor"), rs.getString("nome"),rs.getString("cpf"),rs.getString("cnpj"));
            fornecedores.add(fornecedor);
        }
       return fornecedores;
    }
    
    /**
     * Seleciona fornecedor por código.
     * @param idFornecedor 
     * @return fornecedor Fornecedor
     * @throws SQLException 
     */
    public static Fornecedor selecionarFornecedorPorCodigo(String idFornecedor)throws SQLException
    {
        Fornecedor fornecedor = new Fornecedor();
        ResultSet rs = CRUD.select("fornecedor","where idFornecedor = "+idFornecedor);
        while (rs.next()) {
            fornecedor = new Fornecedor(rs.getInt("idfornecedor"), rs.getString("nome"),rs.getString("cpf"),rs.getString("cnpj"));
            
        }
       return fornecedor;
    }
    
    public static void inserirFornecedor(Fornecedor fornecedor) throws SQLException{
        
        CRUD.insert("fornecedor", "null,'"+fornecedor.getNome()+"','"+fornecedor.getCpf()+"','"+fornecedor.getCnpj()+"'");   
    }
    
    public static void deleteFornececor(Fornecedor fornecedor) throws SQLException
    {
        CRUD.delete("fornecedor","idfornecedor",Integer.toString(fornecedor.getIdFornecedor()));
    }
    
    public static void updateFornecedorPorId(String valores,String valorWhere) throws SQLException{
        
        CRUD.update("fornecedor",valores,"idfornecedor",valorWhere);
        
    }
    
}
