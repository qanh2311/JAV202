package com.example.demo.repository;

import com.example.demo.model.BillDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillDetailRepo extends JpaRepository<BillDetail,Integer> {
}
