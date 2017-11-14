package br.sk8line.ejb;

import br.sk8line.modulo.Usuario;
import javax.ejb.Local;

@Local
public interface UsuarioLocal {
    
    public Usuario Salvar(Usuario u) throws Exception;
    
    public Usuario consultarPorId (Long id);
    
    public Usuario consultarPorLogin(String login);
    
    public void remover(Long id);
}
