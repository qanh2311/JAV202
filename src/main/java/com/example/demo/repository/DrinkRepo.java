package com.example.demo.repository;

import com.example.demo.model.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrinkRepo extends JpaRepository<Drink,Integer> {
    @Query(value = """
            select * from drinks where price between ?1 and ?2
        """, nativeQuery = true)
    List<Drink> getByPrice(Integer price1, Integer price2);
}
