package com.ncos.common.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="sa_code")
public class Code implements Serializable{

	@EmbeddedId
	private CodePK codeId;
	
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

//	public CodePK getCodeId() {
//		return codeId;
//	}
//
//	public void setCodeId(CodePK codeId) {
//		this.codeId = codeId;
//	}
	
	public String getMasterCode(){
		return codeId.getMasterCode();
	}
	public String getDetailCode(){
		return codeId.getDetailCode();
	}
	
	
}
