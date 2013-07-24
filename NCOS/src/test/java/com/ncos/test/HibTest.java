package com.ncos.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ncos.hero.dao.HeroMngDao;
import com.ncos.hero.entity.Hero;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/ncos-servlet.xml"})
public class HibTest {

	@Autowired
	HeroMngDao heroMngDao;
	
	@Test
	public void testHero(){
		Hero hero = new Hero();
		hero.setHeroName("청년조조");
		hero.setType("A");
		hero.setPrice("100");
		hero.setForce(23);
//		hero.setHeroid("zegalkm");
		heroMngDao.saveHero(hero);
		//gg
	}
}
