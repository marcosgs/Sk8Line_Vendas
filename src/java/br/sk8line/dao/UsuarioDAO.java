package br.sk8line.dao;

import br.sk8line.modulo.Usuario;
import javax.persistence.EntityManager;

public class UsuarioDAO {
    
    private EntityManager em;
    
    public UsuarioDAO(EntityManager em){
        this.em=em;
    }
    
    public Usuario Salvar(Usuario u) throws Exception{
        if (u.getId()==null){
            em.persist(u);
        }else{
            if(!em.contains(u)){
                if(em.find(Usuario.class,u.getId())==null){
                    throw new Exception("Usuário não encontrado!");
                }
            }
            em.merge(u);
        }
        
        return u;
    }
    
    public Usuario consultarPorID(Long id){
        return em.find(Usuario.class, id);
    }
    
    public Usuario consultarPorLogin(String login){
        return em.find(Usuario.class, login);
    }
    
    public void remover( Long id){
        Usuario u = consultarPorID(id);
        em.remove(u);
    }
    
    
}
