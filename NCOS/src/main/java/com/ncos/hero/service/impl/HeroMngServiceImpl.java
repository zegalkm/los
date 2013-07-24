package com.ncos.hero.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ncos.hero.dao.HeroMngDao;
import com.ncos.hero.entity.Hero;
import com.ncos.hero.service.HeroMngService;
import com.ncos.hero.util.ImageCropGenerator;

@Service("heroMngService")
public class HeroMngServiceImpl implements HeroMngService{
	private static final Logger logger = Logger.getLogger(HeroMngServiceImpl.class);

	@Resource(name="heroMngDao")
	HeroMngDao heroMngDao;
	
	
	public void saveHero(Hero hero, String rgb) {
		heroMngDao.saveHero(hero);
		int index = hero.getFilePath().lastIndexOf("/");
		String originalPath = hero.getFilePath().substring(0,index+1);
		String fileName = hero.getFilePath().substring(index+1);
		
		logger.info("===========================================================================");
		logger.info("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		logger.info(String.format("originalPath : [%s] , fileName : [%s] ", originalPath,fileName));
		logger.info("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		logger.info("===========================================================================");
		
		//이미지 transparency & cropping 처리
		String filePath = hero.getFilePath();
		String[] rgbSplit = rgb.split(",");
		int[] rgbVal = {Integer.parseInt(rgbSplit[0]),Integer.parseInt(rgbSplit[1]),Integer.parseInt(rgbSplit[2])};
		ImageCropGenerator imgCropGen = new ImageCropGenerator();
		imgCropGen.cropImages(originalPath, fileName+"_atk.bmp", 12, 64, rgbVal);//atk
		imgCropGen.cropImages(originalPath, fileName+"_mov.bmp", 11, 48, rgbVal);//mov
		imgCropGen.cropImages(originalPath, fileName+"_spc.bmp", 5, 48, rgbVal);//spc
	}
}
