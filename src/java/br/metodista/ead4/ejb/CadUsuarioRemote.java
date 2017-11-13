package br.metodista.ead4.ejb;

import br.metodista.ead4.modulo.CadUsuario;
import javax.ejb.Remote;
/**
 *
 * @author Marcos
 */
@Remote
public interface CadUsuarioRemote {
    
    public CadUsuario Salvar(CadUsuario u) throws Exception;
    
    public CadUsuario consultarPorId(Long id);
    
    public void remover(Long id);
    
}
