package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
			List <Expense> allExpenses =  expenseService.allExpenses();
	    	model.addAttribute("allExpenses", allExpenses);
	        return "index.jsp";
	    }
	    @PostMapping("/expense")
	    public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
	        if (result.hasErrors()) {
	            return "index.jsp";
	        } else {
	            expenseService.createExpense(expense);
	            return "redirect:/expense";
	        }
	    }
	    
//	    @GetMapping("/expense")
//	    public String allExpense(@ModelAttribute("allExpense")Expense expense) {
//	    	return"index.jsp";
//	    }
	}

