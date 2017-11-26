package br.sk8line.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import org.jboss.weld.bean.AbstractBean;

@NamedQueries({
    @NamedQuery(name="Categoria.consultarTodos",
            query="select c "+
                  "from Categoria c"
    )
})

@Entity
@Table(name="TB_CATEGORY")
@SequenceGenerator(name="CATEGORY_SEQ", sequenceName = "CATEGORY_SEQ", initialValue = 1, allocationSize=1)
public class Categoria implements Serializable{
    
    @Id
    @Column(name= "CD_CATEGORY", length = 18)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="CATEGORY_SEQ")
    private Long id;
    
    @Column(name="DC_CATEGORY", nullable = false, length = 200)
    private String descricao;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    @Override
    public int hashCode() {
              final int prime = 31;
              int result = 1;
              result = prime * result + ((id == null) ? 0 : id.hashCode());
              return result;
    }

    @Override
    public boolean equals(Object obj) {
              if (this == obj)
                       return true;
              if (obj == null)
                       return false;
              if (getClass() != obj.getClass())
                       return false;

              return (obj instanceof AbstractBean) ? (this.getId() == null ? this == obj : this.getId().equals(((AbstractBean)obj).getId())):false;
    }
    
}
