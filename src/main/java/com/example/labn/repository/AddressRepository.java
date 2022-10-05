package com.example.labn.repository;

import com.example.labn.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity,Integer> {
    @Query(value = "SELECT * FROM address",nativeQuery = true)
    List<AddressEntity> getAll();

    @Query(value = "select * from address where address like ?1", nativeQuery = true)
    List<AddressEntity> timkiem(String tukhoa);
}
