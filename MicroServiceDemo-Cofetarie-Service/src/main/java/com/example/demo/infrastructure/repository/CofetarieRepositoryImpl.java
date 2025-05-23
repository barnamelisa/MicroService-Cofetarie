package com.example.demo.infrastructure.repository;

import com.example.demo.domain.contracts.CofetarieRepository;
import com.example.demo.domain.entity.Cofetarie;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CofetarieRepositoryImpl implements CofetarieRepository {

    private final CofetarieRepo jpaRepo;

    public CofetarieRepositoryImpl(CofetarieRepo jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public List<Cofetarie> findAll() {
        return jpaRepo.findAll();
    }

    @Override
    public Optional<Cofetarie> findById(int id) {
        return jpaRepo.findById(id);
    }

    @Override
    public Cofetarie save(Cofetarie cofetarie) {
        return jpaRepo.save(cofetarie);
    }

    @Override
    public void deleteById(int id) {
        jpaRepo.deleteById(id);
    }
}