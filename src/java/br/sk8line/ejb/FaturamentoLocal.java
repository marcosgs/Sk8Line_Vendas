package br.sk8line.ejb;

import br.sk8line.modelo.Faturamento;
import java.util.List;
import javax.ejb.Local;

@Local
public interface FaturamentoLocal {
    
    public Faturamento salvar(Faturamento f) throws Exception;
    
    public Faturamento consultarPorId (Long id);
    
    public List<Faturamento> consultarTodos();
    
}
