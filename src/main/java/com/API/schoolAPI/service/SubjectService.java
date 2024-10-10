package com.API.schoolAPI.service;

import com.API.schoolAPI.model.SubjectModel;

import java.util.List;
import java.util.UUID;

public interface SubjectService {
    List<SubjectModel> findAllSubjects();
    SubjectModel findSubjectById(UUID id);
    SubjectModel addSubject(SubjectModel subject);
    SubjectModel updateSubject(SubjectModel subject);
    void deleteSubject(UUID id);
}
