package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Category;
import com.example.demo.models.Product;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.ProductRepository;

@Service
public class ProductCategoryService {

	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;

	public ProductCategoryService(ProductRepository productRepository, CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}

	public List<Product> allProducts() {
		return (List<Product>) productRepository.findAll();
	}

	public Product createProduct(Product d) {
		return productRepository.save(d);
	}

	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if (optionalProduct.isPresent()) {
			return optionalProduct.get();
		} else {
			return null;
		}
	}

	public List<Category> allCategories() {
		return (List<Category>) categoryRepository.findAll();
	}

	public Category createCategory(Category n) {
		return categoryRepository.save(n);
	}

	public Category findCategory(Long id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		if (optionalCategory.isPresent()) {
			return optionalCategory.get();
		} else {
			return null;
		}
	}

	public Product updateProduct(Product p) {
		return this.productRepository.save(p);

	}
	public Category updateCategory(Category c) {
		return this.categoryRepository.save(c);
	
	}

	public List<Category> categoryNotInProduct(Product product) {
		return categoryRepository.findByProductsNotContains(product);
	}
	public List<Product> productNotInCategory(Category category) {
		return productRepository.findByCategoriesNotContains(category);
	}
}
