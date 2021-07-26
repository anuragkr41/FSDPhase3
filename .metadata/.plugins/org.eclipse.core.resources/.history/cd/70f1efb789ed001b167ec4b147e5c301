package com.anurag.sportyshoes.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PurchaseDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int purchaseId;
	
	private int purchasedByUserID;
	
	private int purchasedProductID;
	
	private Date purchaseDate;

	public PurchaseDetail(int purchaseId, int purchasedByUserID, int purchasedProductID, Date purchaseDate) {
		this.purchaseId = purchaseId;
		this.purchasedByUserID = purchasedByUserID;
		this.purchasedProductID = purchasedProductID;
		this.purchaseDate = purchaseDate;
	}

	public PurchaseDetail(int purchasedByUserID, int purchasedProductID, Date purchaseDate) {
		this.purchasedByUserID = purchasedByUserID;
		this.purchasedProductID = purchasedProductID;
		this.purchaseDate = purchaseDate;
	}

	public PurchaseDetail() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PurchaseDetail [purchaseId=" + purchaseId + ", purchasedByUserID=" + purchasedByUserID
				+ ", purchasedProductID=" + purchasedProductID + ", purchaseDate=" + purchaseDate + "]";
	}

	public int getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	public int getPurchasedByUserID() {
		return purchasedByUserID;
	}

	public void setPurchasedByUserID(int purchasedByUserID) {
		this.purchasedByUserID = purchasedByUserID;
	}

	public int getPurchasedProductID() {
		return purchasedProductID;
	}

	public void setPurchasedProductID(int purchasedProductID) {
		this.purchasedProductID = purchasedProductID;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
	
}
