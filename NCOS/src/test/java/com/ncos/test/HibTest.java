package com.ncos.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ncos.common.dao.CodeDao;
import com.ncos.common.entity.Code;
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
	@Autowired
	CodeDao codeDao;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
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
		mapInfo.setMapName("건업");
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
	
//	@Test
	public void getMapList(){
		Map<String,Object> param = new HashMap<String,Object>();
//		param.put("p_mapName","하");
		List<MapInfo> mapInfo = mapMngDao.getMapInfoList(param);
		for(MapInfo map : mapInfo){
			System.out.println("*** name : "+map.getMapName());
		}
	}
//	@Test
	public void getMapInfo(){
		MapInfo mapInfo = mapMngDao.getMapInfo(3);
		System.out.println("file path : "+mapInfo.getFilePath());
	}
	@Test
	@Transactional
	public void getCodeList(){
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("p_keyword","");
		param.put("p_offset",0);
		param.put("p_limit",10);
		List<Code> list = codeDao.getCodeList(param);
//		QCode code = QCode.code;
//		JPQLQuery query = new HibernateQuery (getSession());
//		List<Code> list = query.from(code).list(code);
		for(Code c : list){
			System.out.println("********** master : "+c.getMasterCode());
			System.out.println("********** detail : "+c.getDetailCode());
			System.out.println("********** name : "+c.getCodeName());
		}
	}
	
	
}
