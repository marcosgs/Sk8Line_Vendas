package br.metodista.ead4.ejb;


import br.metodista.ead4.dao.UsuarioDAO;
import br.metodista.ead4.modulo.Usuario;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
/**
 *
 * @author Marcos
 */

@Stateless
public class UsuarioBean  implements UsuarioRemote{

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
        return dao.consultarPorId(id);
    }

    @Override
    public void remover(Long id) {
        UsuarioDAO dao = new UsuarioDAO(em);
        
        dao.remover(id);
    }
    
}
