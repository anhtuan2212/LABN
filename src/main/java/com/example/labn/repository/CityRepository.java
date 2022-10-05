package com.example.labn.repository;

import com.example.labn.entity.CityEntity;
import com.example.labn.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<CityEntity,Integer> {
@Query(value = "SELECT * FROM city",nativeQuery = true)
    List<CityEntity> getAll();

    @Query(value = "select * from city where city like ?1", nativeQuery = true)
    List<CityEntity> timkiem(String tukhoa);
}
