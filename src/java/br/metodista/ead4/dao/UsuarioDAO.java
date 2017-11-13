package br.metodista.ead4.dao;

import br.metodista.ead4.modulo.Usuario;
import javax.persistence.EntityManager;

/**
 *
 * @author Marcos
 */
public class UsuarioDAO {
    
    private EntityManager em;
    
    public UsuarioDAO(EntityManager em){
        this.em = em;
    }
    
    public Usuario Salvar(Usuario u) throws Exception{
        if(u.getId()==null){
            em.persist(u);
        }else{
            if(!em.contains(u)){
                if(em.find(Usuario.class, u.getId())==null ){
                    throw new Exception("Usuário não encontrado!");
                }
            }
            em.merge(u);
        }
        return u;
    }
    
    public Usuario consultarPorId(Long id){
        return em.find(Usuario.class, id);
    }
 
    public void remover(Long id){
        Usuario u = consultarPorId(id);
        em.remove(u);
        
    }
    
}
