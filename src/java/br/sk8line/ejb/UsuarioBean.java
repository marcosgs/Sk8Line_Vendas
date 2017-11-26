package br.sk8line.ejb;

import br.sk8line.dao.UsuarioDAO;
import br.sk8line.modelo.Usuario;

import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateful
public class UsuarioBean implements UsuarioLocal{
    
    @PersistenceContext(unitName="Sk8Line_VendasPU")
    private EntityManager em;

    @Override
    public Usuario salvar(Usuario u) throws Exception {
        UsuarioDAO dao = new UsuarioDAO(em);
        return dao.salvar(u);
    }

    @Override
    public Usuario consultarPorId(Long id) {
        UsuarioDAO dao = new UsuarioDAO(em);
        return dao.consultarPorID(id);
    }
    
    @Override
    public List<Usuario> consultarTodos(){
        UsuarioDAO dao = new UsuarioDAO(em);
        return dao.consultarTodos();
    }
    
    @Override
    public Usuario consultarPorLogin(String login)throws Exception{
        UsuarioDAO dao = new UsuarioDAO(em);
        try {
            return dao.consultarPorLogin(login);
        } catch (Exception ex) {
            throw new Exception("Usuário não encontrado!");
        }
    }
    
    @Override
    public void remover(Long id) {
        UsuarioDAO dao = new UsuarioDAO(em);
        dao.remover(id);
    }
    
}
