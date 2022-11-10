package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.demo.models.Expense;
import com.example.demo.service.ExpenseService;

@Controller
public class ExpenseController {
	@Autowired
	private final ExpenseService expenseService;

	public ExpenseController(ExpenseService expenseService) {
		this.expenseService = expenseService;
	}

	@GetMapping("/expense")
	public String newExpense(Model model, @ModelAttribute("expense") Expense expense) {
		List<Expense> allExpenses = expenseService.allExpenses();
		model.addAttribute("allExpenses", allExpenses);
		return "index.jsp";
	}

	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Expense> allExpenses = expenseService.allExpenses();
			model.addAttribute("allExpenses", allExpenses);
			return "index.jsp";
		} else {
			expenseService.createExpense(expense);
			return "redirect:/expense";
		}
	}

	@GetMapping("/expense/{expenseid}")
	public String edit(@PathVariable("expenseid") Long id, Model model) {
		Expense expense1 = expenseService.findExpense(id);
		model.addAttribute("expense", expense1);
		return "edit.jsp";
	}

	@PutMapping("/expense")
	public String update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			expenseService.updateExpense(expense);
			return "redirect:/expense";
		}
	}

	// ... imports removed for brevity
	

		// other methods removed for brevity
		@DeleteMapping("/expense/{id}")
		public String destroy(@PathVariable("id") Long id) {
			expenseService.deleteExpense(id);
			return "redirect:/expense";
		}
	}


