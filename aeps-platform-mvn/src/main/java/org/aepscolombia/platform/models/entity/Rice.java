package org.aepscolombia.platform.models.entity;
// Generated Apr 8, 2014 9:37:27 AM by Hibernate Tools 3.2.1.GA


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
 * Rice generated by hbm2java
 */
@Entity
@Table(name="rice")
public class Rice  implements java.io.Serializable {


     private Integer idRi;
     private RiceSystem riceSystem;
     private ProductionEvents productionEvents;
     private Boolean status;
     private Integer createdBy;

    public Rice() {
    }

	
    public Rice(ProductionEvents productionEvents) {
        this.productionEvents = productionEvents;
    }
    public Rice(RiceSystem riceSystem, ProductionEvents productionEvents, Boolean status, Integer createdBy) {
       this.riceSystem = riceSystem;
       this.productionEvents = productionEvents;
       this.status = status;
       this.createdBy = createdBy;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id_ri", unique=true, nullable=false)
    public Integer getIdRi() {
        return this.idRi;
    }
    
    public void setIdRi(Integer idRi) {
        this.idRi = idRi;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="crop_system_ri")
    public RiceSystem getRiceSystem() {
        return this.riceSystem;
    }
    
    public void setRiceSystem(RiceSystem riceSystem) {
        this.riceSystem = riceSystem;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_production_event_ri", nullable=false)
    public ProductionEvents getProductionEvents() {
        return this.productionEvents;
    }
    
    public void setProductionEvents(ProductionEvents productionEvents) {
        this.productionEvents = productionEvents;
    }
    
    @Column(name="status")
    public Boolean getStatus() {
        return this.status;
    }
    
    public void setStatus(Boolean status) {
        this.status = status;
    }
    
    @Column(name="created_by")
    public Integer getCreatedBy() {
        return this.createdBy;
    }
    
    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }




}


