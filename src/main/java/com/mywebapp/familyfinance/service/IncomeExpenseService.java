package com.mywebapp.familyfinance.service;

import com.mywebapp.familyfinance.model.IncomeExpense;
import com.mywebapp.familyfinance.repository.IncomeExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeExpenseService {

    @Autowired
    private IncomeExpenseRepository incomeExpenseRepository;

    public IncomeExpense createIncomeExpense(IncomeExpense incomeExpense) {
        return incomeExpenseRepository.save(incomeExpense);
    }

    public IncomeExpense getIncomeExpense(Long id) {
        return incomeExpenseRepository.findById(id).orElse(null);
    }

    public List<IncomeExpense> getIncomeExpenseByTag(String tag) {
        return incomeExpenseRepository.findByTag(tag);
    }
    public List<IncomeExpense> getAllIncomeExpenses() {
        return incomeExpenseRepository.findAll();
    }

    public IncomeExpense updateIncomeExpense(Long id, IncomeExpense incomeExpense){
        return incomeExpenseRepository.findById(id).map(ie -> {
            ie.setCategory(incomeExpense.getCategory());
            ie.setSubCategory(incomeExpense.getSubCategory());
            ie.setDescription(incomeExpense.getDescription());
            ie.setAmount(incomeExpense.getAmount());
            ie.setDate(incomeExpense.getDate());
            ie.setTag(incomeExpense.getTag());
            return incomeExpenseRepository.save(ie);
        }).orElseGet(() -> {
            incomeExpense.setId(id);
            return incomeExpenseRepository.save(incomeExpense);
        });
    }

    public boolean deleteIncomeExpense(Long id){
        try {
            incomeExpenseRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
