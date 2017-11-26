package br.sk8line.MD;

import br.sk8line.modelo.Usuario;
import javax.faces.bean.ManagedBean;

//Guarda usuário da sessão
@ManagedBean
public class UsuarioLogadoMB {
    
    private Usuario usuario = new Usuario();

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void guardaUsuarioLogado(Usuario usuario){
        this.usuario = usuario;
    }
    
    
}
