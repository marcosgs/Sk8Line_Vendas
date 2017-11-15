package br.sk8line.dao;

import br.sk8line.modulo.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

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
    
//    public List<Emprestimo> consultarTodos() {
//        EntityManager entityManager = getEntityManager();
//        Query query = entityManager.createNamedQuery("Emprestimo.consultarTodos");
//        return query.getResultList();
//    }
        
    public Usuario consultarPorLogin(String login){
        
        // Query consulta = em.createQuery("select CD_USER id, DC_NAME_USER login, DC_PASSWORD senha, DC_NAME nome from TB_USERS Usuario where login= '" + login + "'", Usuario.class);
        //Query consulta = em.createNativeQuery("select * from Usuario");   
        //Usuario usuario = (Usuario) consulta.getResultList();
        
        //EntityManager em = getEntityManager();
        Query consulta = em.createNamedQuery("Usuario.login");
        consulta.setParameter("login", login);
        
        return (Usuario) consulta.getSingleResult();
        
    }
    
    public void remover( Long id){
        Usuario u = consultarPorID(id);
        em.remove(u);
    }

    
}
