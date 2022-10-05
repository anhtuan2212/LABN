package com.example.labn.repository;

import com.example.labn.entity.ActorEntity;
import com.example.labn.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<ActorEntity,Integer> {
    @Query(value = "SELECT * FROM actor",nativeQuery = true)
    List<ActorEntity> getAll();

    @Query(value = "select * from actor where first_name like ?1", nativeQuery = true)
    List<ActorEntity> timkiem(String tukhoa);
}
