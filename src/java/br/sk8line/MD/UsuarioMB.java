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
    
    //Método para preencher dataTable ao iniciar
    @PostConstruct
    public void init() {
        usuarios = consultarTodos();
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
    public List<Usuario> consultarTodos(){
        usuarios = ejb.consultarTodos();
        return usuarios;
    }
    
    public String salvar() throws Exception{
        usuario = ejb.salvar(usuario);
        usuarios = consultarTodos();
        return "usuarios";
    }
    
    //Vai para a tela de Cadastro de Usuários
    public String irCadastro(){
        limpaUsuario();
        return "usuarioCad";
    }
    
    public void limpaUsuario(){
        usuario.setId(null);
        usuario.setNome(null);
        usuario.setLogin(null);
        usuario.setFuncionario(null);
        usuario.setIndAdmin(null);
        usuario.setSenha(null);
    }
    
    public String remover(Long id){
        ejb.remover(id);
        usuarios = consultarTodos();
        return "usuarios";
    }
    
    public String cancelarCad(){
        return "usuarios";
    }
    
    public String alterar(Long id){
        usuario = ejb.consultarPorId(id);        
        return "usuarioCad"; 
    }
    
}
