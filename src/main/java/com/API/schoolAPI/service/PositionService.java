package com.API.schoolAPI.service;

import com.API.schoolAPI.model.PositionModel;

import java.util.List;
import java.util.UUID;

public interface PositionService {
    List<PositionModel> findAllPositions();
    PositionModel findPositionById(UUID id);
    PositionModel addPosition(PositionModel position);
    PositionModel updatePosition(PositionModel position);
    void deletePosition(UUID id);
}
