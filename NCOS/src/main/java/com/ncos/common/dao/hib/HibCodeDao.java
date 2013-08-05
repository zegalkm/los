package com.ncos.common.dao.hib;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.Tuple;
import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.jpa.hibernate.HibernateDeleteClause;
import com.mysema.query.jpa.hibernate.HibernateQuery;
import com.ncos.common.dao.CodeDao;
import com.ncos.common.entity.Code;
import com.ncos.common.entity.QCode;

@Repository("codeDao")
public class HibCodeDao implements CodeDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Transactional
	public List<Code> getCodeList(Map<String,Object> param){
		QCode code = QCode.code;
		JPQLQuery query = new HibernateQuery (getSession());
		return query.from(code).list(code);
//		BooleanBuilder builder = new BooleanBuilder();
//		if(StringUtils.isNotEmpty((String) param.get("p_keyword"))){
//			builder.or(code.codeId.masterCode.like("%"+(String) param.get("p_keyword")+"%"));
//			builder.or(code.codeId.detailCode.like("%"+(String) param.get("p_keyword")+"%"));
//			builder.or(code.codeName.like("%"+(String) param.get("p_keyword")+"%"));
//			builder.or(code.codeDesc.like("%"+(String) param.get("p_keyword")+"%"));
//		}
//		List<Code> list = query.from(code).where(builder)
//								   .offset((Integer) param.get("p_offset")).limit((Integer) param.get("p_limit"))
//								   .orderBy(code.codeId.masterCode.asc(),code.sortNum.asc()).list(code);
//		return list;
	}
//	
//	@Transactional
//	public int getCodeListCount(Map<String,Object> param){
//		QCode code = QCode.code;
//		JPQLQuery query = new HibernateQuery (getSession());
//		BooleanBuilder builder = new BooleanBuilder();
//		if(StringUtils.isNotEmpty((String) param.get("p_keyword"))){
//			builder.or(code.codeId.masterCode.like("%"+(String) param.get("p_keyword")+"%"));
//			builder.or(code.codeId.detailCode.like("%"+(String) param.get("p_keyword")+"%"));
//			builder.or(code.codeName.like("%"+(String) param.get("p_keyword")+"%"));
//			builder.or(code.codeDesc.like("%"+(String) param.get("p_keyword")+"%"));
//		}
//		int count = (int) query.from(code).where(builder).count();
//		
//		return count;
//	}
//	
//	@Transactional
//	public void saveCode(Code code){
//		getSession().save(code);
//		getSession().flush();
//	}
//	
//	@Transactional
//	public Code getCode(Map<String,Object> param){
//		QCode code = QCode.code;
//		JPQLQuery query = new HibernateQuery (getSession());
//		Code item = query.from(code)
//				   .where(code.codeId.masterCode.eq((String) param.get("p_masterCode"))
//						  .and(code.codeId.detailCode.eq((String) param.get("p_detailCode"))))
//				   .uniqueResult(code);
//		return item;
//	}
//	
//	@Transactional
//	public void deleteCode(Map<String,Object> param){
//		QCode code = QCode.code;
//		BooleanBuilder builder = new BooleanBuilder();
//		builder.and(code.codeId.masterCode.eq((String) param.get("p_masterCode")));
//		if(StringUtils.isNotEmpty((String) param.get("p_detailCode"))){
//			builder.and(code.codeId.detailCode.eq((String) param.get("p_detailCode")));
//		}
//		new HibernateDeleteClause(getSession(), code).where(builder).execute();
//	}
//	
//	/**
//	 * 마스터코드 목록
//	 */
//	@Transactional
//	public List<String> getMasterCodeList(){
//		QCode code = QCode.code;
//		JPQLQuery query = new HibernateQuery (getSession());
//		List<String> list = query.from(code).groupBy(code.codeId.masterCode).list(code.codeId.masterCode);
//		return list;
//	}
//	/**
//	 * 하위코드 목록
//	 */
//	@Transactional
//	public List<Code> getDetailCodeList(String masterCode){
//		QCode code = QCode.code;
//		JPQLQuery query = new HibernateQuery (getSession());
//		List<Code> list = query.from(code).where(code.codeId.masterCode.eq(masterCode))
//				                             .list(code);
//		return list;
//	}
}
