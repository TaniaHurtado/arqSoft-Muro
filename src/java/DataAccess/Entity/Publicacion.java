/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author arqsoft2017i
 */
@Entity
@Table(name = "Publicacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Publicacion.findAll", query = "SELECT p FROM Publicacion p")
    , @NamedQuery(name = "Publicacion.findByPublicacionId", query = "SELECT p FROM Publicacion p WHERE p.publicacionId = :publicacionId")
    , @NamedQuery(name = "Publicacion.findByPublicacionFecha", query = "SELECT p FROM Publicacion p WHERE p.publicacionFecha = :publicacionFecha")
    , @NamedQuery(name = "Publicacion.findByPublicacionContenido", query = "SELECT p FROM Publicacion p WHERE p.publicacionContenido = :publicacionContenido")})
public class Publicacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "publicacion_id")
    private Integer publicacionId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "publicacion_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date publicacionFecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "publicacion_contenido")
    private String publicacionContenido;
    @JoinColumn(name = "publicacion_usuario_id", referencedColumnName = "usuario_id")
    @ManyToOne(optional = false)
    private Usuario publicacionUsuarioId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comentarioPublicacionId")
    private Collection<Comentario> comentarioCollection;

    public Publicacion() {
    }

    public Publicacion(Integer publicacionId) {
        this.publicacionId = publicacionId;
    }

    public Publicacion(Integer publicacionId, Date publicacionFecha, String publicacionContenido) {
        this.publicacionId = publicacionId;
        this.publicacionFecha = publicacionFecha;
        this.publicacionContenido = publicacionContenido;
    }

    public Integer getPublicacionId() {
        return publicacionId;
    }

    public void setPublicacionId(Integer publicacionId) {
        this.publicacionId = publicacionId;
    }

    public Date getPublicacionFecha() {
        return publicacionFecha;
    }

    public void setPublicacionFecha(Date publicacionFecha) {
        this.publicacionFecha = publicacionFecha;
    }

    public String getPublicacionContenido() {
        return publicacionContenido;
    }

    public void setPublicacionContenido(String publicacionContenido) {
        this.publicacionContenido = publicacionContenido;
    }

    public Usuario getPublicacionUsuarioId() {
        return publicacionUsuarioId;
    }

    public void setPublicacionUsuarioId(Usuario publicacionUsuarioId) {
        this.publicacionUsuarioId = publicacionUsuarioId;
    }

    @XmlTransient
    public Collection<Comentario> getComentarioCollection() {
        return comentarioCollection;
    }

    public void setComentarioCollection(Collection<Comentario> comentarioCollection) {
        this.comentarioCollection = comentarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (publicacionId != null ? publicacionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Publicacion)) {
            return false;
        }
        Publicacion other = (Publicacion) object;
        if ((this.publicacionId == null && other.publicacionId != null) || (this.publicacionId != null && !this.publicacionId.equals(other.publicacionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataAccess.Entity.Publicacion[ publicacionId=" + publicacionId + " ]";
    }
    
}
