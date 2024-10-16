package com.mywebapp.familyfinance.controller;

import com.mywebapp.familyfinance.model.IncomeExpense;
import com.mywebapp.familyfinance.service.IncomeExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/income-expense")
@CrossOrigin(origins = "http://localhost:3000")
public class IncomeExpenseController {

    @Autowired
    private IncomeExpenseService incomeExpenseService;

    @PostMapping
    public IncomeExpense createIncomeExpense(@RequestBody IncomeExpense incomeExpense) {
        return incomeExpenseService.createIncomeExpense(incomeExpense);
    }

    @GetMapping("/{id}")
    public IncomeExpense getIncomeExpense(@PathVariable Long id) {
        return incomeExpenseService.getIncomeExpense(id);
    }

    @GetMapping("/tag/{tag}")
    public List<IncomeExpense> getIncomeExpenseByTag(@PathVariable String tag) {
        return incomeExpenseService.getIncomeExpenseByTag(tag);
    }

    @GetMapping
    public List<IncomeExpense> getAllIncomeExpenses() {
        return incomeExpenseService.getAllIncomeExpenses();
    }

    @PutMapping("/{id}")
    public IncomeExpense updateIncomeExpense(@PathVariable Long id, @RequestBody IncomeExpense incomeExpense) {
        return incomeExpenseService.updateIncomeExpense(id, incomeExpense);
    }

    @DeleteMapping("/{id}")
    public boolean deleteIncomeExpense(@PathVariable Long id){
        return incomeExpenseService.deleteIncomeExpense(id);
    }
}