package com.API.schoolAPI.controllers;

import com.API.schoolAPI.model.PassportModel;
import com.API.schoolAPI.service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/api/passports")
public class PassportApiController {
    @Autowired
    private final PassportService passportService;

    public PassportApiController(PassportService passportService) {
        this.passportService = passportService;
    }

    @GetMapping
    public List<PassportModel> getAllPassports() {
        return passportService.findAllPassports();
    }

    @GetMapping("/{id}")
    public PassportModel getPassportById(@PathVariable UUID id) {
        return passportService.findPassportById(id);
    }

    @PostMapping
    public PassportModel createPassport(@RequestBody PassportModel passport) {
        return passportService.addPassport(passport);
    }

    @PutMapping("/{id}")
    public PassportModel updatePassport(@PathVariable UUID id, @RequestBody PassportModel passport) {
        passport.setId(id);
        return passportService.updatePassport(passport);
    }

    @DeleteMapping("/{id}")
    public void deletePassport(@PathVariable UUID id) {
        passportService.deletePassport(id);
    }
}