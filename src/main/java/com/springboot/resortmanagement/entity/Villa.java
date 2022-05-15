package com.springboot.resortmanagement.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "villa")
public class Villa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "villa_id")
    private Integer villaId;

    @NotNull(message = "villa No should not be null")
    @Column(name = "villa_no")
    private Integer villaNo;

    @NotNull(message = "street No should not be null")
    @Column(name = "street_no")
    private Integer streetNo;


    @ManyToOne
    @JoinColumn(name = "resort_resort_id")
    private Resort resort;

    public Villa(){

    }

    public Villa(Integer villaNo, Integer streetNo) {
        this.villaNo = villaNo;
        this.streetNo = streetNo;
    }

    public Integer getVillaId() {
        return villaId;
    }

    public void setVillaId(Integer villaId) {
        this.villaId = villaId;
    }

    public Integer getVillaNo() {
        return villaNo;
    }

    public void setVillaNo(Integer villaNo) {
        this.villaNo = villaNo;
    }

    public Integer getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(Integer streetNo) {
        this.streetNo = streetNo;
    }

    public Resort getResort() {
        return resort;
    }

    public void setResort(Resort resort) {
        this.resort = resort;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "villaId=" + villaId +
                ", villaNo=" + villaNo +
                ", streetNo=" + streetNo +
                ", resort=" + resort +
                '}';
    }
}
