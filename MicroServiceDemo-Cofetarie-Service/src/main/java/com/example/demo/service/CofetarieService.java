package com.example.demo.service;


import com.example.demo.domain.entity.Cofetarie;
import com.example.demo.infrastructure.repository.CofetarieRepo;
import com.example.demo.domain.dto.CofetarieDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CofetarieService {

    @Autowired
    private CofetarieRepo cofetarieRepo;

    @Autowired
    private ModelMapper mapper;

    public CofetarieDTO getCofetarieById(int id) {
        Optional<Cofetarie> cofetarie = cofetarieRepo.findById(id);
        if (cofetarie.isPresent()) {
            return mapper.map(cofetarie.get(), CofetarieDTO.class);
        } else {
            return null; // or throw exception, your choice
        }
    }

    public List<CofetarieDTO> getAllCofetarii() {
        List<Cofetarie> cofetarieList = cofetarieRepo.findAll();
        return cofetarieList.stream()
                .map(employee -> mapper.map(employee, CofetarieDTO.class))
                .collect(Collectors.toList());
    }
}