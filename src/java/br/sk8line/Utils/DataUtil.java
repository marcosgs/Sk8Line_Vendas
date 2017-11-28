package br.sk8line.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class DataUtil {
    
    public String formataData(Date data){
        
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return df.format(data);
    }
    
    public Date formataDataHora(Date data){
        return null;
    }
}
