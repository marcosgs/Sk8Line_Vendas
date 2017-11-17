package br.sk8line.dao;

import br.sk8line.modelo.Produto;

import javax.persistence.EntityManager;

public class ProdutoDAO {
    
    private EntityManager em;
    
    public Produto salvar(Produto p){
        return p;
    }
    
    
}
