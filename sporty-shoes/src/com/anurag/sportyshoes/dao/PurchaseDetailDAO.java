package com.anurag.sportyshoes.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.anurag.sportyshoes.entity.PurchaseDetail;

@Repository
public class PurchaseDetailDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public int save(PurchaseDetail pd) {
				
		return (int)sessionFactory.getCurrentSession().save(pd);
		
	}
	@Transactional
	public List<PurchaseDetail> getAllPurchases()
	{
		sessionFactory.getCurrentSession().clear();
		return sessionFactory.getCurrentSession().createQuery("From PurchaseDetail", PurchaseDetail.class).getResultList();
	}
	@Transactional

	public PurchaseDetail getbyPurchaseId(int purchaseId)
	{
		return sessionFactory.getCurrentSession().createQuery("from PurchaseDetail where purchaseId="+purchaseId,PurchaseDetail.class).uniqueResult();
	}
	
	@Transactional
	public List<PurchaseDetail> getPurchasesByUserId(int userId) {
		
		return sessionFactory.getCurrentSession().createQuery("from PurchaseDetail where purchasedByUserID="+userId,PurchaseDetail.class).getResultList();
	}
	
	@Transactional
	public List<PurchaseDetail> getPurcahsesForProduct(int productId) {
		
		
		return sessionFactory.getCurrentSession().createQuery("from PurchaseDetail where purchasedProductID="+productId,PurchaseDetail.class).getResultList();
		
	}
	
	@Transactional
	public List<PurchaseDetail> getPurchasesforParticularDate(Date date) {
		
		return sessionFactory.getCurrentSession().createNativeQuery("select * from purchasedetail where date="+date, PurchaseDetail.class).getResultList();
		
	}
	
	@Transactional
	public List<PurchaseDetail> getPurchasesforRangeDates(Date fromDate,Date toDate) {
		
		return sessionFactory.getCurrentSession().createNativeQuery("select * from purchasedetail where date between "+fromDate+" and "+toDate,PurchaseDetail.class).getResultList();
	}
	


}
