package br.sk8line.MD;

import br.sk8line.ejb.FaturamentoLocal;
import br.sk8line.modelo.Faturamento;   
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class FaturamentoMB {
    
    private Faturamento faturamento = new Faturamento();
    
    @EJB
    private FaturamentoLocal ejb;
    
    private List<Faturamento> faturamentos;
    
    private String statusDescricao;
    
    //Método para preencher dataTable ao iniciar
    @PostConstruct
    public void init() {
        consultarTodos();
    }
    
    private void setFaturamento(Faturamento faturamento){
        this.faturamento = faturamento;
    }
    
    public Faturamento getFaturamento(){
        return faturamento;
    }
    
    public List<Faturamento> getFaturamentos() {
        return faturamentos;
    }

    public void setFaturamentos(List<Faturamento> faturamentos) {
        this.faturamentos = faturamentos;
    }
    
    //Consulta todos os usuários
    public void consultarTodos(){
        faturamentos = ejb.consultarTodos();
    }
    
    public String salvar() throws Exception{
        
        try{
            faturamento = ejb.salvar(faturamento);
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
    
    public String cancelarCad(){
        return "faturamentos";
    }
    
    public String alterar(Long id){
        faturamento = ejb.consultarPorId(id);        
        return "faturamentoCad"; 
    }
    
    public String statusDescriccao( String status) {
        return null;
    }
}
