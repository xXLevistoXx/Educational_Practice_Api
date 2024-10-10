package com.API.schoolAPI.repository;

import com.API.schoolAPI.model.HolidayModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HolidayRepository extends JpaRepository<HolidayModel, UUID> {
}
