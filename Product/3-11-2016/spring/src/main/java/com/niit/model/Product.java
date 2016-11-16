package com.niit.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "Products")
public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ProductNumber")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productNumber;

	@Column(name = "MadeFor")
	@NotEmpty(message = "Gender is mandatory")
	private String madeFor;

	@Column(name = "Material")
	@NotEmpty(message = "Material is mandatory")
	private String material;

	@Column(name = "price")
	@Min(value = 100, message = "Min value should be 100")
	private int price;

	@Column(name = "Manufacturer")
	@NotEmpty(message = "Manufacturer is mandatory")
	private String manufacturer;

	@ManyToOne
	@JoinColumn(name = "cid") // Foreign key column in BookApp table
	private Category category;
	
    @Transient
	private MultipartFile image;
	


	public MultipartFile getimage() {
		return image;
	}

	public void setimage(MultipartFile image) {
		this.image = image;
	}

	public Product() {
		super();
	}

	public int getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
	}

	public String getMadeFor() {
		return madeFor;
	}

	public void setMadeFor(String madeFor) {
		this.madeFor = madeFor;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Product [productNumber=" + productNumber + ", madeFor=" + madeFor + ", material=" + material
				+ ", price=" + price + ", manufacturer=" + manufacturer + ", category=" + category + ", image=" + image
				+ ", getimage()=" + getimage() + ", getProductNumber()=" + getProductNumber() + ", getMadeFor()="
				+ getMadeFor() + ", getMaterial()=" + getMaterial() + ", getPrice()=" + getPrice()
				+ ", getManufacturer()=" + getManufacturer() + ", getCategory()=" + getCategory() + "]";
	}




}

