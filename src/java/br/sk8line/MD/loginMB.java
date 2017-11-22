package br.sk8line.MD;

import br.sk8line.ejb.UsuarioLocal;
import br.sk8line.modelo.Usuario;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class loginMB {
    
    private Usuario usuarioLogado = new Usuario();
    
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
    
    public String validaLogin(){
        try{
            usuarioLogado = ejb.consultarPorLogin(login);

            if (this.login.equals(usuarioLogado.getLogin()) && this.senha.equals(usuarioLogado.getSenha())){
                return "main";
            }else{
                FacesMessage msg = new FacesMessage("Usuário ou senha não encontrado");
                FacesContext.getCurrentInstance().addMessage("xxx",msg);
            }
            System.out.println(usuarioLogado.getLogin() + usuarioLogado.getSenha());
        }catch(Exception e){
            FacesMessage msg = new FacesMessage("Falha contate um administrador!");
            FacesContext.getCurrentInstance().addMessage("xxx",msg);
        }
        return "login";
    }

    public void logout(){
        
    }
    
    public boolean validaAdmin(){
        return usuarioLogado.getIndAdmin().equals('S');
    }
}
