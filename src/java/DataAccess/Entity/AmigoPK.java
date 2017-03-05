/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author arqsoft2017i
 */
@Embeddable
public class AmigoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "amigo_id_a")
    private int amigoIdA;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amigo_id_b")
    private int amigoIdB;

    public AmigoPK() {
    }

    public AmigoPK(int amigoIdA, int amigoIdB) {
        this.amigoIdA = amigoIdA;
        this.amigoIdB = amigoIdB;
    }

    public int getAmigoIdA() {
        return amigoIdA;
    }

    public void setAmigoIdA(int amigoIdA) {
        this.amigoIdA = amigoIdA;
    }

    public int getAmigoIdB() {
        return amigoIdB;
    }

    public void setAmigoIdB(int amigoIdB) {
        this.amigoIdB = amigoIdB;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) amigoIdA;
        hash += (int) amigoIdB;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmigoPK)) {
            return false;
        }
        AmigoPK other = (AmigoPK) object;
        if (this.amigoIdA != other.amigoIdA) {
            return false;
        }
        if (this.amigoIdB != other.amigoIdB) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataAccess.Entity.AmigoPK[ amigoIdA=" + amigoIdA + ", amigoIdB=" + amigoIdB + " ]";
    }
    
}
