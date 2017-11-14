package br.sk8line.MD;

import br.sk8line.ejb.UsuarioLocal;
import br.sk8line.modulo.Usuario;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;


@ManagedBean
public class UsuarioMB {
    
    private Usuario usuario = new Usuario();
    
    @EJB
    private UsuarioLocal ejb;
    
}
