package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Expense;
import com.example.demo.repository.ExpenseRepository;

@Service
public class ExpenseService {


	private final ExpenseRepository expenseRepository;

	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}

	public List<Expense> allExpenses() {
		return (List<Expense>) expenseRepository.findAll();
	}

	public Expense createExpense(Expense expense) {
		return expenseRepository.save(expense);
	}

	public Expense findExpense(Long id) {
		return this.expenseRepository.findById(id).orElse(null);
	}
	
	public Expense updateExpense(Expense expense) {
	return expenseRepository.save(expense);
	}

	public void deleteExpense(Long id) {
		// TODO Auto-generated method stub
		expenseRepository.deleteById(id);
	}
}
