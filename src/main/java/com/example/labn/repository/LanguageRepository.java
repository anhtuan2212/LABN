package com.example.labn.repository;

import com.example.labn.entity.LanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguageRepository extends JpaRepository<LanguageEntity,Integer> {
    @Query(value = "SELECT * FROM language",nativeQuery = true)
    List<LanguageEntity> getAll();

    @Query(value = "select * from language where name like ?1", nativeQuery = true)
    List<LanguageEntity> timkiem(String tukhoa);
}
