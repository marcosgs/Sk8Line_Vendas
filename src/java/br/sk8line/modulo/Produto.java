package br.sk8line.modulo;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name="TB_PRODUCTS")
public class Produto implements Serializable {
    /*
    Tabela Produtos
    TB_PRODUCTS
    
    Colunas
    CD_PRODUCT
    DC_PRODUCT
    NU_PRICE
    */
    
    
    @Id
    @Column(name="CD_PRODUCT")
    private Long id;
    
    private String nome;
    
    private float preco; 
    
}
