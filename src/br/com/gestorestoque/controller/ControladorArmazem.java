
package br.com.gestorestoque.controller;

import br.com.gestorestoque.banco.CRUD;
import br.com.gestorestoque.model.Armazem;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DG
 */
public class ControladorArmazem implements Controlador<Armazem>{
    private String nomeTabela;

    public ControladorArmazem() {
        this.nomeTabela = "armazem";
    }

    @Override
    public void inserir(Armazem armazem) throws SQLException {
        CRUD.insert(nomeTabela, "null,'"+armazem.getDescricao()+"'");
    }

    @Override
    public void atualizarPorCodigo(Armazem armazem) throws SQLException {
        CRUD.update(nomeTabela, "descricao = '"+armazem.getDescricao()+"'","codigoArmazem",armazem.getCodigo().toString());
    }

    @Override
    public List<Armazem> selecionarTodos() throws SQLException {
         List<Armazem> armazens = new ArrayList<>();

        ResultSet rs = CRUD.select(nomeTabela);

        while (rs.next()) {
            Armazem armazem = new Armazem(rs.getInt("codigoArmazem"), rs.getString("descricao"));
            armazens.add(armazem);
        }

        return armazens;
    }

    @Override
    public Armazem selecionarPorCodigo(int id) throws SQLException {
        Armazem armazem = new Armazem();

        ResultSet rs = CRUD.select(nomeTabela,"codigoArmazem",id);

        while (rs.next()) {
            armazem = new Armazem(rs.getInt("codigoArmazem"), rs.getString("descricao"));
            
        }

        return armazem;
    }

    @Override
    public void deletar(Armazem armazem) throws SQLException {
        CRUD.delete(nomeTabela,"descricao","'"+armazem.getDescricao()+"'");
    }
    

}
