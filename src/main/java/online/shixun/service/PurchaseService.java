package online.shixun.service;

import java.util.List;

import online.shixun.model.Purchase;

public interface PurchaseService {
	public List<Purchase> listPurchase();

	/*
	 * 保存收购信息
	 */
	public void savePurchase(Purchase purchase);

	/*
	 * 删除收购信息
	 */
	public void deletePurchase(Purchase purchase);


	/*
	 * 修改收购信息
	 */
	public void updatePurchase(Purchase purchase);

}
