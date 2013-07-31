package com.ncos.map.web;

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

@Controller
@RequestMapping("/map")
public class MapMngController {

	@Resource(name = "mapMngService")
	MapMngService mapMngService;
	
	@Value("#{ncos_prop['mapFilePath']}")
	public String mapFilePath;
	
	@RequestMapping("/list")
	public ModelAndView list(ModelAndView mv) throws Exception{
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
		String uploadPath = mapFilePath;
		uploadPath += TotalUtils.getUploadPathByDate();
		
		FileUtils fu = new FileUtils();
    	List<Map<String, String>> fileInfoList = fu.upload(request, uploadPath);//파일업로드 처리
    	
    	mapInfo.setFilePath(fileInfoList.get(0).get("filePath"));
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
