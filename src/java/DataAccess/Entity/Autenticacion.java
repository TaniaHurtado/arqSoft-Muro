/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author arqsoft2017i
 */
@Entity
@Table(name = "Autenticacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Autenticacion.findAll", query = "SELECT a FROM Autenticacion a")
    , @NamedQuery(name = "Autenticacion.findByAutenticacionContrasena", query = "SELECT a FROM Autenticacion a WHERE a.autenticacionContrasena = :autenticacionContrasena")
    , @NamedQuery(name = "Autenticacion.findByAutenticacionId", query = "SELECT a FROM Autenticacion a WHERE a.autenticacionId = :autenticacionId")})
public class Autenticacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 45)
    @Column(name = "autenticacion_contrasena")
    private String autenticacionContrasena;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "autenticacion_id")
    private Integer autenticacionId;
    @JoinColumn(name = "autenticacion_id", referencedColumnName = "usuario_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;

    public Autenticacion() {
    }

    public Autenticacion(Integer autenticacionId, String autenticacionContrasena) {
        this.autenticacionContrasena = autenticacionContrasena;
        this.autenticacionId = autenticacionId;
    }
    
    public String getAutenticacionContrasena() {
        return autenticacionContrasena;
    }

    public void setAutenticacionContrasena(String autenticacionContrasena) {
        this.autenticacionContrasena = autenticacionContrasena;
    }

    public Integer getAutenticacionId() {
        return autenticacionId;
    }

    public void setAutenticacionId(Integer autenticacionId) {
        this.autenticacionId = autenticacionId;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (autenticacionId != null ? autenticacionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autenticacion)) {
            return false;
        }
        Autenticacion other = (Autenticacion) object;
        if ((this.autenticacionId == null && other.autenticacionId != null) || (this.autenticacionId != null && !this.autenticacionId.equals(other.autenticacionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataAccess.Entity.Autenticacion[ autenticacionId=" + autenticacionId + " ]";
    }
    
}
