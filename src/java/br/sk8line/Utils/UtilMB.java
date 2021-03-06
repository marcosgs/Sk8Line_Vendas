package br.sk8line.Utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
    
    //Codigo a senha
    private String criptografaMD5(String valor) {
        MessageDigest md5;
        try { 
               //Instanciamos o nosso HASH MD5, poderíamos usar outro como
               //SHA, por exemplo, mas optamos por MD5.
               md5 = MessageDigest.getInstance("MD5");

               //Convert a String valor para um array de bytes em MD5
               byte[] valorMD5 = md5.digest(valor.getBytes("UTF-8"));

               //Convertemos os bytes para hexadecimal, assim podemos salvar
               //no banco para posterior comparação se senhas
               StringBuffer sb = new StringBuffer();
               for (byte b : valorMD5){
                      sb.append(Integer.toHexString((b & 0xFF) | 0x100).substring(1,3));
               }

               return sb.toString();

        } catch (NoSuchAlgorithmException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
               return null;
        } catch (UnsupportedEncodingException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
               return null;
        }
        
    }
}
