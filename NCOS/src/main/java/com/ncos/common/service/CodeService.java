package com.ncos.common.service;

import java.util.List;
import java.util.Map;

import com.ncos.common.entity.Code;

public interface CodeService {

	public List<Code> getCodeList(Map<String,Object> param);
//	public int getCodeListCount(Map<String,Object> param);
//	public void saveCode(Code code);
//	public Code getCode(Map<String,Object> param);
//	public void deleteCode(Map<String,Object> param);
//	public List<String> getMasterCodeList();
//	public List<Code> getDetailCodeList(String masterCode);
}
