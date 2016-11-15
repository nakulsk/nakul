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
@Table(name = "bookapp")
@Component
public class Book implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "isbn")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int isbn;

	@Column(name = "title")
	@NotEmpty(message = "title is mandatory")
	private String title;

	@Column(name = "publisher")
	@NotEmpty(message = "publication is mandatory")
	private String publication;

	@Column(name = "price")
	@Min(value = 100, message = "Min value should be 100")
	private int price;

	@Column(name = "author")
	@NotEmpty(message = "author is mandatory")
	private String author;

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

	public Book() {
		super();
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", publication=" + publication + ", price=" + price
				+ ", author=" + author + ", category=" + category + ", image=" + image + "]";
	}


	


}
