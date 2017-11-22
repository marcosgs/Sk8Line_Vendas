package br.sk8line.MD;

import br.sk8line.ejb.UsuarioLocal;
import br.sk8line.modelo.Usuario;   
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;
import javax.annotation.PostConstruct;

@ManagedBean
@SessionScoped
public class UsuarioMB {
    
    private Usuario usuario = new Usuario();
    
    @EJB
    private UsuarioLocal ejb;
    
    private List<Usuario> usuarios;
    
    @PostConstruct
    public void init() {
        usuarios = ejb.consultarTodos();
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
    
    public List<Usuario> consultarTodos(){
        usuarios = ejb.consultarTodos();
        return usuarios;
    }
    
    
    public String salvar() throws Exception{
        usuario = ejb.salvar(usuario);
        return "listUsuarios";
    }
    
    //Vai para a tela de Cadastro de Usuários
    public String irCadastroUsuarios(){
        return "cadusuario";
    }
    
    public String remover(Long id){
        ejb.remover(id);
        return "listUsuarios";
    }
    
    public String cancelarCad(){
        return "listUsuarios";
    }
    
}
