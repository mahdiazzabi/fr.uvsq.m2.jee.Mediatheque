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
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "MEDIA")

public class Media implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODE")
    private String code;
    @Column(name = "STOCK")
    private Integer stock;
    @Column(name = "TITRE")
    private String titre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "media")
    private Collection<Emprunt> empruntCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "media")
    private Disque disque;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "media")
    private Livre livre;

    public Media() {
    }

    public Media(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    

    public void setEmpruntCollection(Collection<Emprunt> empruntCollection) {
        this.empruntCollection = empruntCollection;
    }

    public Disque getDisque() {
        return disque;
    }

    public void setDisque(Disque disque) {
        this.disque = disque;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Media)) {
            return false;
        }
        Media other = (Media) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.uvsq.datascale.modele.Media[ code=" + code + " ]";
    }
    
}
