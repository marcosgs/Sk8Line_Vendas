package br.sk8line.MD;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class UtilMB {
    
    public String formataData(Date data){
        
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return df.format(data);
    }
    
    public Date formataDataHora(Date data){
        return null;
    }
}
