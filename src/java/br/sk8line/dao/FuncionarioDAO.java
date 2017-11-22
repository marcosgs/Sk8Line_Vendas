package br.sk8line.dao;

import br.sk8line.modelo.Funcionario;
import javax.persistence.EntityManager;

public class FuncionarioDAO {
    
    private EntityManager em;
    
    public FuncionarioDAO(EntityManager em){
        this.em = em;
    }
    
    public Funcionario salvar(Funcionario f)throws Exception{
        if (f.getId()==null){
            em.persist(f);
        }else{
            if(!em.contains(f)){
                if(em.find(Funcionario.class, f.getId())==null ){
                    throw new Exception("Falha ao salvar funcionário!");
                }
            }
            em.merge(f);
        }
        return f;
    }
    
    public Funcionario consultarPorId(Long id){
        return em.find(Funcionario.class, id);
    }
    
    public void remover(Long id){
        Funcionario f = consultarPorId(id);
        em.remove(f);
    }
}
