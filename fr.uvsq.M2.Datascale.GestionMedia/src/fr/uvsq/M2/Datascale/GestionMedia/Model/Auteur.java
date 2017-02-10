/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.uvsq.M2.Datascale.GestionMedia.Model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "AUTEUR")
public class Auteur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AUTEUR_ID")
    private Integer auteurId;
    @Column(name = "NOM")
    private String nom;
    @Column(name = "PRENOM")
    private String prenom;
   //@OneToMany(cascade = CascadeType.ALL, mappedBy = "auteur")
    //private Collection<Ecrit> ecritCollection;

    public Auteur() {
    }

    public Auteur(Integer auteurId) {
        this.auteurId = auteurId;
    }

    public Integer getAuteurId() {
        return auteurId;
    }

    public void setAuteurId(Integer auteurId) {
        this.auteurId = auteurId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

   

   // public void setEcritCollection(Collection<Ecrit> ecritCollection) {
      //  this.ecritCollection = ecritCollection;
   // }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (auteurId != null ? auteurId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auteur)) {
            return false;
        }
        Auteur other = (Auteur) object;
        if ((this.auteurId == null && other.auteurId != null) || (this.auteurId != null && !this.auteurId.equals(other.auteurId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.uvsq.datascale.modele.Auteur[ auteurId=" + auteurId + " ]";
    }
    
}
