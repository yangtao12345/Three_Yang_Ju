package online.shixun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import online.shixun.model.Purchase;
import online.shixun.service.impl.PurchaseServiceImpl;

@Controller
@RequestMapping()
public class PurchaseController {
	@Autowired
	PurchaseServiceImpl purchaseServiceImpl;
	@RequestMapping(value="handing_purchase_check",method=RequestMethod.GET)
	public String handing_purchase_check(Model model){
		List<Purchase> list=purchaseServiceImpl.listPurchase();
		model.addAttribute("list", list);
		return "purchase-manage";
	}

}
