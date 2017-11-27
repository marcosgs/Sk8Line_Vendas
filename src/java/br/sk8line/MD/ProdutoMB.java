package br.sk8line.MD;

import java.util.List;
import br.sk8line.ejb.ProdutoLocal;
import br.sk8line.modelo.Produto;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class ProdutoMB implements Serializable{
    
    private Produto produto = new Produto();
    
    @EJB
    private ProdutoLocal ejb;
    
    private List<Produto> produtos;
    
    @PostConstruct
    public void init(){
        consultarTodos();
    }
    
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public ProdutoLocal getEjb() {
        return ejb;
    }

    public void setEjb(ProdutoLocal ejb) {
        this.ejb = ejb;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
    
    public void consultarTodos(){
        produtos = ejb.consultarTodos();
    }
    
    public String salvar() throws Exception{
        
        try{
            produto = ejb.salvar(produto);
            consultarTodos();
            return "produtos";

        }catch(Exception e){
            FacesMessage msg = new FacesMessage("Erro interno! Contate um administrador!");
            FacesContext.getCurrentInstance().addMessage("validaCadastro",msg);
            return null;
        }
    }
    
    public String remover(Long id){
        ejb.remover(id);
        consultarTodos();
        return "produtos";
    }
    
    public String irCadastro(){
        return "produtoCad";
    }   
    
    public String alterar(Long id){
        produto = ejb.consultarPorId(id);        
        return "produtoCad"; 
    }
    
    public String cancelarCad(){
        return "produtos";
    }

}
