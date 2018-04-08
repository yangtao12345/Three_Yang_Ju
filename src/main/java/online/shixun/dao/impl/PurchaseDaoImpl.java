package online.shixun.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import online.shixun.dao.PurchaseDao;
import online.shixun.model.Purchase;
@Repository
@Transactional
public class PurchaseDaoImpl implements PurchaseDao{
	@Autowired
	SessionFactory sessionFactory;
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Purchase> listPurchase() {
		return getSession().createQuery("from Purchase").list();
	}

	@Override
	public void savePurchase(Purchase purchase) {
		getSession().save(purchase);
	}

	@Override
	public void deletePurchase(Purchase purchase) {
		getSession().delete(purchase);
	}

	@Override
	public void updatePurchase(Purchase purchase) {
		getSession().update(purchase);
	}

}
