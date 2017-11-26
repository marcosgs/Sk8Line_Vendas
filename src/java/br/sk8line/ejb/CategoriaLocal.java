package br.sk8line.ejb;

import br.sk8line.modelo.Categoria;
import java.util.List;
import javax.ejb.Local;

@Local
public interface CategoriaLocal {
    
    public Categoria salvar(Categoria c)throws Exception;
    
    public Categoria consultarPorId(Long id);
    
    public void remover(Long id);
    
    public List<Categoria> consultarTodos();
}
