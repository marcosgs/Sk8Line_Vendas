package br.sk8line.MD;

import br.sk8line.ejb.UsuarioLocal;
import br.sk8line.modulo.Usuario;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class loginMB {
    
    private Usuario usuario = new Usuario();
    
    private String login;
    private String senha;
    
    @EJB
    private UsuarioLocal ejb;
    
    public void setLogin(String login){
        this.login=login;
    }
    
    public String getLogin(){
        return login;
    }
    
    public void setSenha(String senha){
        this.senha=senha;
    }
    
    public String getSenha(){
        return senha;
    }
    
    public String validarLogon(){
        
        usuario = ejb.consultarPorLogin(login);
        
        //if (this.usuario == this.usuarioSist && this.senha == this.senhaSist){ 
        if (this.login.equals(usuario.getLogin()) && this.senha.equals(usuario.getSenha())){
            FacesMessage msg = new FacesMessage("Usuário e senha são válidos!");
            FacesContext.getCurrentInstance().addMessage("erro",msg);
        }else{
            FacesMessage msg = new FacesMessage("Usuário e senha são inválidos !");
            FacesContext.getCurrentInstance().addMessage("erro",msg);
        }
        return null;
    }
}
