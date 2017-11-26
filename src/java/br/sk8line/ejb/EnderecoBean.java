package br.sk8line.ejb;

import br.sk8line.dao.EnderecoDAO;
import br.sk8line.modelo.Endereco;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EnderecoBean implements EnderecoLocal{
    
    @PersistenceContext(unitName="Sk8Line_VendasPU")
    private EntityManager em;
    
    @Override
    public Endereco salvar(Endereco c) throws Exception{
        EnderecoDAO dao = new EnderecoDAO(em);
        return dao.salvar(c) ;
    }
    
    @Override
    public Endereco consultarPorId(Long id){
        EnderecoDAO dao = new EnderecoDAO(em);
        return dao.consultarPorId(id);
    }
    
    @Override
    public void remover(Long id){
        EnderecoDAO dao = new EnderecoDAO(em);
        dao.remover(id);
    }

    @Override
    public List<Endereco> consultarTodos() {
        EnderecoDAO dao = new EnderecoDAO(em);
        return dao.consultarTodos();
    }
    
    @Override
    public List<Endereco> consultaPorCliente(Long clienteID) {
        EnderecoDAO dao = new EnderecoDAO(em);
        return dao.consultaPorCliente(clienteID);
    }
    
    
}
