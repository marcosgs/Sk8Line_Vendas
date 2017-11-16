package br.sk8line.ejb;

import br.sk8line.dao.UsuarioDAO;
import br.sk8line.modulo.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateful
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
        try {
            return dao.consultarPorLogin(login);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public void remover(Long id) {
        UsuarioDAO dao = new UsuarioDAO(em);
        dao.remover(id);
    }
    
}
