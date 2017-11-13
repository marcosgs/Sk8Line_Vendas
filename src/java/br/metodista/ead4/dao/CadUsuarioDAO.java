package br.metodista.ead4.dao;

import br.metodista.ead4.modulo.CadUsuario;
import javax.persistence.EntityManager;

/**
 *
 * @author Marcos
 */
public class CadUsuarioDAO {
    
    private EntityManager em;
    
    public CadUsuarioDAO(EntityManager em){
        this.em = em;
    }
    
    public CadUsuario Salvar(CadUsuario u) throws Exception{
        if(u.getId()==null){
            em.persist(u);
        }else{
            if(!em.contains(u)){
                if(em.find(CadUsuario.class, u.getId())==null ){
                    throw new Exception("Usuário não encontrado!");
                }
            }
            em.merge(u);
        }
        return u;
    }
    
    public CadUsuario consultarPorId(Long id){
        return em.find(CadUsuario.class, id);
    }
 
    public void remover(Long id){
        CadUsuario u = consultarPorId(id);
        em.remove(u);
        
    }
    
}
