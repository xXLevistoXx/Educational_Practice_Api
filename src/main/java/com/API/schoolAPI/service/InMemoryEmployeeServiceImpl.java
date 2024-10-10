package com.API.schoolAPI.service;
import com.API.schoolAPI.model.EmployeeModel;
import com.API.schoolAPI.model.MeetingModel;
import com.API.schoolAPI.model.PositionModel;
import com.API.schoolAPI.model.SubjectModel;
import com.API.schoolAPI.repository.EmployeeRepository;
import com.API.schoolAPI.repository.MeetingRepository;
import com.API.schoolAPI.repository.PositionRepository;
import com.API.schoolAPI.repository.SubjectRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
@Service
public class InMemoryEmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final PositionRepository positionRepository;
    private final SubjectRepository subjectRepository;
    private final MeetingRepository meetingRepository;

    public InMemoryEmployeeServiceImpl(EmployeeRepository employeeRepository, PositionRepository positionRepository, SubjectRepository subjectRepository, MeetingRepository meetingRepository) {
        this.employeeRepository = employeeRepository;
        this.positionRepository = positionRepository;
        this.subjectRepository = subjectRepository;
        this.meetingRepository = meetingRepository;
    }

    @Override
    public List<EmployeeModel> findAllEmployees() {
        return employeeRepository.findAll(Sort.by("id"));
    }

    @Override
    public EmployeeModel findEmployeeById(UUID id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public EmployeeModel addEmployee(EmployeeModel employee) {
        // Сохраняем связанные объекты
        PositionModel position = employee.getPosition();
        if (position != null && position.getId() == null) {
            position = positionRepository.save(position);
            employee.setPosition(position);
        }

        SubjectModel subject = employee.getSubject();
        if (subject != null && subject.getId() == null) {
            subject = subjectRepository.save(subject);
            employee.setSubject(subject);
        }

        List<MeetingModel> meetings = employee.getMeetings();
        if (meetings != null && !meetings.isEmpty()) {
            for (MeetingModel meeting : meetings) {
                if (meeting.getId() == null) {
                    meeting = meetingRepository.save(meeting);
                }
            }
            employee.setMeetings(meetings);
        }

        // Сохраняем сотрудника
        return employeeRepository.save(employee);
    }

    @Override
    public EmployeeModel updateEmployee(EmployeeModel employee) {
        if (employeeRepository.existsById(employee.getId())) {
            return employeeRepository.save(employee);
        }
        return null;
    }

    @Override
    public void deleteEmployee(UUID id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        }
    }
}