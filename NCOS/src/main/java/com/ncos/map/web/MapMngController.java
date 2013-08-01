package com.ncos.map.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ncos.map.entity.MapInfo;
import com.ncos.map.service.MapMngService;
import com.ncos.utils.FileUtils;
import com.ncos.utils.TotalUtils;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
@RequestMapping("/map")
public class MapMngController {

	@Resource(name = "mapMngService")
	MapMngService mapMngService;
	
	@Value("#{ncos_prop['commonFilePath']}")
	public String commonFilePath;
	@Value("#{ncos_prop['mapFilePath']}")
	public String mapFilePath;
	
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
		param.put("p_mapName", request.getParameter("p_mapName"));
		param.put("p_offset", (paginationInfo.getCurrentPageNo()-1)*paginationInfo.getRecordCountPerPage());
		param.put("p_limit", paginationInfo.getRecordCountPerPage());
		
		List<MapInfo> mapInfoItems = mapMngService.getMapInfoList(param);
		int itemsCount = mapMngService.getMapInfoListCount(param);
		
		paginationInfo.setTotalRecordCount(itemsCount);
		mv.addObject("paginationInfo",paginationInfo);
		mv.addObject("mapInfoItems",mapInfoItems);
		mv.setViewName("map/list");
		return mv;
	}
	
	@RequestMapping("/createForm")
	public ModelAndView createForm(ModelAndView mv) throws Exception{
		mv.setViewName("map/createForm");
		return mv;
	}
	
	/**
	 * 맵 기본정보 저장
	 */
	@RequestMapping("/saveMapInfo")
	public ModelAndView saveMapInfo(ModelAndView mv, MapInfo mapInfo, final HttpServletRequest request) throws Exception{
		String uploadPath = commonFilePath+mapFilePath;
		String datePath = TotalUtils.getUploadPathByDate();
		uploadPath += datePath;
		
		FileUtils fu = new FileUtils();
    	List<Map<String, String>> fileInfoList = fu.upload(request, uploadPath);//파일업로드 처리
    	
    	mapInfo.setFilePath(mapFilePath+datePath+"/"+fileInfoList.get(0).get("newFileName"));
    	Integer mapid = mapMngService.saveMapInfo(mapInfo);
    	
    	mv.setViewName("redirect:createField?mapid="+mapid);
		return mv;
	}
	
	@RequestMapping("/createField")
	public ModelAndView createField(ModelAndView mv, @RequestParam(required=true) Integer mapid) throws Exception{
		MapInfo mapInfo = mapMngService.getMapInfo(mapid);
		mv.addObject("mapInfo",mapInfo);
		mv.setViewName("map/createField");
		return mv;
	}
}
