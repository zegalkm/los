package com.ncos.common.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CodePK implements Serializable{

	@Column(name="master_code")
	public String masterCode;
	@Column(name="detail_code")
	public String detailCode;
	
	public String getMasterCode() {
		return masterCode;
	}
	public void setMasterCode(String masterCode) {
		this.masterCode = masterCode;
	}
	public String getDetailCode() {
		return detailCode;
	}
	public void setDetailCode(String detailCode) {
		this.detailCode = detailCode;
	}
	
	
}
