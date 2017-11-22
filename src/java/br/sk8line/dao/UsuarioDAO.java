package br.sk8line.dao;

import br.sk8line.EM.EntityManagerUtil;
import br.sk8line.modelo.Usuario;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UsuarioDAO {
    
    private EntityManager em;
    
    public UsuarioDAO(EntityManager em){
        this.em = em;
    }
    
    public Usuario salvar(Usuario u) throws Exception{
        
        
        Date dataAtual = new Date();
        u.setDataAtual(dataAtual);
        
        if (u.getId()==null){    
            //Atribui a data atual ao
            u.setDataCriacao(dataAtual);
            
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
    
    public List<Usuario> consultarTodos() {
        Query query = em.createNamedQuery("Usuario.consultarTodos");
        return query.getResultList();
    }
        
    public Usuario consultarPorLogin(String login)throws Exception{
        
        try{
            Query consulta = em.createNamedQuery("Usuario.login");
            consulta.setParameter("login", login);
            return (Usuario) consulta.getSingleResult();
        } catch(Exception e){
            throw new Exception("Usuário não encontrado!");
            //return null;
        }
    }
    
    public void remover( Long id){
        Usuario u = consultarPorID(id);
        em.remove(u);
    }

    
}
