package org.aepscolombia.platform.models.entity;
// Generated Jan 21, 2014 11:35:29 AM by Hibernate Tools 3.2.1.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Statistics generated by hbm2java
 */
@Entity
@Table(name="statistics"
    ,catalog="madr_bd10"
    , uniqueConstraints = @UniqueConstraint(columnNames="id_crop_stat") 
)
public class Statistics  implements java.io.Serializable {


     private Integer idStat;
     private ProductionEvents productionEvents;
     private String productionStat;
     private String yearStat;

    public Statistics() {
    }

	
    public Statistics(ProductionEvents productionEvents) {
        this.productionEvents = productionEvents;
    }
    public Statistics(ProductionEvents productionEvents, String productionStat, String yearStat) {
       this.productionEvents = productionEvents;
       this.productionStat = productionStat;
       this.yearStat = yearStat;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id_stat", unique=true, nullable=false)
    public Integer getIdStat() {
        return this.idStat;
    }
    
    public void setIdStat(Integer idStat) {
        this.idStat = idStat;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_crop_stat", unique=true, nullable=false)
    public ProductionEvents getProductionEvents() {
        return this.productionEvents;
    }
    
    public void setProductionEvents(ProductionEvents productionEvents) {
        this.productionEvents = productionEvents;
    }
    
    @Column(name="production_stat", length=45)
    public String getProductionStat() {
        return this.productionStat;
    }
    
    public void setProductionStat(String productionStat) {
        this.productionStat = productionStat;
    }
    
    @Column(name="year_stat", length=45)
    public String getYearStat() {
        return this.yearStat;
    }
    
    public void setYearStat(String yearStat) {
        this.yearStat = yearStat;
    }




}

