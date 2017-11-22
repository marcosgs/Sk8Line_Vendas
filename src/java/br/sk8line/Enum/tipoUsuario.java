package br.sk8line.Enum;

public enum tipoUsuario {
    ADMINISTRADOR("A"),
    USUARIO("U");
    
    private String indTipo;
    
    tipoUsuario(String indTipo){
        this.indTipo = indTipo;
    }
    
    public String indTipo(){
        return indTipo;
    }
}
