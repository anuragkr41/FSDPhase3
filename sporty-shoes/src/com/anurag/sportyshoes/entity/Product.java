package com.anurag.sportyshoes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name = "size")
	private int size;

	@Column(name="category")
	private String category;

	@Column(name="price")
	private int price;
	
	@Column(name="quantity_available")
	private String quantityAvailable;
	
	public Product() {}

	public Product(String name, int size, String category, int price, String quantityAvailable) {
		this.name = name;
		this.size = size;
		this.category = category;
		this.price = price;
		this.quantityAvailable = quantityAvailable;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getQuantityAvailable() {
		return quantityAvailable;
	}

	public void setQuantityAvailable(String quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", size=" + size + ", category=" + category + ", price=" + price
				+ ", quantityAvailable=" + quantityAvailable + "]";
	}
	
}
