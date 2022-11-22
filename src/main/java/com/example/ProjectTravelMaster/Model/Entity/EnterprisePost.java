package com.example.ProjectTravelMaster.Model.Entity;

import java.util.List;

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

@Entity
@Table(name = "enterprise_post")
public class EnterprisePost {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int epId;
	
	private String epName;
	private String epDetail;
	private String epDescription;
	private String enId;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="enId", referencedColumnName = "enId", insertable = false, updatable = false)    
    @JsonBackReference
    private Enterprise enterprise;
	
	@OneToMany(mappedBy="enterprise_post", cascade=CascadeType.ALL)
	private List<EnterprisePostComment> enterprise_post_comment;
	
	@OneToMany(mappedBy="enterprise_post", cascade=CascadeType.ALL)
	private List<EnterprisePostImage> enterprise_post_image;
		
	public int getEpId() {
		return epId;
	}
	public void setEpId(int epId) {
		this.epId = epId;
	}
	public String getEpName() {
		return epName;
	}
	public void setEpName(String epName) {
		this.epName = epName;
	}
	public String getEpDetail() {
		return epDetail;
	}
	public void setEpDetail(String epDetail) {
		this.epDetail = epDetail;
	}
	public String getEpDescription() {
		return epDescription;
	}
	public void setEpDescription(String epDescription) {
		this.epDescription = epDescription;
	}
	public String getEnId() {
		return enId;
	}
	public void setEnId(String enId) {
		this.enId = enId;
	}
	
	public List<EnterprisePostImage> getEnterprise_post_image() {
		return enterprise_post_image;
	}
	public void setEnterprise_post_image(List<EnterprisePostImage> enterprise_post_image) {
		this.enterprise_post_image = enterprise_post_image;
	}
	public List<EnterprisePostComment> getEnterprise_post_comment() {
		return enterprise_post_comment;
	}
	public void setEnterprise_post_comment(List<EnterprisePostComment> enterprise_post_comment) {
		this.enterprise_post_comment = enterprise_post_comment;
	}
	
	
}
