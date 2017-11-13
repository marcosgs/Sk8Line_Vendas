package br.metodista.ead4.ejb;


import br.metodista.ead4.dao.CadUsuarioDAO;
import br.metodista.ead4.modulo.CadUsuario;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
/**
 *
 * @author Marcos
 */

@Stateless
public class CadUsuarioBean  implements CadUsuarioRemote{

    @PersistenceContext(unitName="Sk8Line_VendasPU")
    private EntityManager em;
    
    @Override
    public CadUsuario Salvar(CadUsuario u) throws Exception {
        CadUsuarioDAO dao = new CadUsuarioDAO(em);
        return dao.Salvar(u);
    }

    @Override
    public CadUsuario consultarPorId(Long id) {
        CadUsuarioDAO dao = new CadUsuarioDAO(em);
        return dao.consultarPorId(id);
    }

    @Override
    public void remover(Long id) {
        CadUsuarioDAO dao = new CadUsuarioDAO(em);
        
        dao.remover(id);
    }
    
}
