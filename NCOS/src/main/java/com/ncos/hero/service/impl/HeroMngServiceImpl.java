package com.ncos.hero.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ncos.hero.dao.HeroMngDao;
import com.ncos.hero.entity.Hero;
import com.ncos.hero.service.HeroMngService;

@Service("heroMngService")
public class HeroMngServiceImpl implements HeroMngService{

//	public enum HeroImg{
//		ATK_SIZE("64"),MOV_SIZE("48"),SPC_SIZE("64");
//		ATK_CROP_COUNT("12"),MOV_CROP_COUNT("11"),SPC_CROP_COUNT("5");
//		HERO_IMG_COUNT(3);
//		
//		HeroImg(){
//			
//		}
//	}
	
	@Resource(name="heroMngDao")
	HeroMngDao heroMngDao;
	
	public void saveHero(Hero hero, String rgb) {
		heroMngDao.saveHero(hero);
		//TODO 이미지 transparency & cropping 처리
		String filePath = hero.getFilePath();
		String[] rgbSplit = rgb.split(",");
		int[] rgbVal = {Integer.parseInt(rgbSplit[0]),Integer.parseInt(rgbSplit[1]),Integer.parseInt(rgbSplit[2])};
	}
}
