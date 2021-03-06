package com.web.model;
// Generated 13-mag-2018 22.29.48 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Fileuser___ generated by hbm2java
 */
@Entity
@Table(name="fileuser"
    ,catalog="test"
)
public class Fileuser___  implements java.io.Serializable {


     private Long codfile;
     private String titolo;
     private String descrizione;
     private Date data;
     private byte[] file;
     private Set<IduserIdfile> iduserIdfiles = new HashSet<IduserIdfile>(0);

    public Fileuser___() {
    }

	
    public Fileuser___(Date data) {
        this.data = data;
    }
    public Fileuser___(String titolo, String descrizione, Date data, byte[] file, Set<IduserIdfile> iduserIdfiles) {
       this.titolo = titolo;
       this.descrizione = descrizione;
       this.data = data;
       this.file = file;
       this.iduserIdfiles = iduserIdfiles;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="codfile", nullable=false)
    public Long getCodfile() {
        return this.codfile;
    }
    
    public void setCodfile(Long codfile) {
        this.codfile = codfile;
    }

    
    @Column(name="titolo", length=200)
    public String getTitolo() {
        return this.titolo;
    }
    
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    
    @Column(name="descrizione", length=200)
    public String getDescrizione() {
        return this.descrizione;
    }
    
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="data", nullable=false, length=19)
    public Date getData() {
        return this.data;
    }
    
    public void setData(Date data) {
        this.data = data;
    }

    
    @Column(name="file")
    public byte[] getFile() {
        return this.file;
    }
    
    public void setFile(byte[] file) {
        this.file = file;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="fileuser")
    public Set<IduserIdfile> getIduserIdfiles() {
        return this.iduserIdfiles;
    }
    
    public void setIduserIdfiles(Set<IduserIdfile> iduserIdfiles) {
        this.iduserIdfiles = iduserIdfiles;
    }




}


