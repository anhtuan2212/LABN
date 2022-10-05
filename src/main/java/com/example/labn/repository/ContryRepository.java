package com.example.labn.repository;

import com.example.labn.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContryRepository extends JpaRepository<CountryEntity,Integer> {
@Query(value = "SELECT * FROM country",nativeQuery = true)
    List<CountryEntity> getAll();

    @Query(value = "select * from country where country like ?1", nativeQuery = true)
    List<CountryEntity> timkiem(String tukhoa);
}
