package com.ncos.map.dao.hib;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mysema.query.BooleanBuilder;
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
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Transactional
	public Integer saveMapInfo(MapInfo mapInfo){
		Session session = sessionFactory.getCurrentSession();
		session.save(mapInfo);
		session.flush();
		return mapInfo.getMapid();
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
	public List<MapInfo> getMapInfoList(Map<String,Object> param){
		QMapInfo mapInfo = QMapInfo.mapInfo;
		JPQLQuery query = new HibernateQuery (getSession());
		//Dynamic condition
		BooleanBuilder builder = new BooleanBuilder();
		if(StringUtils.isNotEmpty((String) param.get("p_mapName")))
			builder.and(mapInfo.mapName.like("%"+(String) param.get("p_mapName")+"%"));
		List<MapInfo> list = query.from(mapInfo).where(builder)
								   .offset((Integer) param.get("p_offset")).limit((Integer) param.get("p_limit"))
								   .orderBy(mapInfo.mapid.desc()).list(mapInfo);
		return list;
	}
	@Transactional
	public int getMapInfoListCount(Map<String,Object> param){
		QMapInfo mapInfo = QMapInfo.mapInfo;
		JPQLQuery query = new HibernateQuery (getSession());
		//Dynamic condition
		BooleanBuilder builder = new BooleanBuilder();
		if(StringUtils.isNotEmpty((String) param.get("p_mapName")))
			builder.and(mapInfo.mapName.like("%"+(String) param.get("p_mapName")+"%"));
		int count = (int) query.from(mapInfo).where(builder).count();
		return count;
	}
	
	@Transactional
	public MapInfo getMapInfo(Integer mapid){
		QMapInfo mapInfo = QMapInfo.mapInfo;
		JPQLQuery query = new HibernateQuery(getSession());
		MapInfo info = query.from(mapInfo).where(mapInfo.mapid.eq(mapid)).uniqueResult(mapInfo);
		return info;
	}
	
}
