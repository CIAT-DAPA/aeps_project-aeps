package org.aepscolombia.platform.models.entity;
// Generated Apr 8, 2014 9:37:27 AM by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Irrigation generated by hbm2java
 */
@Entity
@Table(name="irrigation")
public class Irrigation  implements java.io.Serializable {


     private Integer idIrr;
     private IrrigationsTypes irrigationsTypes;
     private ProductionEvents productionEvents;
     private WaterSourcesTypes waterSourcesTypes;
     private Date dateIrr;     
     private Boolean useIrrigationIrr;
     private Double amountIrr;     
     private BigDecimal costWaterIrr;
     private BigDecimal costWorkforceIrr;
     private BigDecimal costDitchesIrr;
     private BigDecimal costDrainageIrr;
     private BigDecimal costFuelIrr;
     private BigDecimal costElectricpowerIrr;
     private Boolean costRentedquestionIrr;
     private BigDecimal costDepreciationIrr;
     private BigDecimal costRentedIrr;
     private String commentIrr;
     private Boolean status;
     private Integer createdBy;     
     private Double thicknessSheetIrr;
     private Double durationIrr;
     private UseIrrigation whatDoYouUseIrr;
     private Date dateWetIrr;

    public Irrigation() {
    }

	
    public Irrigation(ProductionEvents productionEvents, Date dateIrr) {
        this.productionEvents = productionEvents;
        this.dateIrr = dateIrr;
    }
    public Irrigation(IrrigationsTypes irrigationsTypes, ProductionEvents productionEvents, WaterSourcesTypes waterSourcesTypes, Date dateIrr, Boolean useIrrigationIrr, Double amountIrr, BigDecimal costWaterIrr,BigDecimal costWorkforceIrr ,BigDecimal costDitchesIrr,BigDecimal costDrainageIrr,BigDecimal costFuelIrr,BigDecimal costElectricpowerIrr,Boolean costRentedquestionIrr,BigDecimal costDepreciationIrr,BigDecimal costRentedIrr,String commentIrr, Boolean status, Integer createdBy) {
       this.irrigationsTypes = irrigationsTypes;
       this.productionEvents = productionEvents;
       this.waterSourcesTypes = waterSourcesTypes;
       this.dateIrr = dateIrr;
       this.useIrrigationIrr = useIrrigationIrr;
       this.amountIrr = amountIrr;       
       this.costWaterIrr=costWaterIrr;
       this.costWorkforceIrr=costWorkforceIrr;
       this.costDitchesIrr=costDitchesIrr;
       this.costDrainageIrr=costDrainageIrr;
       this.costFuelIrr=costFuelIrr; 
       this.costElectricpowerIrr=costElectricpowerIrr;
       this.costRentedquestionIrr=costRentedquestionIrr;
       this.costDepreciationIrr=costDepreciationIrr;
       this.costRentedIrr=costRentedIrr;   
       this.commentIrr=commentIrr;
       this.status = status;
       this.createdBy = createdBy;
       
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id_irr", unique=true, nullable=false)
    public Integer getIdIrr() {
        return this.idIrr;
    }
    
    public void setIdIrr(Integer idIrr) {
        this.idIrr = idIrr;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="irrigation_type_irr")
    public IrrigationsTypes getIrrigationsTypes() {
        return this.irrigationsTypes;
    }
    
    public void setIrrigationsTypes(IrrigationsTypes irrigationsTypes) {
        this.irrigationsTypes = irrigationsTypes;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_production_event_irr", nullable=false)
    public ProductionEvents getProductionEvents() {
        return this.productionEvents;
    }
    
    public void setProductionEvents(ProductionEvents productionEvents) {
        this.productionEvents = productionEvents;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="water_source_irr")
    public WaterSourcesTypes getWaterSourcesTypes() {
        return this.waterSourcesTypes;
    }
    
    public void setWaterSourcesTypes(WaterSourcesTypes waterSourcesTypes) {
        this.waterSourcesTypes = waterSourcesTypes;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date_irr", nullable=false, length=19)
    public Date getDateIrr() {
        return this.dateIrr;
    }
    
    public void setDateIrr(Date dateIrr) {
        this.dateIrr = dateIrr;
    }
    
    @Column(name="use_irrigation_irr")
    public Boolean getUseIrrigationIrr() {
        return this.useIrrigationIrr;
    }
    
    public void setUseIrrigationIrr(Boolean useIrrigationIrr) {
        this.useIrrigationIrr = useIrrigationIrr;
    }
    
    @Column(name="amount_irr", precision=22, scale=0)
    public Double getAmountIrr() {
        return this.amountIrr;
    }
    
    public void setAmountIrr(Double amountIrr) {
        this.amountIrr = amountIrr;
    }

    /**
     Costos de agua
    */
       
    @Column(name="cost_water_irr")
    public BigDecimal getCostWaterIrr() {
        return this.costWaterIrr;
    }
    
    public void setCostWaterIrr(BigDecimal costWaterIrr) {
        this.costWaterIrr = costWaterIrr;
    }
    
    /**
     Costos de mano de obra
    */
    
    @Column(name="cost_workforce_irr")
    public BigDecimal getCostWorkforceIrr() {
        return this.costWorkforceIrr;
    }
    
    public void setCostWorkforceIrr(BigDecimal costWorkforceIrr) {
        this.costWorkforceIrr = costWorkforceIrr;
    }
    
    /**
     Costos de construccion de acequias de riego
    */
    
    @Column(name="cost_ditches_irr")
    public BigDecimal getCostDitchesIrr() {
        return this.costDitchesIrr;
    }
    
    public void setCostDitchesIrr(BigDecimal costDitchesIrr) {
        this.costDitchesIrr = costDitchesIrr;
    }
    /**
     Costos de construccion de canales de drenaje
    */
    @Column(name="cost_drainage_irr")
    public BigDecimal getCostDrainageIrr() {
        return this.costDrainageIrr;
    }
    
    public void setCostDrainageIrr(BigDecimal costDrainageIrr) {
        this.costDrainageIrr = costDrainageIrr;
    }
        
    /**
     Costos de combustible
    */
    @Column(name="cost_fuel_irr")
    public BigDecimal getCostFuelIrr() {
        return this.costFuelIrr;
    }
    
    public void setCostFuelIrr(BigDecimal costFuelIrr) {
        this.costFuelIrr = costFuelIrr;
    }
    
    /**
     Costos de energia electrica
    */
    @Column(name="cost_electricpower_irr")
    public BigDecimal getCostElectricpowerIrr() {
        return this.costElectricpowerIrr;
    }
    
    public void setCostElectricpowerIrr(BigDecimal costElectricpowerIrr) {
        this.costElectricpowerIrr = costElectricpowerIrr;
    }
    
    /**
     pregunta de renta de equipo de riego
    */
    @Column(name="cost_rentedquestion_irr")
    public Boolean getCostRentedquestionIrr() {
        return this.costRentedquestionIrr;
    }
    
    public void setCostRentedquestionIrr(Boolean costRentedquestionIrr) {
        this.costRentedquestionIrr = costRentedquestionIrr;
    }
    
    /**
     Costos de depresiacion de equipo de riego
    */
    @Column(name="cost_depreciation_irr")
    public BigDecimal getCostDepreciationIrr() {
        return this.costDepreciationIrr;
    }
    
    public void setCostDepreciationIrr(BigDecimal costDepreciationIrr) {
        this.costDepreciationIrr = costDepreciationIrr;
    }
    
    /**
     Costos de renta de equipo de riego por zona
    */
    @Column(name="cost_rented_irr")
    public BigDecimal getCostRentedIrr() {
        return this.costRentedIrr;
    }
    
    public void setCostRentedIrr(BigDecimal costRentedIrr) {
        this.costRentedIrr = costRentedIrr;
    }   
    
    /**
     Observaciones del riego aplicado al evento productivo
    */
    @Column(name="comment_irr")
    public String getCommentIrr() {
        return this.commentIrr;
    }
    
    public void setCommentIrr(String commentIrr) {
        this.commentIrr = commentIrr;
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
    
    @Column(name="thickness_sheet_irr", precision=22, scale=0)
    public Double getThicknessSheetIrr() {
        return this.thicknessSheetIrr;
    }
    
    public void setThicknessSheetIrr(Double thicknessSheetIrr) {
        this.thicknessSheetIrr = thicknessSheetIrr;
    }
    
    @Column(name="duration_irr")
    public Double getDurationIrr() {
        return this.durationIrr;
    }
    
    public void setDurationIrr(Double durationIrr) {
        this.durationIrr = durationIrr;
    }   

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="what_do_you_use_irr")
    public UseIrrigation getWhatDoYouUseIrr() {
        return this.whatDoYouUseIrr;
    }
    
    public void setWhatDoYouUseIrr(UseIrrigation whatDoYouUseIrr) {
        this.whatDoYouUseIrr = whatDoYouUseIrr;
    }
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date_wet_irr", length=19)
    public Date getDateWetIrr() {
        return this.dateWetIrr;
    }
    
    public void setDateWetIrr(Date dateWetIrr) {
        this.dateWetIrr = dateWetIrr;
    }

}


