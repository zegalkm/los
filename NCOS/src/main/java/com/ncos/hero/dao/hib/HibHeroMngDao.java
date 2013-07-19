package com.ncos.hero.dao.hib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ncos.hero.dao.HeroMngDao;
import com.ncos.hero.entity.Hero;

@Repository("heroMngDao")
public class HibHeroMngDao implements HeroMngDao{

	@Autowired
	private SessionFactory sessioFactory;

	@Transactional
	public void saveHero(Hero hero) {
		Session session = sessioFactory.getCurrentSession();
		session.save(hero);
		session.flush();
//		session.close();
	}
}
