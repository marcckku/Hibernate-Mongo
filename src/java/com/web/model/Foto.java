package com.web.model;
// Generated 13-mag-2018 22.29.48 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Foto generated by hbm2java
 */
@Entity
@Table(name="foto"
    ,catalog="test"
)
public class Foto  implements java.io.Serializable {


     private Integer id;
     private String titolo;
     private byte[] foto;

    public Foto() {
    }

    public Foto(String titolo, byte[] foto) {
       this.titolo = titolo;
       this.foto = foto;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="Id", nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="Titolo", nullable=false, length=100)
    public String getTitolo() {
        return this.titolo;
    }
    
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    
    @Column(name="Foto", nullable=false)
    public byte[] getFoto() {
        return this.foto;
    }
    
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }




}


