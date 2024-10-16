package com.mywebapp.familyfinance.repository;

import com.mywebapp.familyfinance.model.IncomeExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncomeExpenseRepository extends JpaRepository<IncomeExpense,Long> {
    List<IncomeExpense> findByCategory(String category);
    List<IncomeExpense> findBySubCategory(String subCategory);

    List<IncomeExpense> findByTag(String tag);
}
