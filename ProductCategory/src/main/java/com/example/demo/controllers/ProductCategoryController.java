package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Category;
import com.example.demo.models.Product;
import com.example.demo.service.ProductCategoryService;

;

@Controller
public class ProductCategoryController {

	private final ProductCategoryService productCategoryService;

	public ProductCategoryController(ProductCategoryService productCategoryService) {
		this.productCategoryService = productCategoryService;
	}

	@GetMapping("/")

	public String index(Model model) {
		model.addAttribute("products", productCategoryService.allProducts());
		model.addAttribute("categories", productCategoryService.allCategories());

		return "root.jsp";
	}

	@GetMapping("product/new")
	public String product(@ModelAttribute("product") Product product) {
		return "product.jsp";
	}

	@PostMapping("products")
	public String product(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "product.jsp";
		} else {
			productCategoryService.createProduct(product);
			return ("redirect:/");
		}
	}

	@GetMapping("/products/{productId}")

	public String oneProduct(Model model, @PathVariable("productId") Long id) {
		Product product = productCategoryService.findProduct(id);
		model.addAttribute("product", product);
		model.addAttribute("categories", productCategoryService.categoryNotInProduct(product));
		return "showProduct.jsp";
	}

	@PostMapping("/products/addcategory")
	public String addCategory(@RequestParam("productid") Long id1, @RequestParam("categoryid") Long id2) {
		Product product1 = productCategoryService.findProduct(id1);
		Category category1 = productCategoryService.findCategory(id2);
		List<Category> product1categories = product1.getCategories();
		product1categories.add(category1);
		product1.setCategories(product1categories);
		productCategoryService.updateProduct(product1);
		return "redirect:/";
	}
	
	

	@GetMapping("/category/new")
	public String category(@ModelAttribute("category") Category vategory) {
		return "category.jsp";
	}

	@PostMapping("/categories")
	public String category(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "category.jsp";
		} else {
			productCategoryService.createCategory(category);
			return ("redirect:/");
		}
	}
	@GetMapping("/categories/{categoryId}")
	public String oneCategory(Model model, @PathVariable("categoryId") Long id) {
		Category category = productCategoryService.findCategory(id);
		model.addAttribute("category", category);
		model.addAttribute("products", productCategoryService.productNotInCategory(category));
		return "showCategory.jsp";
	}

	@PostMapping("/categories/addproduct")
	public String addProduct(@RequestParam("categoryid") Long id1, @RequestParam("productid") Long id2) {
		Category category1 = productCategoryService.findCategory(id1);
		Product product1 = productCategoryService.findProduct(id2);
		List<Product> category1products = category1.getProducts();
		category1products.add(product1);
		category1.setProducts(category1products);
		productCategoryService.updateCategory(category1);
		return "redirect:/";
	}
	
}