package br.sk8line.ejb;

import br.sk8line.modelo.Funcionario;
import java.util.List;
import javax.ejb.Local;

@Local
public interface FuncionarioLocal {
    
    public Funcionario salvar(Funcionario f)throws Exception;
    
    public Funcionario consultarPorId(Long id);
    
    public void remover(Long id);
    
    public List<Funcionario> consultarTodos();
}
