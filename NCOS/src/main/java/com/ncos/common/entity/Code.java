package com.ncos.common.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="sa_code")
@IdClass(CodePK.class)
public class Code{

//	@EmbeddedId
//	private CodePK codeId;
	@Id
	@Column(name="master_code")
	private String masterCode;

	@Id
	@Column(name="detail_code")
	private String detailCode;
	
	@Column(name="code_name")
	private String codeName;
	
	@Column(name="sort_num")
	private Integer sortNum;
	
	@Column(name="code_desc")
	private String codeDesc;

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public Integer getSortNum() {
		return sortNum;
	}

	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}

	public String getCodeDesc() {
		return codeDesc;
	}

	public void setCodeDesc(String codeDesc) {
		this.codeDesc = codeDesc;
	}

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
