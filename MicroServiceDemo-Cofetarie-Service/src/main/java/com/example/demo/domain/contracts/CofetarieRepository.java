package com.example.demo.domain.contracts;

import com.example.demo.domain.entity.Cofetarie;

import java.util.List;
import java.util.Optional;

public interface CofetarieRepository {
    List<Cofetarie> findAll();
    Optional<Cofetarie> findById(int id);
    Cofetarie save(Cofetarie cofetarie);
    void deleteById(int id);
}
