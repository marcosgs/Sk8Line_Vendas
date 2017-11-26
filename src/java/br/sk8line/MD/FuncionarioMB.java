package br.sk8line.MD;

import java.util.List;
import br.sk8line.ejb.FuncionarioLocal;
import br.sk8line.modelo.Funcionario;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class FuncionarioMB {
    
    private Funcionario funcionario = new Funcionario();
    
    @EJB
    private FuncionarioLocal ejb;
    
    private List<Funcionario> funcionarios;
    
    @PostConstruct
    public void init(){
        consultarTodos();
    }
    
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public FuncionarioLocal getEjb() {
        return ejb;
    }

    public void setEjb(FuncionarioLocal ejb) {
        this.ejb = ejb;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
    
    public void consultarTodos(){
        funcionarios = ejb.consultarTodos();
    }
    
    public String salvar() throws Exception{
        funcionario = ejb.salvar(funcionario);
        consultarTodos();
        return "funcionarioCad";
    }
    
    public String remover(Long id){
        ejb.remover(id);
        consultarTodos();
        return "funcionarios";
    }
    
    public String irCadastro(){
        return "funcionarioCad";
    }   
}
