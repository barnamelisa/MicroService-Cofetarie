package com.example.demo.controller;

import com.example.demo.domain.dto.CofetarieDTO;
import com.example.demo.service.CofetarieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/cofetarie")
public class CofteraieController {

    @Autowired
    private CofetarieService cofetarieService;

    @GetMapping("/{id}")
    public ResponseEntity<CofetarieDTO> getCofetarieDetails(@PathVariable("id") int id) {
        CofetarieDTO cofetarieDTO = cofetarieService.getCofetarieById(id);
        return ResponseEntity.status(HttpStatus.OK).body(cofetarieDTO);
    }

    @GetMapping
    public ResponseEntity<List<CofetarieDTO>> getAllCofetarii() {
        List<CofetarieDTO> cofetarieDTOList = cofetarieService.getAllCofetarii();
        return ResponseEntity.ok(cofetarieDTOList);
    }


}