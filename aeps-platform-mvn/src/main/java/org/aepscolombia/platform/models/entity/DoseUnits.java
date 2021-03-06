package org.aepscolombia.platform.models.entity;
// Generated Apr 8, 2014 9:37:27 AM by Hibernate Tools 3.2.1.GA


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * DoseUnits generated by hbm2java
 */
@Entity
@Table(name="dose_units")
public class DoseUnits  implements java.io.Serializable {


     private Integer idDosUni;
     private String nameDosUni;
     private Boolean statusDosUni;
     private IdiomCountry countryDosUni;

    public DoseUnits() {
    }

    public DoseUnits(Integer idDosUni) {
        this.idDosUni = idDosUni;
    }
	
    public DoseUnits(String nameDosUni) {
        this.nameDosUni = nameDosUni;
    }
    public DoseUnits(String nameDosUni, Boolean statusDosUni) {
       this.nameDosUni = nameDosUni;
       this.statusDosUni = statusDosUni;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id_dos_uni", unique=true, nullable=false)
    public Integer getIdDosUni() {
        return this.idDosUni;
    }
    
    public void setIdDosUni(Integer idDosUni) {
        this.idDosUni = idDosUni;
    }
    
    @Column(name="name_dos_uni", nullable=false, length=45)
    public String getNameDosUni() {
        return this.nameDosUni;
    }
    
    public void setNameDosUni(String nameDosUni) {
        this.nameDosUni = nameDosUni;
    }
    
    @Column(name="status_dos_uni")
    public Boolean getStatusDosUni() {
        return this.statusDosUni;
    }
    
    public void setStatusDosUni(Boolean statusDosUni) {
        this.statusDosUni = statusDosUni;
    }
    
    @ManyToOne
    @JoinColumn(name="country_dos_uni")
    public IdiomCountry getCountryDosUni() {
        return this.countryDosUni;
    }
    
    public void setCountryDosUni(IdiomCountry countryDosUni) {
        this.countryDosUni = countryDosUni;
    }
    
}


