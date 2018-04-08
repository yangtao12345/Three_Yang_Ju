package online.shixun.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import online.shixun.dao.AuthoritiesDao;
import online.shixun.model.Authorities;
@Repository
@Transactional
public class AuthoritiesDaoImpl implements AuthoritiesDao{
	@Autowired
	SessionFactory sessionFactory;
	public void save(Authorities Authority) {
		sessionFactory.getCurrentSession().save(Authority);
	}
}
