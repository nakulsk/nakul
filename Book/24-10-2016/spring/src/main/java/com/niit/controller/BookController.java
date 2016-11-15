package com.niit.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.model.Book;
import com.niit.model.Category;
import com.niit.service.BookService;

@Controller
public class BookController {
	@Autowired
	BookService bookService;

	@RequestMapping("/getAllBooks")
	public ModelAndView home() {
		List<Book> books = bookService.getAllBooks();
		return new ModelAndView("bookList", "book", books);
	}

	@RequestMapping("/getBookByIsbn/{isbn}")
	public ModelAndView getBookByIsbn(@PathVariable(value = "isbn") int isbn) {
		Book b = bookService.getBookByIsbn(isbn);
		return new ModelAndView("bookPage", "bookObj", b);
	}

	/*
	 * @RequestMapping("/delete/{isbn}") public String
	 * deleteBook(@PathVariable(value = "isbn") int isbn) {
	 * bookService.deleteBook(isbn); //
	 * http://localhost:8080/appname/getAllBooks return "redirect:/getAllBooks";
	 * }
	 */
	@RequestMapping(value = "/delete/{isbn}")
	public String deleteBook(@PathVariable(value = "isbn") int isbn) {
		Path path = Paths
				.get("R:\\For eclipse\\Workspace_Book\\spring\\src\\main\\webapp\\WEB-INF\\resources\\images\\" + isbn + ".png");
		if (Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		bookService.deleteBook(isbn);
		return "redirect:/getAllBooks";
	}

	@RequestMapping(value = "/admin/book/addBook", method = RequestMethod.GET)
	public String getBookForm(Model model) {
		Book book = new Book();
		Category category = new Category();
		category.setCid(1);
		book.setCategory(category);
		model.addAttribute("bookFormObj", book);
		return "bookForm";

	}

	@RequestMapping(value = "/admin/book/addBook", method = RequestMethod.POST)
	public String addBook(@Valid @ModelAttribute(value = "bookFormObj") Book book, BindingResult result) {
		if (result.hasErrors())
			return "bookForm";
		bookService.addBook(book);

		MultipartFile image = book.getimage();
		if (image != null && !image.isEmpty()) {
			Path path = Paths.get("R:\\For eclipse\\Workspace_Book\\spring\\src\\main\\webapp\\WEB-INF\\resources\\images\\"
					+ book.getIsbn() + ".png");
			try {
				image.transferTo(new File(path.toString()));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "redirect:/getAllBooks";
	}

	/*
	 * @RequestMapping(value = "/admin/book/addBook", method =
	 * RequestMethod.POST) public String addBook(@Valid @ModelAttribute(value =
	 * "bookFormObj") Book book, BindingResult result) {
	 * 
	 * if (result.hasErrors()) { System.out.println("if excecute");
	 * 
	 * return "bookForm";
	 * 
	 * } else { System.out.println("else excecutenxt");
	 * bookService.addBook(book); return "redirect:/getAllBooks";
	 * 
	 * }
	 * 
	 * }
	 */

	@RequestMapping(value = "/admin/book/editBook/{isbn}", method = RequestMethod.GET)
	public ModelAndView getEditForm(@PathVariable(value = "isbn") int isbn) {

		Book book = this.bookService.getBookByIsbn(isbn);
		return new ModelAndView("editBookForm", "editBookObj", book);
	}

	@RequestMapping(value = "/admin/book/editBook", method = RequestMethod.POST)
	public String editBook(@ModelAttribute(value = "editBookObj") Book book) {
		bookService.editBook(book);
		return "redirect:/getAllBooks";

	}
	@RequestMapping("/getBooksList")
	public @ResponseBody List<Book> getBooksListInJSON(){
		//System.out.println(bookService.getAllBooks());
		return bookService.getAllBooks();
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/booksListAngular")
	public String getAllBooks(){
		return "bookListAngular";
	}


}