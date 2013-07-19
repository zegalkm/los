package com.ncos.user.dao.hib;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ncos.user.dao.UserDao;
import com.ncos.user.entity.User;
@Repository("userDao")
public class HibernateUserDao implements UserDao{

	@Autowired
	private SessionFactory sessioFactory;
	
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public DataSource getDataSource() {
          return dataSource;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
          this.dataSource = dataSource;
          this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	@Transactional(readOnly=true)
	public Collection<User> getList() {
//		return sessioFactory.getCurrentSession().createQuery("from User").list();
		if(jdbcTemplate != null){
			List<Map<String, Object>> u = jdbcTemplate.queryForList("select * from sa_hero");
			for(Map<String,Object> obj : u){
				System.out.println("********** keyset : "+obj.keySet().toString()+"*****************");
				System.out.println("********** heroid : "+obj.get("heroid")+"*****************");
			}
		}else{
			System.out.println("jdbcTEmplate is NULL !!!!!!!!!!!!!!!!!!!!!!!!");
		}
		return null;
	}


	public boolean saveUser(User user) {
//		session.save(user);
//		session.flush();
//		session.close();
		return false;
	}

}
