/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.uvsq.M2.Datascale.GestionMedia.Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class EmpruntPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "CODE")
    private String code;
    @Basic(optional = false)
    @Column(name = "Personne_ID")
    private int personneID;

    public EmpruntPK() {
    }

    public EmpruntPK(String code, int personneID) {
        this.code = code;
        this.personneID = personneID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getPersonneID() {
        return personneID;
    }

    public void setPersonneID(int personneID) {
        this.personneID = personneID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        hash += (int) personneID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpruntPK)) {
            return false;
        }
        EmpruntPK other = (EmpruntPK) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        if (this.personneID != other.personneID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.uvsq.datascale.modele.EmpruntPK[ code=" + code + ", personneID=" + personneID + " ]";
    }
    
}
