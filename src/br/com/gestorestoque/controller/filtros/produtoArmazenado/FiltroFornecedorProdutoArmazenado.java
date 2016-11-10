
package br.com.gestorestoque.controller.filtros.produtoArmazenado;

import br.com.gestorestoque.controller.filtros.Filtro;
import br.com.gestorestoque.model.ProdutoArmazenado;
import br.com.gestorestoque.util.FiltroUtil;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 5981468
 */
public class FiltroFornecedorProdutoArmazenado implements Filtro<ProdutoArmazenado>  {
    
     String fornNome;
    int selectedIndex;

    public FiltroFornecedorProdutoArmazenado( String fornNome, int selectedIndex) {
        
        this.fornNome = fornNome;
        this.selectedIndex = selectedIndex;
    }

    @Override
    public List<ProdutoArmazenado> filtrar(List<ProdutoArmazenado> lista) {

        List<ProdutoArmazenado> produtosArmazenadosPesquisa = new ArrayList<>();
        if (FiltroUtil.validarIndex(selectedIndex)) {
            if (selectedIndex == 1) {
                for (ProdutoArmazenado produto : lista) {
                    if (produto.getFornecedor().getNome().toUpperCase().contains(fornNome.toUpperCase())) {
                        produtosArmazenadosPesquisa.add(produto);
                    }
                }
            } else if (selectedIndex == 2) {
                for (ProdutoArmazenado produto : lista) {
                    if (produto.getFornecedor().getNome().toUpperCase().equalsIgnoreCase(fornNome.toUpperCase())) {
                        produtosArmazenadosPesquisa.add(produto);
                    }
                }
            }
            return produtosArmazenadosPesquisa;
        }
        return null;
    }

    
    
}