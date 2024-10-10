package com.API.schoolAPI.repository;

import com.API.schoolAPI.model.PassportModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PassportRepository extends JpaRepository<PassportModel, UUID> {
}
