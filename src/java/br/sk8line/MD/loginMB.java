package br.sk8line.MD;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class loginMB {
    private String usuario;
    private String senha;
    
    private String usuarioSist ="root";
    private String senhaSist = "root";
    
    public void setUsuario(String usuario){
        this.usuario=usuario;
    }
    
    public String getUsuario(){
        return usuario;
    }
    
    public void setSenha(String senha){
        this.senha=senha;
    }
    
    public String getSenha(){
        return senha;
    }
    
    public String validarLogon(){
        
        //if (this.usuario == this.usuarioSist && this.senha == this.senhaSist){ 
        if (this.usuario.equals(usuarioSist) && this.senha.equals(senhaSist)){
            FacesMessage msg = new FacesMessage("Usuário e senha são válidos!");
            FacesContext.getCurrentInstance().addMessage("erro",msg);
        }else{
            FacesMessage msg = new FacesMessage("Usuário e senha são inválidos !");
            FacesContext.getCurrentInstance().addMessage("erro",msg);
        }
        return null;
    }
}
