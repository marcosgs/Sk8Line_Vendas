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
public class UsuarioMB {
    
    private Usuario usuario = new Usuario();
    
    @EJB
    private UsuarioLocal ejb;
    
    private void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    
    public Usuario getUsuario(){
        return usuario;
    }
    
    public String salvar() throws Exception{
        
        usuario = ejb.Salvar(usuario);
        
        return "usuarios";
    }
    
}
