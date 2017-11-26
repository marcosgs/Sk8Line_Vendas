package br.sk8line.MD;

import java.util.List;
import br.sk8line.ejb.CategoriaLocal;
import br.sk8line.modelo.Categoria;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class CategoriaMB {
    
    private Categoria categoria = new Categoria();
    
    @EJB
    private CategoriaLocal ejb;
    
    private List<Categoria> categorias;
    
    @PostConstruct
    public void init(){
        consultarTodos();
    }
    
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public CategoriaLocal getEjb() {
        return ejb;
    }

    public void setEjb(CategoriaLocal ejb) {
        this.ejb = ejb;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public void consultarTodos(){
        categorias = ejb.consultarTodos();
    }
    
    public String salvar() throws Exception{
        
        try{
            categoria = ejb.salvar(categoria);
            consultarTodos();
            return "categorias";

        }catch(Exception e){
            FacesMessage msg = new FacesMessage("Erro interno! Contate um administrador!");
            FacesContext.getCurrentInstance().addMessage("validaCadastro",msg);
            return null;
        }
    }
    
    public String remover(Long id){
        ejb.remover(id);
        consultarTodos();
        return "categorias";
    }
    
    public String irCadastro(){
        return "categoriaCad";
    }   
    
    public String alterar(Long id){
        categoria = ejb.consultarPorId(id);        
        return "categoriaCad"; 
    }
    
    public String cancelarCad(){
        return "categorias";
    }

}
