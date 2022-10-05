package com.example.labn.repository;

import com.example.labn.entity.FilmCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public interface FilmCategoryRepository extends JpaRepository<FilmCategoryEntity,Integer> {
    @Query(value = "select * from film_category",nativeQuery = true)
    List<FilmCategoryEntity> getAll();
}
