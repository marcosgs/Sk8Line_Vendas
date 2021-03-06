package br.sk8line.ejb;

import br.sk8line.modelo.Usuario;
import java.util.List;
import javax.ejb.Local;

@Local
public interface UsuarioLocal {
    
    public Usuario salvar(Usuario u) throws Exception;
    
    public Usuario consultarPorId (Long id);
    
    public List<Usuario> consultarTodos();
    
    public Usuario consultarPorLogin(String login)throws Exception;
    
    public void remover(Long id);
}
