
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

import com.niit.model.Product;
import com.niit.model.Category;
import com.niit.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;

	@RequestMapping("/getAllProducts")
	public ModelAndView home() {
		List<Product> products = productService.getAllProducts();
		return new ModelAndView("bookList", "product", products);
	}

	@RequestMapping("/getProductByproductNumber/{productNumber}")
	public ModelAndView getProductByproductNumber(@PathVariable(value = "productNumber") int productNumber) {
		Product b = productService.getProductByproductNumber(productNumber);
		return new ModelAndView("bookPage", "bookObj", b);
	}

	/*
	 * @RequestMapping("/delete/{isbn}") public String
	 * deleteBook(@PathVariable(value = "isbn") int isbn) {
	 * bookService.deleteBook(isbn); //
	 * http://localhost:8080/appname/getAllBooks return "redirect:/getAllBooks";
	 * }
	 */
	@RequestMapping(value = "/delete/{productNumber}")
	public String deleteBook(@PathVariable(value = "productNumber") int productNumber) {
		Path path = Paths.get("R:\\backup_dt7\\28-10-2016-exception\\spring\\src\\main\\webapp\\WEB-INF\\resources\\images\\"
				+ productNumber + ".png");
		if (Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		productService.deleteProduct(productNumber);
		return "redirect:/getAllProducts";
	}

	@RequestMapping(value = "/admin/book/addBook", method = RequestMethod.GET)
	public String getBookForm(Model model) {
		Product product = new Product();
		Category category = new Category();
		category.setCid(1);
		product.setCategory(category);
		model.addAttribute("bookFormObj", product);
		return "bookForm";

	}

	@RequestMapping(value = "/admin/book/addBook", method = RequestMethod.POST)
	public String addBook(@Valid @ModelAttribute(value = "bookFormObj") Product product, BindingResult result) {
		if (result.hasErrors())
			return "bookForm";
		productService.addProduct(product);

		MultipartFile image = product.getimage();
		if (image != null && !image.isEmpty()) {
			Path path = Paths
					.get("R:\\backup_dt7\\28-10-2016-exception\\spring\\src\\main\\webapp\\WEB-INF\\resources\\images\\"
							+ product.getProductNumber() + ".png");
			try {
				image.transferTo(new File(path.toString()));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "redirect:/getAllProducts";
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

	@RequestMapping(value = "/admin/book/editBook/{productNumber}", method = RequestMethod.GET)
	public ModelAndView getEditForm(@PathVariable(value = "productNumber") int productNumber) {

		Product product = this.productService.getProductByproductNumber(productNumber);
		return new ModelAndView("editBookForm", "editBookObj", product);
	}

	@RequestMapping(value = "/admin/book/editBook", method = RequestMethod.POST)
	public String editBook(@ModelAttribute(value = "editBookObj") Product product) {
		productService.editProduct(product);
		return "redirect:/getAllProducts";

	}

	// angular books method
	@RequestMapping("/getBookList")
	public @ResponseBody List<Product> getProductsListInJSON() {
		System.out.println(productService.getAllProducts());
		return productService.getAllProducts();
	}

	// angular view
	@RequestMapping("/booksListAngular")
	public String getAllBooks() {
		return "bookList";
	}
	@RequestMapping(value = "/getProductByCategory/{cid}")
	public @ResponseBody ModelAndView getProductByCategory(@PathVariable(value = "cid") int cid){
		System.out.println("done done done");
	List<Product> product = productService.getProductByCategory(cid);
	 return new ModelAndView("Leather", "Products", product);
		
	}
}