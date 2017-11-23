package br.sk8line.ejb;

import br.sk8line.modelo.Cliente;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ClienteLocal {
    
    public Cliente salvar(Cliente c)throws Exception;
    
    public Cliente consultarPorId(Long id);
    
    public void remover(Long id);
    
    public List<Cliente> consultarTodos();
}
