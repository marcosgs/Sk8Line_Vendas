package br.sk8line.ejb;

import br.sk8line.dao.UsuarioDAO;
import br.sk8line.modulo.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UsuarioBean implements UsuarioLocal{
    
    @PersistenceContext(unitName="Sk8Line_VendasPU")
    private EntityManager em;

    @Override
    public Usuario Salvar(Usuario u) throws Exception {
        UsuarioDAO dao = new UsuarioDAO(em);
        return dao.Salvar(u);
    }

    @Override
    public Usuario consultarPorId(Long id) {
        UsuarioDAO dao = new UsuarioDAO(em);
        return dao.consultarPorID(id);
    }

    @Override
    public Usuario consultarPorLogin(String login){
        UsuarioDAO dao = new UsuarioDAO(em);
        return dao.consultarPorLogin(login);
    }
    
    @Override
    public void remover(Long id) {
        UsuarioDAO dao = new UsuarioDAO(em);
        dao.remover(id);
    }
    
}
