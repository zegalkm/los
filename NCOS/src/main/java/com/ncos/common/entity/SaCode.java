package com.ncos.common.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="kk_sajo")
public class SaCode{

//	@EmbeddedId
//	private CodePK codeId;
	@Id
	@Column(name="master_code")
	private String masterCode;

//	@Id
	@Column(name="detail_code")
	private String detailCode;
	

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
