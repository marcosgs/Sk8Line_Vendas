package br.sk8line.MD;

import br.sk8line.ejb.UsuarioLocal;
import br.sk8line.modelo.Usuario;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class loginMB implements Serializable{
    
    private Usuario usuario = new Usuario();
    
    private UsuarioLogadoMB usuarioLogado;
    
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
            usuario = ejb.consultarPorLogin(login);
            if (this.login.equals(usuario.getLogin()) && this.senha.equals(usuario.getSenha())){
                //usuarioLogado.guardaUsuarioLogado(usuario);
                
                HttpSession session = SessionUtils.getSession();
                session.setAttribute("username", usuario);
                return "main";
            }else{
                FacesMessage msg = new FacesMessage("Usuário e senha inválidos!");
                FacesContext.getCurrentInstance().addMessage("validaLogin",msg);
            }
        }catch(Exception e){
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Nome de Usuário ou Senha inválidos.","Não foi localizado o usuário e senha apontados.");
            FacesContext.getCurrentInstance().addMessage("validaLogin",msg);
            this.usuario = new Usuario();
            
        }
        return "login";
        
    }

    public String logout(){
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "login";
    }
    
    public boolean validaAdmin(){
        
        return usuarioLogado.getUsuario().getIndAdmin().equals("S");
        //return usuario.getIndAdmin().equals('S');
    }
}
