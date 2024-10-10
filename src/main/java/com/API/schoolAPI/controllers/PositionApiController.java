package com.API.schoolAPI.controllers;

import com.API.schoolAPI.model.PositionModel;
import com.API.schoolAPI.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/api/positions")
public class PositionApiController {
    @Autowired
    private final PositionService positionService;

    public PositionApiController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping
    public List<PositionModel> getAllPositions() {
        return positionService.findAllPositions();
    }

    @GetMapping("/{id}")
    public PositionModel getPositionById(@PathVariable UUID id) {
        return positionService.findPositionById(id);
    }

    @PostMapping
    public PositionModel createPosition(@RequestBody PositionModel position) {
        return positionService.addPosition(position);
    }

    @PutMapping("/{id}")
    public PositionModel updatePosition(@PathVariable UUID id, @RequestBody PositionModel position) {
        position.setId(id);
        return positionService.updatePosition(position);
    }

    @DeleteMapping("/{id}")
    public void deletePosition(@PathVariable UUID id) {
        positionService.deletePosition(id);
    }
}

