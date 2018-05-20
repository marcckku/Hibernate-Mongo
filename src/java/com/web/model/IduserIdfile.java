package com.web.model;
// Generated 13-mag-2018 22.29.48 by Hibernate Tools 4.3.1


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * IduserIdfile generated by hbm2java
 */
@Entity
@Table(name="iduser_idfile"
    ,catalog="test"
)
public class IduserIdfile  implements java.io.Serializable {


     private IduserIdfileId id;
     private Fileuser__ fileuser;
     private User user;

    public IduserIdfile() {
    }

    public IduserIdfile(IduserIdfileId id, Fileuser__ fileuser, User user) {
       this.id = id;
       this.fileuser = fileuser;
       this.user = user;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="userId", column=@Column(name="userId", nullable=false) ), 
        @AttributeOverride(name="fileCod", column=@Column(name="fileCod", nullable=false) ) } )
    public IduserIdfileId getId() {
        return this.id;
    }
    
    public void setId(IduserIdfileId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fileCod", nullable=false, insertable=false, updatable=false)
    public Fileuser__ getFileuser() {
        return this.fileuser;
    }
    
    public void setFileuser(Fileuser__ fileuser) {
        this.fileuser = fileuser;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="userId", nullable=false, insertable=false, updatable=false)
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }




}


