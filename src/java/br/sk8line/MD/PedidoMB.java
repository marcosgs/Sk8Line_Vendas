package br.sk8line.MD;

import br.sk8line.ejb.PedidoLocal;
import br.sk8line.modelo.Pedido;   
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class PedidoMB {
    
    private Pedido pedido = new Pedido();
    
    @EJB
    private PedidoLocal ejb;
    
    private List<Pedido> pedidos;
    
    private String statusDescricao;
    
    //Método para preencher dataTable ao iniciar
    @PostConstruct
    public void init() {
        consultarTodos();
    }
    
    private void setPedido(Pedido pedido){
        this.pedido = pedido;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    
    public Pedido getPedido(){
        return pedido;
    }
    
    //Consulta todos os usuários
    public void consultarTodos(){
        pedidos = ejb.consultarTodos();
    }
    
    public String salvar() throws Exception{
        
        try{
            pedido = ejb.salvar(pedido);
            consultarTodos();
            return "pedidos";

        }catch(Exception e){
            FacesMessage msg = new FacesMessage("Erro interno! Contate um administrador!");
            FacesContext.getCurrentInstance().addMessage("validaCadastro",msg);
            return null;
        }
    }
    
    //Vai para a tela de Cadastro de Usuários
    public String irCadastro(){
        return "pedidoCad";
    }
    
    public String remover(Long id) throws Exception{
        
        try{
            ejb.remover(id);
            consultarTodos();
            return "pedidos";

        }catch(Exception e){
            FacesMessage msg = new FacesMessage("Falha ao excluir Pedido");
            FacesContext.getCurrentInstance().addMessage("validaPedido",msg);
            return null;
        }
    }
    
    public String cancelarCad(){
        return "pedidos";
    }
    
    public String alterar(Long id){
        pedido = ejb.consultarPorId(id);        
        return "pedidoCad"; 
    }
    
    
    public String statusDescriccao( String status) {
        if (status.equals("A")){
            this.statusDescricao = "CPF";
            return "CPF";
        }
        if (status.equals("P")){
            this.statusDescricao = "CNPJ";
            return "CNPJ";
        }
        if (status.equals("F")){
            this.statusDescricao = "CNPJ";
            return "CNPJ";
        }
        return null;
        
    }
}
