package com.API.schoolAPI.repository;

import com.API.schoolAPI.model.SubjectModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SubjectRepository extends JpaRepository<SubjectModel, UUID> {
}
