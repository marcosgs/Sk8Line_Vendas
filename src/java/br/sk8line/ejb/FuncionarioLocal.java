package br.sk8line.ejb;

import br.sk8line.modelo.Funcionario;
import javax.ejb.Local;

@Local
public interface FuncionarioLocal {
    
    public Funcionario salvar(Funcionario f)throws Exception;
    
    public Funcionario consultarPorId(Long id);
    
    public void remover(Long id);
    
}
