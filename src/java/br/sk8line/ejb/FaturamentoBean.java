package br.sk8line.ejb;

import br.sk8line.dao.FaturamentoDAO;
import br.sk8line.modelo.Faturamento;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateful
public class FaturamentoBean implements FaturamentoLocal{
    
    @PersistenceContext(unitName="Sk8Line_VendasPU")
    private EntityManager em;

    @Override
    public Faturamento salvar(Faturamento u) throws Exception {
        FaturamentoDAO dao = new FaturamentoDAO(em);
        return dao.salvar(u);
    }

    @Override
    public Faturamento consultarPorId(Long id) {
        FaturamentoDAO dao = new FaturamentoDAO(em);
        return dao.consultarPorId(id);
    }
    
    @Override
    public List<Faturamento> consultarTodos(){
        FaturamentoDAO dao = new FaturamentoDAO(em);
        return dao.consultarTodos();
    }
}
