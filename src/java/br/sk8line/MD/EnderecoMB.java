package br.sk8line.MD;

import java.util.List;
import br.sk8line.ejb.EnderecoLocal;
import br.sk8line.modelo.Endereco;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class EnderecoMB {
    
    private Endereco endereco = new Endereco();
    
    @EJB
    private EnderecoLocal ejb;
    
    private List<Endereco> enderecos;
    
    @PostConstruct
    public void init(){
        
    }
    
    public Endereco getCliente() {
        return endereco;
    }

    public void setCliente(Endereco endereco) {
        this.endereco = endereco;
    }

    public EnderecoLocal getEjb() {
        return ejb;
    }

    public void setEjb(EnderecoLocal ejb) {
        this.ejb = ejb;
    }

    public List<Endereco> getClientes() {
        return enderecos;
    }

    public void setClientes(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
    
    public void consultarTodos(){
        enderecos = ejb.consultarTodos();
    }
    
    public void consultarPorCliente(Long clienteID){
        enderecos = ejb.consultaPorCliente(clienteID);
    }
    
    public String salvar() throws Exception{
        
        try{
            endereco = ejb.salvar(endereco);
            consultarTodos();
            return "clienteCad";

        }catch(Exception e){
            FacesMessage msg = new FacesMessage("Erro interno! Contate um administrador!");
            FacesContext.getCurrentInstance().addMessage("validaCadastro",msg);
            return null;
        }
    }
    
    public String irCadastro(){
        return "enderecoCad";
    }   
    
    public String alterar(Long id){
        endereco = ejb.consultarPorId(id);        
        return "enderecoCad"; 
    }
    
    public String cancelarCad(){
        return "enderecos";
    }

}
