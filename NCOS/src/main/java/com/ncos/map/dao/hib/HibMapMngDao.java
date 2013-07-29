package com.ncos.map.dao.hib;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.jpa.hibernate.HibernateQuery;
import com.ncos.map.dao.MapMngDao;
import com.ncos.map.entity.MapField;
import com.ncos.map.entity.MapInfo;
import com.ncos.map.entity.QMapInfo;
@Repository("mapMngDao")
public class HibMapMngDao implements MapMngDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void saveMapInfo(MapInfo mapInfo){
		Session session = sessionFactory.getCurrentSession();
		session.save(mapInfo);
		System.out.println(" ++++ mapid : "+mapInfo.getMapid()+" ++++++++++++++++++++++");
		session.flush();
	}
	
	@Transactional
	public void saveMapField(MapField mapField) {
		Session session = sessionFactory.getCurrentSession();
		session.save(mapField);
		session.flush();
	}
	
	@Transactional
	public void deleteMapInfo(MapInfo mapInfo){
		Session session = sessionFactory.getCurrentSession();
		session.delete(mapInfo);
		session.flush();
	}
	
	@Transactional
	public List<MapInfo> getMapInfoList(){
		Session session = sessionFactory.getCurrentSession();
		QMapInfo mapInfo = QMapInfo.mapInfo;
		JPQLQuery query = new HibernateQuery (session);
		List<MapInfo> list = query.from(mapInfo).list(mapInfo);
		return list;
	}
}
