package com.example.demo.infrastructure.repository;

import com.example.demo.domain.entity.Cofetarie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CofetarieRepo extends JpaRepository<Cofetarie, Integer> {

}