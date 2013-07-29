package com.ncos.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ncos.hero.dao.HeroMngDao;
import com.ncos.hero.entity.Hero;
import com.ncos.map.dao.MapMngDao;
import com.ncos.map.entity.MapField;
import com.ncos.map.entity.MapInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/ncos-servlet.xml"})
public class HibTest {

	@Autowired
	HeroMngDao heroMngDao;
	
	@Autowired
	MapMngDao mapMngDao;
	
//	@Test
	public void testHero(){
		Hero hero = new Hero();
		hero.setHeroName("청년조조");
		hero.setType("A");
		hero.setPrice("100");
		hero.setForce(23);
//		hero.setHeroid("zegalkm");
		heroMngDao.saveHero(hero);
		//gg girls generation
	}
//	@Test
	public void testSaveMapInfo(){
		MapInfo mapInfo = new MapInfo();
		mapInfo.setWidth(1920);
		mapInfo.setHeight(1920);
		mapInfo.setMapName("허창");
		mapMngDao.saveMapInfo(mapInfo);
	}
//	@Test
	public void testSaveMapField(){
		MapField field = new MapField();
		MapInfo info = new MapInfo();
		info.setMapid(1);
		field.setMapInfo(info);
		field.setGpsX(0);
		field.setGpsY(0);
		field.setGeoType("A");
		mapMngDao.saveMapField(field);
	}
//	@Test
	public void deleteMapInfo(){
		MapInfo info = new MapInfo();
		info.setMapid(1);
		mapMngDao.deleteMapInfo(info);
	}
	
	@Test
	public void getMapList(){
		List<MapInfo> mapInfo = mapMngDao.getMapInfoList();
		for(MapInfo map : mapInfo){
			System.out.println("*** name : "+map.getMapName());
		}
	}
}
