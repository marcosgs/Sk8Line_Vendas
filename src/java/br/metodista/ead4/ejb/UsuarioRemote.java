package br.metodista.ead4.ejb;

import br.metodista.ead4.modulo.Usuario;
import javax.ejb.Remote;
/**
 *
 * @author Marcos
 */
@Remote
public interface UsuarioRemote {
    
    public Usuario Salvar(Usuario u) throws Exception;
    
    public Usuario consultarPorId(Long id);
    
    public void remover(Long id);
    
}
