package br.sk8line.Enum;

public enum indTipo {
    ADMINISTRADOR("A"),
    USUARIO("U");
    
    private String indTipo;
    
    private indTipo(String indTipo){
        this.indTipo = indTipo;
    }
    
    public String indTipo(){
        return indTipo;
    }
}
