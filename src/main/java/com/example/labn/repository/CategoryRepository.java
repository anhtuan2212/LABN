package com.example.labn.repository;

import com.example.labn.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository  extends JpaRepository<CategoryEntity,Integer> {
    @Query(value ="select *from category" , nativeQuery = true)
    List<CategoryEntity> getAllCategory();

    // Có 1 câu sql để lấy dữ liệu
    // mình chỉ lấy ra những category tên có chữ a => viết sql để lấy ra category tên có chữ a
    @Query(value = "select * from  category where name like '%a%'", nativeQuery = true)
    // có 1 list để hứng data trả về từ câu sql trên
    List<CategoryEntity> getCategoryCoChuA();

    @Query(value = "select * from category where name like ?1", nativeQuery = true)
    List<CategoryEntity> timkiem(String tukhoa);
}
