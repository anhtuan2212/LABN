package com.example.labn.repository;

import com.example.labn.entity.CityEntity;
import com.example.labn.entity.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<FilmEntity,Integer> {
@Query(value = "select * from film",nativeQuery = true)
    List<FilmEntity> getAll();
    @Query(value = "select * from film where release_year = ?1", nativeQuery = true)
    List<FilmEntity> timkiem(String tukhoa);
}
