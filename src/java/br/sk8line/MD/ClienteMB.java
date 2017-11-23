package br.sk8line.MD;

import java.util.List;
import br.sk8line.ejb.ClienteLocal;
import br.sk8line.modelo.Cliente;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class ClienteMB {
    
    private Cliente cliente = new Cliente();
    
    @EJB
    private ClienteLocal ejb;
    
    private List<Cliente> clientes;

    @PostConstruct
    public void init(){
        clientes = consultarTodos();
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
    
    public List<Cliente> consultarTodos(){
        return ejb.consultarTodos();
    }
    
    public String salvar() throws Exception{
        cliente = ejb.salvar(cliente);
        clientes = consultarTodos();
        return "clientesCad";
    }
    
    public String remover(Long id){
        ejb.remover(id);
        clientes = consultarTodos();
        return "clientes";
    }
    
    public String irCadastro(){
        return "clienteCad";
    }   
    
    public String tipoClienteDescricao(){
        if (cliente.getTipoCliente() =="F"){
            return "CPF";
        }
        if (cliente.getTipoCliente()=="J"){
            return "CNPJ";
        }else{
            return null;
        }
    }
    
    
}
