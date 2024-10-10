package com.API.schoolAPI.repository;

import com.API.schoolAPI.model.PositionModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PositionRepository extends JpaRepository<PositionModel, UUID> {
}
