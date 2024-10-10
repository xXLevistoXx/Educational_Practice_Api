package com.API.schoolAPI.controllers;

import com.API.schoolAPI.model.SubjectModel;
import com.API.schoolAPI.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/api/subjects")
public class SubjectApiController {
    @Autowired
    private final SubjectService subjectService;

    public SubjectApiController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping
    public List<SubjectModel> getAllSubjects() {
        return subjectService.findAllSubjects();
    }

    @GetMapping("/{id}")
    public SubjectModel getSubjectById(@PathVariable UUID id) {
        return subjectService.findSubjectById(id);
    }

    @PostMapping
    public SubjectModel createSubject(@RequestBody SubjectModel subject) {
        return subjectService.addSubject(subject);
    }

    @PutMapping("/{id}")
    public SubjectModel updateSubject(@PathVariable UUID id, @RequestBody SubjectModel subject) {
        subject.setId(id);
        return subjectService.updateSubject(subject);
    }

    @DeleteMapping("/{id}")
    public void deleteSubject(@PathVariable UUID id) {
        subjectService.deleteSubject(id);
    }
}
