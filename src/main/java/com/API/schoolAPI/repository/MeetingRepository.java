package com.API.schoolAPI.repository;

import com.API.schoolAPI.model.MeetingModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MeetingRepository extends JpaRepository<MeetingModel, UUID> {
}
