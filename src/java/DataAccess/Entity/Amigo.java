/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author arqsoft2017i
 */
@Entity
@Table(name = "Amigo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Amigo.findAll", query = "SELECT a FROM Amigo a")
    , @NamedQuery(name = "Amigo.findByAmigoFecha", query = "SELECT a FROM Amigo a WHERE a.amigoFecha = :amigoFecha")
    , @NamedQuery(name = "Amigo.findByAmigoIdA", query = "SELECT a FROM Amigo a WHERE a.amigoPK.amigoIdA = :amigoIdA")
    , @NamedQuery(name = "Amigo.findByAmigoIdB", query = "SELECT a FROM Amigo a WHERE a.amigoPK.amigoIdB = :amigoIdB")})
public class Amigo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AmigoPK amigoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amigo_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date amigoFecha;
    @JoinColumn(name = "amigo_id_a", referencedColumnName = "usuario_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "amigo_id_b", referencedColumnName = "usuario_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario1;

    public Amigo() {
    }

    public Amigo(AmigoPK amigoPK) {
        this.amigoPK = amigoPK;
    }

    public Amigo(AmigoPK amigoPK, Date amigoFecha) {
        this.amigoPK = amigoPK;
        this.amigoFecha = amigoFecha;
    }

    public Amigo(int amigoIdA, int amigoIdB) {
        this.amigoPK = new AmigoPK(amigoIdA, amigoIdB);
    }

    public AmigoPK getAmigoPK() {
        return amigoPK;
    }

    public void setAmigoPK(AmigoPK amigoPK) {
        this.amigoPK = amigoPK;
    }

    public Date getAmigoFecha() {
        return amigoFecha;
    }

    public void setAmigoFecha(Date amigoFecha) {
        this.amigoFecha = amigoFecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(Usuario usuario1) {
        this.usuario1 = usuario1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (amigoPK != null ? amigoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Amigo)) {
            return false;
        }
        Amigo other = (Amigo) object;
        if ((this.amigoPK == null && other.amigoPK != null) || (this.amigoPK != null && !this.amigoPK.equals(other.amigoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataAccess.Entity.Amigo[ amigoPK=" + amigoPK + " ]";
    }
    
}
