package com.API.schoolAPI.service;

import com.API.schoolAPI.model.UniversityModel;

import java.util.List;
import java.util.UUID;

public interface UniversityService {
    public List<UniversityModel> findAllUniversities();

    public UniversityModel findUniversityById(UUID id);

    public UniversityModel addUniversity(UniversityModel university);

    public UniversityModel updateUniversity(UniversityModel university);

    public void deleteUniversity(UUID id);
}
