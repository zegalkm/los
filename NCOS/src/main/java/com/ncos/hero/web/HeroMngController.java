package com.ncos.hero.web;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ncos.hero.entity.Hero;
import com.ncos.hero.service.HeroMngService;
import com.ncos.utils.FileUtils;
import com.ncos.utils.TotalUtils;

@Controller
@RequestMapping("/hero")
public class HeroMngController {
	private static final Logger logger = Logger.getLogger(HeroMngController.class);

	@Resource(name="heroMngService")
	HeroMngService heroMngService;
	
	@Value("#{ncos_prop['commonFilePath']}")
	public String commonFilePath;
	@Value("#{ncos_prop['heroFilePath']}")
	public String heroFilePath;
	
	@RequestMapping("/list")
	public ModelAndView list(ModelAndView mv) throws Exception{
		return mv;
	}
	
	@RequestMapping("/createForm")
	public ModelAndView createForm(ModelAndView mv) throws Exception{
		mv.setViewName("hero/createForm");
		return mv;
	}
	
	@RequestMapping("/saveHero")
	public ModelAndView saveHero(ModelAndView mv , Hero hero, final HttpServletRequest request) throws Exception{
		String uploadPath = commonFilePath+heroFilePath;
		String datePath = TotalUtils.getUploadPathByDate();
		uploadPath += datePath;
		
		FileUtils fu = new FileUtils();
    	List<Map<String, String>> fileInfoList = fu.uploadHero(request, uploadPath);//파일업로드 처리

    	if(fileInfoList!=null&&fileInfoList.size()==3){
	    	hero.setFilePath(heroFilePath+datePath+fileInfoList.get(0).get("newFileName"));// /2013/07/18/20134322324 <-- 확장자없이 timestamp만 가지고 옴.
	    	String rgb = request.getParameter("p_rgb");
	    	heroMngService.saveHero(hero,rgb);
    	}else{
    		
    	}
		
		mv.setViewName("redirect:list");
		return mv;
	}

}
