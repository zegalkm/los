package com.ncos.common.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncos.common.dao.CodeDao;
import com.ncos.common.entity.Code;
import com.ncos.common.service.CodeService;

@Service("codeService")
public class CodeServiceImpl implements CodeService{

	@Autowired
	private CodeDao codeDao;
	
	@Override
	public List<Code> getCodeList(Map<String, Object> param) {
		return codeDao.getCodeList(param);
	}

	@Override
	public int getCodeListCount(Map<String, Object> param) {
		return codeDao.getCodeListCount(param);
	}

	@Override
	public void saveCode(Code code) {
		codeDao.saveCode(code);
	}

	@Override
	public Code getCode(Map<String, Object> param) {
		return codeDao.getCode(param);
	}

	@Override
	public void deleteCode(Map<String, Object> param) {
		codeDao.deleteCode(param);
	}

	@Override
	public List<String> getMasterCodeList() {
		return codeDao.getMasterCodeList();
	}

	@Override
	public List<Code> getDetailCodeList(String masterCode) {
		return codeDao.getDetailCodeList(masterCode);
	}

	@Override
	public void updateCode(Code code) {
		codeDao.updateCode(code);
	}
}
