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
        if (cofetarieDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cofetarieDTO);
    }


    @GetMapping
    public ResponseEntity<List<CofetarieDTO>> getAllCofetarii() {
        List<CofetarieDTO> cofetarieDTOList = cofetarieService.getAllCofetarii();
        return ResponseEntity.ok(cofetarieDTOList);
    }

    @PostMapping
    public ResponseEntity<CofetarieDTO> addCofetarie(@RequestBody CofetarieDTO dto) {
        CofetarieDTO created = cofetarieService.addCofetarie(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CofetarieDTO> updateCofetarie(@PathVariable int id, @RequestBody CofetarieDTO dto) {
        CofetarieDTO updated = cofetarieService.updateCofetarie(id, dto);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCofetarie(@PathVariable int id) {
        boolean deleted = cofetarieService.deleteCofetarie(id);
        if (!deleted) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
}