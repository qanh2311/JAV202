package com.example.demo.repository;

import com.example.demo.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepo extends JpaRepository<Bill,Integer> {
}

