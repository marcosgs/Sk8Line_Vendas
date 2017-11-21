package br.sk8line.ejb;

import javax.ejb.Local;
import br.sk8line.modelo.Produto;
import java.util.List;

@Local
public interface ProdutoLocal {
    
    public Produto Salvar(Produto p) throws Exception;
    
    public Produto consultarPorId ( Long id);
    
    public List<Produto> consultarTodos();
    
    public void remover(Long id);
    
}
