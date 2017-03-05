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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author arqsoft2017i
 */
@Entity
@Table(name = "Comentario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comentario.findAll", query = "SELECT c FROM Comentario c")
    , @NamedQuery(name = "Comentario.findByComentarioId", query = "SELECT c FROM Comentario c WHERE c.comentarioId = :comentarioId")
    , @NamedQuery(name = "Comentario.findByComentarioFecha", query = "SELECT c FROM Comentario c WHERE c.comentarioFecha = :comentarioFecha")
    , @NamedQuery(name = "Comentario.findByComentarioContenido", query = "SELECT c FROM Comentario c WHERE c.comentarioContenido = :comentarioContenido")})
public class Comentario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "comentario_id")
    private Integer comentarioId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "comentario_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date comentarioFecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "comentario_contenido")
    private String comentarioContenido;
    @JoinColumn(name = "comentario_publicacion_id", referencedColumnName = "publicacion_id")
    @ManyToOne(optional = false)
    private Publicacion comentarioPublicacionId;
    @JoinColumn(name = "comentario_usuario_id", referencedColumnName = "usuario_id")
    @ManyToOne(optional = false)
    private Usuario comentarioUsuarioId;

    public Comentario() {
    }

    public Comentario(Integer comentarioId) {
        this.comentarioId = comentarioId;
    }

    public Comentario(Integer comentarioId, Date comentarioFecha, String comentarioContenido) {
        this.comentarioId = comentarioId;
        this.comentarioFecha = comentarioFecha;
        this.comentarioContenido = comentarioContenido;
    }

    public Integer getComentarioId() {
        return comentarioId;
    }

    public void setComentarioId(Integer comentarioId) {
        this.comentarioId = comentarioId;
    }

    public Date getComentarioFecha() {
        return comentarioFecha;
    }

    public void setComentarioFecha(Date comentarioFecha) {
        this.comentarioFecha = comentarioFecha;
    }

    public String getComentarioContenido() {
        return comentarioContenido;
    }

    public void setComentarioContenido(String comentarioContenido) {
        this.comentarioContenido = comentarioContenido;
    }

    public Publicacion getComentarioPublicacionId() {
        return comentarioPublicacionId;
    }

    public void setComentarioPublicacionId(Publicacion comentarioPublicacionId) {
        this.comentarioPublicacionId = comentarioPublicacionId;
    }

    public Usuario getComentarioUsuarioId() {
        return comentarioUsuarioId;
    }

    public void setComentarioUsuarioId(Usuario comentarioUsuarioId) {
        this.comentarioUsuarioId = comentarioUsuarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comentarioId != null ? comentarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comentario)) {
            return false;
        }
        Comentario other = (Comentario) object;
        if ((this.comentarioId == null && other.comentarioId != null) || (this.comentarioId != null && !this.comentarioId.equals(other.comentarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataAccess.Entity.Comentario[ comentarioId=" + comentarioId + " ]";
    }
    
}
