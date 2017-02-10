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
@Table(name = "Personne")
public class Personne implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Personne_ID")
    private Integer personneID;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "NOM")
    private String nom;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "PRENOM")
    private String prenom;
    @Column(name = "ADRESSE")
    private String adresse;
    @Column
    private String niveau;
    
    
    public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "personne")
    private Collection<Emprunt> empruntCollection;

    public Personne() {
    }

    public Personne(Integer personneID) {
        this.personneID = personneID;
    }

    public Integer getPersonneID() {
        return personneID;
    }

    public void setPersonneID(Integer personneID) {
        this.personneID = personneID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }



    public void setEmpruntCollection(Collection<Emprunt> empruntCollection) {
        this.empruntCollection = empruntCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personneID != null ? personneID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personne)) {
            return false;
        }
        Personne other = (Personne) object;
        if ((this.personneID == null && other.personneID != null) || (this.personneID != null && !this.personneID.equals(other.personneID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.uvsq.datascale.modele.Personne[ personneID=" + personneID + " ]";
    }
    
}
