package br.sk8line.ejb;

import br.sk8line.dao.FuncionarioDAO;
import br.sk8line.modelo.Funcionario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class FuncionarioBean {
    
    @PersistenceContext(unitName="Sk8Line_VendasPU")
    private EntityManager em;
    
    public Funcionario salvar(Funcionario f) throws Exception{
        FuncionarioDAO dao = new FuncionarioDAO(em);
        return dao.salvar(f);
    }
    
    public Funcionario consultarPorId(Long id){
        FuncionarioDAO dao = new FuncionarioDAO(em);
        return dao.consultarPorId(id);
    }
    
    public void remover(Long id){
        FuncionarioDAO dao = new FuncionarioDAO(em);
        dao.remover(id);
    }s
}
