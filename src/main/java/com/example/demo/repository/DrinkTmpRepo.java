package com.example.demo.repository;

import com.example.demo.model.DrinkTmp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrinkTmpRepo extends JpaRepository<DrinkTmp,Integer> {
    @Query(value = """
        select top 10\s
        d.id, d.name, sum(bd.quantity) as 'so_luong'
        from drinks d
        inner join bill_details bd on d.id = bd.bill_id
        group by d.id, d.name
        order by so_luong desc
        """,nativeQuery = true)
    List<DrinkTmp> getList();
}
