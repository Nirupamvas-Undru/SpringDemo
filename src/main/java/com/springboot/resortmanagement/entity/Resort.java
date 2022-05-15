package com.springboot.resortmanagement.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "resort")
public class Resort {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resort_id")
    private int resortId;
    @NotEmpty(message = "Resort Name can not be empty!!")
    @NotNull(message = "Resort Name should not be null")
    @Column(name = "resort_name")
    private String resortName;

    @NotEmpty(message = "Resort Address can not be empty!!")
    @NotNull(message = "Resort Address should not be null")
    @Column(name = "resort_address")
    private String resortAddress;

    @NotNull(message = "Resort Rating should not be null")
    @Column(name = "resort_rating")
    private Double resortRating;

    @OneToMany(mappedBy = "resort", cascade = CascadeType.ALL)
    private List<Villa> villas;

    @OneToMany(mappedBy = "resort", cascade = CascadeType.ALL)
    private List<Customer> customers;

    public Resort(){

    }

    public Resort(String resortName, String resortAddress, Double resortRating) {
        this.resortName = resortName;
        this.resortAddress = resortAddress;
        this.resortRating = resortRating;
    }

    public int getResortId() {
        return resortId;
    }

    public void setResortId(int resortId) {
        this.resortId = resortId;
    }

    public String getResortName() {
        return resortName;
    }

    public void setResortName(String resortName) {
        this.resortName = resortName;
    }

    public String getResortAddress() {
        return resortAddress;
    }

    public void setResortAddress(String resortAddress) {
        this.resortAddress = resortAddress;
    }

    public Double getResortRating() {
        return resortRating;
    }

    public void setResortRating(Double resortRating) {
        this.resortRating = resortRating;
    }

    public List<Villa> getVilla() {
        return villas;
    }

    public void setVilla(List<Villa> villas) {
        this.villas = villas;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Resort{" +
                "resortId=" + resortId +
                ", resortName='" + resortName + '\'' +
                ", resortAddress='" + resortAddress + '\'' +
                ", resortRating=" + resortRating +
                '}';
    }
}
