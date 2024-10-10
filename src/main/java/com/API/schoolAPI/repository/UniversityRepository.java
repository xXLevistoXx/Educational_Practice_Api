package com.API.schoolAPI.repository;


import com.API.schoolAPI.model.UniversityModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UniversityRepository extends JpaRepository<UniversityModel, UUID> {
}
