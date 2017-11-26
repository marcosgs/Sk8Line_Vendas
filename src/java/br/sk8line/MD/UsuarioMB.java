package br.sk8line.MD;

import br.sk8line.ejb.UsuarioLocal;
import br.sk8line.modelo.Usuario;   
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class UsuarioMB {
    
    private Usuario usuario = new Usuario();
    
    @EJB
    private UsuarioLocal ejb;
    
    private List<Usuario> usuarios;
    
    //Método para preencher dataTable ao iniciar
    @PostConstruct
    public void init() {
        consultarTodos();
    }
    
    private void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    public Usuario getUsuario(){
        return usuario;
    }
    
    //Consulta todos os usuários
    public void consultarTodos(){
        usuarios = ejb.consultarTodos();
    }
    
    public String salvar() throws Exception{
        
        try{
            usuario = ejb.salvar(usuario);
            consultarTodos();
            return "usuarios";

        }catch(Exception e){
            FacesMessage msg = new FacesMessage("Erro interno! Contate um administrador!");
            FacesContext.getCurrentInstance().addMessage("validaCadastro",msg);
            return null;
        }
        
        
    }
    
    //Vai para a tela de Cadastro de Usuários
    public String irCadastro(){
        return "usuarioCad";
    }
    
    public String remover(Long id){
        ejb.remover(id);
        consultarTodos();
        return "usuarios";
    }
    
    public String cancelarCad(){
        return "usuarios";
    }
    
    public String alterar(Long id){
        usuario = ejb.consultarPorId(id);        
        return "usuarioCad"; 
    }
    
    public String tipoAdminDescricao(String indAdmin){
        if (indAdmin.equals("S")){
            return "Sim";
        }else{
            return "Não";
        }
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
