package br.sk8line.MD;

import br.sk8line.ejb.UsuarioLocal;
import br.sk8line.modelo.Usuario;   
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class UsuarioMB {
    
    private Usuario usuario = new Usuario();
    
    @EJB
    private UsuarioLocal ejb;
    
    private List<Usuario> usuarios;
    
    //Método para preencher dataTable ao iniciar
    @PostConstruct
    public void init() {
        consultarTodos();
    }
    
    private void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    public Usuario getUsuario(){
        return usuario;
    }
    
    //Consulta todos os usuários
    public void consultarTodos(){
        usuarios = ejb.consultarTodos();
    }
    
    public String salvar() throws Exception{
        
        try{
            usuario = ejb.salvar(usuario);
            consultarTodos();

        }catch(Exception e){
            FacesMessage msg = new FacesMessage("Erro interno! Contate um administrador!");
            FacesContext.getCurrentInstance().addMessage("validaCadastro",msg);
            return null;
        }
        return "usuarios";
        
    }
    
    //Vai para a tela de Cadastro de Usuários
    public String irCadastro(){
        return "usuarioCad";
    }
    
    public String remover(Long id){
        ejb.remover(id);
        consultarTodos();
        return "usuarios";
    }
    
    public String cancelarCad(){
        return "usuarios";
    }
    
    public String alterar(Long id){
        usuario = ejb.consultarPorId(id);        
        return "usuarioCad"; 
    }
    
    public String tipoAdminDescricao(String indAdmin){
        if (indAdmin.equals("S")){
            return "Sim";
        }else{
            return "Não";
        }
    }
    
}
