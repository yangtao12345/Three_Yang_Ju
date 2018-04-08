package online.shixun.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.shixun.dao.impl.PurchaseDaoImpl;
import online.shixun.model.Purchase;
import online.shixun.service.PurchaseService;
@Service
@Transactional
public class PurchaseServiceImpl implements PurchaseService{
	@Autowired
	PurchaseDaoImpl purchaseDaoImpl;

	@Override
	public List<Purchase> listPurchase() {
		return purchaseDaoImpl.listPurchase();
	}

	@Override
	public void savePurchase(Purchase purchase) {
		purchaseDaoImpl.savePurchase(purchase);
	}

	@Override
	public void deletePurchase(Purchase purchase) {
		purchaseDaoImpl.deletePurchase(purchase);
	}

	@Override
	public void updatePurchase(Purchase purchase) {
		purchaseDaoImpl.updatePurchase(purchase);
	}

}
