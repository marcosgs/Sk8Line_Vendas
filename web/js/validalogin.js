function validar(){
    var usuario = document.getElementById('usuario');
    var senha = document.getElementById('senha');
    
    var message = document.getElementByClass('message');
    
    if (usuario.value =='' ){
        alert("Usuário em branco");
        message.TextContext="Usuário em branco";
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