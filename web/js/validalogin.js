function validarLogin(){
    var usuario = document.getElementById('usuario');
    var senha = document.getElementById('senha');
    
    var mensagem = document.getElementById('message');
    
    if (usuario.value =='' ){
        alert("Usuário em branco");
        mensagem.TextContext="Usuário em branco";
        usuario.focus();
        return false;
    }
    
    if (senha.value =='' ){
        alert("Senha em branco");
        senha.focus();
        return false;
    }
    
    return true;
}