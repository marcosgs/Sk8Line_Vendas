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
        return "usuarios";
    }
    
    public String acaoMnCliente(){
        return "clientes";
    }
    public String acaoMnFuncionario(){
        return "funcionarios";
    }
    public String acaoMnProduto(){
        return "produtos";
    }
}
