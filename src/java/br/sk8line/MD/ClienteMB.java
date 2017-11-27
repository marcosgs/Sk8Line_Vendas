package br.sk8line.MD;

import java.util.List;
import br.sk8line.ejb.ClienteLocal;
import br.sk8line.modelo.Cliente;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class ClienteMB implements Serializable{
    
    private Cliente cliente = new Cliente();
    
    @EJB
    private ClienteLocal ejb;
    
    private List<Cliente> clientes;
    
    private String tipoCliente;
    
    @PostConstruct
    public void init(){
        consultarTodos();
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ClienteLocal getEjb() {
        return ejb;
    }

    public void setEjb(ClienteLocal ejb) {
        this.ejb = ejb;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    
    public void consultarTodos(){
        clientes = ejb.consultarTodos();
    }
    
    public String salvar() throws Exception{
        
        try{
            cliente = ejb.salvar(cliente);
            consultarTodos();
            return "clientes";

        }catch(Exception e){
            FacesMessage msg = new FacesMessage("Erro interno! Contate um administrador!");
            FacesContext.getCurrentInstance().addMessage("validaCadastro",msg);
            return null;
        }
    }
    
    public String remover(Long id){
        ejb.remover(id);
        consultarTodos();
        return "clientes";
    }
    
    public String irCadastro(){
        return "clienteCad";
    }   
    
    public String alterar(Long id){
        cliente = ejb.consultarPorId(id);        
        EnderecoMB endereco = new EnderecoMB();
        endereco.consultaPorCliente(id);
        return "clienteCad"; 
    }
    
    public String tipoClienteDescricao( String tipoCliente) {
        if (tipoCliente.equals("F")){
            this.tipoCliente = "CPF";
            return "CPF";
        }
        if (tipoCliente.equals("J")){
            this.tipoCliente = "CNPJ";
            return "CNPJ";
        }
        return null;    
    }
    
    public String cancelarCad(){
        return "clientes";
    }

}
