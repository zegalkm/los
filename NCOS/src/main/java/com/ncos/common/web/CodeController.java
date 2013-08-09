package com.ncos.common.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ncos.common.entity.Code;
import com.ncos.common.entity.CodePK;
import com.ncos.common.service.CodeService;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
@RequestMapping("/common/code")
public class CodeController {

	@Autowired
	private CodeService codeService;
	
	@RequestMapping("/list")
	public ModelAndView list(ModelAndView mv, 
							 @RequestParam(value="currentPageNo",required=false) Integer currentPageNo,			
							 HttpServletRequest request) throws Exception{
		PaginationInfo paginationInfo = new PaginationInfo();
		if(currentPageNo==null){
			paginationInfo.setCurrentPageNo(1); //현재 페이지 번호
		}else{
			paginationInfo.setCurrentPageNo(currentPageNo); //현재 페이지 번호
		}
		paginationInfo.setRecordCountPerPage(10); //한 페이지에 게시되는 게시물 건수
		paginationInfo.setPageSize(10); //페이징 리스트의 사이즈
		
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("p_keyword", request.getParameter("p_keyword"));
		param.put("p_offset", (paginationInfo.getCurrentPageNo()-1)*paginationInfo.getRecordCountPerPage());
		param.put("p_limit", paginationInfo.getRecordCountPerPage());
		
		List<Code> items = codeService.getCodeList(param);
//		int itemsCount = codeService.getCodeListCount(param);
		
//		paginationInfo.setTotalRecordCount(itemsCount);
		mv.addObject("paginationInfo",paginationInfo);
		mv.addObject("items",items);
		mv.setViewName("common/code/list");
		return mv;
	}
	
	@RequestMapping("/createForm")
	public ModelAndView createForm(ModelAndView mv) throws Exception{
		List<String> masterCodeList = codeService.getMasterCodeList();
		mv.addObject("masterCodeList",masterCodeList);
		mv.setViewName("common/code/createForm");
		return mv;
	}
	
	@RequestMapping("/ajax/detailCodeList")
	public @ResponseBody ModelMap detailCodeList(ModelMap map, @RequestParam(value="masterCode") String masterCode) throws Exception{
		List<Code> detailCodeItems = codeService.getDetailCodeList(masterCode);
		map.addAttribute("detailCodeItems", detailCodeItems);
		return map;
	}
	
	@RequestMapping("/saveCode")
	public ModelAndView saveCode(ModelAndView mv, Code code, HttpServletRequest request) throws Exception{
		CodePK codePK = new CodePK();
		codePK.setMasterCode(request.getParameter("masterCode"));
		codePK.setDetailCode(request.getParameter("detailCode"));
		code.setCodeId(codePK);
		codeService.saveCode(code);
		mv.setViewName("redirect:list");
		return mv;
	}
}
