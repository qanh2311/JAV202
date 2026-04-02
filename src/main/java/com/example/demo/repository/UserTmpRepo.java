package com.example.demo.repository;

import com.example.demo.model.UserTmp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTmpRepo extends JpaRepository<UserTmp, Integer> {

    @Query(value = """
        select u.id, u.full_name, count(b.user_id) as 'tong_bill', SUM(b.total) as 'tong_tien'
        from users u inner join bills b on u.id = b.user_id
        group by u.id, u.full_name
        """, nativeQuery = true)
    List<UserTmp> getList();
}
