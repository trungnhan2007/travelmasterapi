package com.example.ProjectTravelMaster.Model.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.List;

@Entity
@Table(name="hotel")
public class Hotel {
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int hsId;
    private String hsName;
    private String hsDetail;
    private String hsDescription;
    private String hsAddress;
    private String hsWard;
    private String hsDistrict;
    private String hsProvince;
    private String hsCountry;
    private String hsPostalcode;
    private Boolean hsStatus;
    private int enId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="enId", referencedColumnName = "enId", insertable = false, updatable = false)    
    @JsonBackReference
    private Enterprise enterprise;

    @OneToMany(mappedBy="hotel", cascade=CascadeType.ALL)
	private List<Room> room;

    public List<Room> getRoom() {
        return room;
    }
    public void setRoom(List<Room> room) {
        this.room = room;
    }
    public int getHsId() {
        return hsId;
    }
    public void setHsId(int hsId) {
        this.hsId = hsId;
    }
    public String getHsName() {
        return hsName;
    }
    public void setHsName(String hsName) {
        this.hsName = hsName;
    }
    public String getHsDetail() {
        return hsDetail;
    }
    public void setHsDetail(String hsDetail) {
        this.hsDetail = hsDetail;
    }
    public String getHsDescription() {
        return hsDescription;
    }
    public void setHsDescription(String hsDescription) {
        this.hsDescription = hsDescription;
    }
    public String getHsAddress() {
        return hsAddress;
    }
    public void setHsAddress(String hsAddress) {
        this.hsAddress = hsAddress;
    }
    public String getHsWard() {
        return hsWard;
    }
    public void setHsWard(String hsWard) {
        this.hsWard = hsWard;
    }
    public String getHsDistrict() {
        return hsDistrict;
    }
    public void setHsDistrict(String hsDistrict) {
        this.hsDistrict = hsDistrict;
    }
    public String getHsProvince() {
        return hsProvince;
    }
    public void setHsProvince(String hsProvince) {
        this.hsProvince = hsProvince;
    }
    public String getHsCountry() {
        return hsCountry;
    }
    public void setHsCountry(String hsCountry) {
        this.hsCountry = hsCountry;
    }
    public String getHsPostalcode() {
        return hsPostalcode;
    }
    public void setHsPostalcode(String hsPostalcode) {
        this.hsPostalcode = hsPostalcode;
    }
    public Boolean getHsStatus() {
        return hsStatus;
    }
    public void setHsStatus(Boolean hsStatus) {
        this.hsStatus = hsStatus;
    }
    public int getEnId() {
        return enId;
    }
    public void setEnId(int enId) {
        this.enId = enId;
    }

    











}
