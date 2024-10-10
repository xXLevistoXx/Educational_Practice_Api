package com.API.schoolAPI.service;

import com.API.schoolAPI.model.PassportModel;

import java.util.List;
import java.util.UUID;

public interface PassportService {
    public List<PassportModel> findAllPassports();

    public PassportModel findPassportById(UUID id);

    public PassportModel addPassport(PassportModel passport);

    public PassportModel updatePassport(PassportModel passport);

    public void deletePassport(UUID id);
}
