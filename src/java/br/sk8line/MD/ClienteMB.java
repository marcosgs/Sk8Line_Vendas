package br.sk8line.MD;

import br.sk8line.ejb.ClienteBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class ClienteMB {
    
    @EJB
    private ClienteBean ejb;
    
    
}
