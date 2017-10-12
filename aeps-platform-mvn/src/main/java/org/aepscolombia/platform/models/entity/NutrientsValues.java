package org.aepscolombia.platform.models.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * NutrientsValues generated by hbm2java
 */
@Entity
@Table(name="nutrients_values")
public class NutrientsValues  implements java.io.Serializable {


     private Integer idNuVal;
     private Departments departments;
     private CropsTypes cropsTypes;
     private Integer nitrogenNuVal;
     private Integer phosphorusNuVal;
     private Integer potassiumNuVal;
     private Integer sulfurNuVal;
     private Integer magnesiumNuVal;
     private Integer zincNuVal;
     private Integer boronNuVal;

    public NutrientsValues() {
    }

    public NutrientsValues(Departments departments, CropsTypes cropsTypes, Integer nitrogenNuVal, Integer phosphorusNuVal, Integer potassiumNuVal, Integer sulfurNuVal, Integer magnesiumNuVal, Integer zincNuVal, Integer boronNuVal) {
       this.departments = departments;
       this.cropsTypes = cropsTypes;
       this.nitrogenNuVal = nitrogenNuVal;
       this.phosphorusNuVal = phosphorusNuVal;
       this.potassiumNuVal = potassiumNuVal;
       this.sulfurNuVal = sulfurNuVal;
       this.magnesiumNuVal = magnesiumNuVal;
       this.zincNuVal = zincNuVal;
       this.boronNuVal = boronNuVal;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id_nu_val", unique=true, nullable=false)
    public Integer getIdNuVal() {
        return this.idNuVal;
    }
    
    public void setIdNuVal(Integer idNuVal) {
        this.idNuVal = idNuVal;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="departments_nu_val")
    public Departments getDepartments() {
        return this.departments;
    }
    
    public void setDepartments(Departments departments) {
        this.departments = departments;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="crop_type_nu_val")
    public CropsTypes getCropsTypes() {
        return this.cropsTypes;
    }
    
    public void setCropsTypes(CropsTypes cropsTypes) {
        this.cropsTypes = cropsTypes;
    }

    
    @Column(name="nitrogen_nu_val")
    public Integer getNitrogenNuVal() {
        return this.nitrogenNuVal;
    }
    
    public void setNitrogenNuVal(Integer nitrogenNuVal) {
        this.nitrogenNuVal = nitrogenNuVal;
    }

    
    @Column(name="phosphorus_nu_val")
    public Integer getPhosphorusNuVal() {
        return this.phosphorusNuVal;
    }
    
    public void setPhosphorusNuVal(Integer phosphorusNuVal) {
        this.phosphorusNuVal = phosphorusNuVal;
    }

    
    @Column(name="potassium_nu_val")
    public Integer getPotassiumNuVal() {
        return this.potassiumNuVal;
    }
    
    public void setPotassiumNuVal(Integer potassiumNuVal) {
        this.potassiumNuVal = potassiumNuVal;
    }

    
    @Column(name="sulfur_nu_val")
    public Integer getSulfurNuVal() {
        return this.sulfurNuVal;
    }
    
    public void setSulfurNuVal(Integer sulfurNuVal) {
        this.sulfurNuVal = sulfurNuVal;
    }

    
    @Column(name="magnesium_nu_val")
    public Integer getMagnesiumNuVal() {
        return this.magnesiumNuVal;
    }
    
    public void setMagnesiumNuVal(Integer magnesiumNuVal) {
        this.magnesiumNuVal = magnesiumNuVal;
    }

    
    @Column(name="zinc_nu_val")
    public Integer getZincNuVal() {
        return this.zincNuVal;
    }
    
    public void setZincNuVal(Integer zincNuVal) {
        this.zincNuVal = zincNuVal;
    }

    
    @Column(name="boron_nu_val")
    public Integer getBoronNuVal() {
        return this.boronNuVal;
    }
    
    public void setBoronNuVal(Integer boronNuVal) {
        this.boronNuVal = boronNuVal;
    }

}