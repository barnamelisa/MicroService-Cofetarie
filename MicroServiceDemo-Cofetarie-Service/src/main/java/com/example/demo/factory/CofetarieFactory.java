package com.example.demo.factory;

import com.example.demo.domain.dto.CofetarieDTO;
import com.example.demo.domain.entity.Cofetarie;

public class CofetarieFactory {
    public static Cofetarie createFromDTO(CofetarieDTO dto) {
        Cofetarie entity = new Cofetarie();
        entity.setId(dto.getId());
        entity.setAdresaCofetarie(dto.getAddress());
        return entity;
    }

    public static CofetarieDTO createDTO(Cofetarie entity) {
        CofetarieDTO dto = new CofetarieDTO();
        dto.setId(entity.getId());
        dto.setAddress(entity.getAdresaCofetarie());
        return dto;
    }
}
