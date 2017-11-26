package br.sk8line.ejb;

import br.sk8line.modelo.Endereco;
import java.util.List;
import javax.ejb.Local;

@Local
public interface EnderecoLocal {
    
    public Endereco salvar(Endereco e)throws Exception;
    
    public Endereco consultarPorId(Long id);
    
    public void remover(Long id);
    
    public List<Endereco> consultarTodos();
    
    public List<Endereco> consultaPorCliente(Long clienteID);
}
