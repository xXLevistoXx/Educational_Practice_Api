package com.API.schoolAPI.repository;

import com.API.schoolAPI.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, UUID> {
}
