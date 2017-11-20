package br.sk8line.MD;

import br.sk8line.ejb.UsuarioLocal;
import br.sk8line.modelo.Usuario;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean
@SessionScoped
public class UsuarioMB {
    
    private Usuario usuario = new Usuario();
    
    private List<Usuario> usuarios;
    
    @EJB
    private UsuarioLocal ejb;
    
    private void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    
    public Usuario getUsuario(){
        return usuario;
    }
    
    public String salvar() throws Exception{
        
        usuario = ejb.salvar(usuario);
        
        return "usuarios";
    }
    
}
