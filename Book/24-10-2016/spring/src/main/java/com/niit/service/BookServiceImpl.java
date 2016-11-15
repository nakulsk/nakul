package com.niit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.BookDao;
import com.niit.model.*;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	BookDao bookDao;

	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public List<Book> getAllBooks() {
		return bookDao.getAllBooks();
	}

	public Book getBookByIsbn(int isbn) {
		return bookDao.getBookByIsbn(isbn);
	}

	public void deleteBook(int isbn) {
		bookDao.deleteBook(isbn);

	}

	public void addBook(Book book) {
		bookDao.addBook(book);
	}
	public void editBook(Book book) {
		bookDao.editBook(book);
		
	}


}
