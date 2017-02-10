/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.uvsq.M2.Datascale.GestionMedia.Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "EMPRUNT")
public class Emprunt implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmpruntPK empruntPK;
    @Column(name = "DATE_EMPRUNT")
    @Temporal(TemporalType.DATE)
    private Date dateEmprunt= new Date();
    @Column(name = "DATE_PREVUE_RENDRE")
    @Temporal(TemporalType.DATE)
    private Date datePrevueRendre;
    @JoinColumn(name = "CODE", referencedColumnName = "CODE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Media media;
    @JoinColumn(name = "Personne_ID", referencedColumnName = "Personne_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Personne personne;

    public Emprunt() {
    }

    public Emprunt(EmpruntPK empruntPK) {
        this.empruntPK = empruntPK;
    }

   /** public Emprunt(String code, int personneID, Date date_emprunt, Date date_prevu) {
        this.empruntPK = new EmpruntPK(code, personneID);
        this.dateEmprunt=date_emprunt;
        this.datePrevueRendre=date_prevu;
    }**/
    
    public Emprunt( EmpruntPK empruntPK, Date date_emprunt, Date date_prevu) {
        this.empruntPK = empruntPK;
        this.dateEmprunt=date_emprunt;
        this.datePrevueRendre=date_prevu  ;
    }

    public EmpruntPK getEmpruntPK() {
        return empruntPK;
    }

    public void setEmpruntPK(EmpruntPK empruntPK) {
        this.empruntPK = empruntPK;
    }

    public Date getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(Date dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public Date getDatePrevueRendre() {
        return datePrevueRendre;
    }

    public void setDatePrevueRendre(Date datePrevueRendre) {
    	
        this.datePrevueRendre = datePrevueRendre;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empruntPK != null ? empruntPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emprunt)) {
            return false;
        }
        Emprunt other = (Emprunt) object;
        if ((this.empruntPK == null && other.empruntPK != null) || (this.empruntPK != null && !this.empruntPK.equals(other.empruntPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.uvsq.datascale.modele.Emprunt[ empruntPK=" + empruntPK + " ]";
    }
    
}
