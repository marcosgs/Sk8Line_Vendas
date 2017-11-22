package br.sk8line.MD;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class MenuMB {
    
    public String acaoMnPrincipal(){
        return "main";
    }
    
    public String acaoMnUsuario(){
        return "listUsuarios";
    }
    
    public String acaoMnCliente(){
        return "listClientes";
    }
    public String acaoMnFuncionario(){
        return "funcionários";
    }
    public String acaoMnProduto(){
        return "produtos";
    }
}
