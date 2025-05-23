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
import jakarta.annotation.PostConstruct;

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

    @PostConstruct
    public void initMapper() {
        mapper.typeMap(CofetarieDTO.class, Cofetarie.class).addMappings(m ->
                m.map(CofetarieDTO::getAddress, Cofetarie::setAdresaCofetarie)
        );

        mapper.typeMap(Cofetarie.class, CofetarieDTO.class).addMappings(m ->
                m.map(Cofetarie::getAdresaCofetarie, CofetarieDTO::setAddress)
        );
    }

    public List<CofetarieDTO> getAllCofetarii() {
        List<Cofetarie> cofetarieList = cofetarieRepo.findAll();
        return cofetarieList.stream()
                .map(employee -> mapper.map(employee, CofetarieDTO.class))
                .collect(Collectors.toList());
    }

    public CofetarieDTO addCofetarie(CofetarieDTO dto) {
        Cofetarie entity = mapper.map(dto, Cofetarie.class);
        Cofetarie saved = cofetarieRepo.save(entity);
        return mapper.map(saved, CofetarieDTO.class);
    }

    public CofetarieDTO updateCofetarie(int id, CofetarieDTO dto) {
        Optional<Cofetarie> optional = cofetarieRepo.findById(id);
        if (optional.isPresent()) {
            Cofetarie existing = optional.get();
            existing.setAdresaCofetarie(dto.getAddress());
            Cofetarie updated = cofetarieRepo.save(existing);
            return mapper.map(updated, CofetarieDTO.class);
        }
        return null;
    }

    public boolean deleteCofetarie(int id) {
        if (cofetarieRepo.existsById(id)) {
            cofetarieRepo.deleteById(id);
            return true;
        }
        return false;
    }
}