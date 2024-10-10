package com.API.schoolAPI.controllers;

import com.API.schoolAPI.model.MeetingModel;
import com.API.schoolAPI.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/api/meetings")
public class MeetingApiController {
    @Autowired
    private final MeetingService meetingService;

    public MeetingApiController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @GetMapping
    public List<MeetingModel> getAllMeetings() {
        return meetingService.findAllMeetings();
    }

    @GetMapping("/{id}")
    public MeetingModel getMeetingById(@PathVariable UUID id) {
        return meetingService.findMeetingById(id);
    }

    @PostMapping
    public MeetingModel createMeeting(@RequestBody MeetingModel meeting) {
        return meetingService.addMeeting(meeting);
    }

    @PutMapping("/{id}")
    public MeetingModel updateMeeting(@PathVariable UUID id, @RequestBody MeetingModel meeting) {
        meeting.setId(id);
        return meetingService.updateMeeting(meeting);
    }

    @DeleteMapping("/{id}")
    public void deleteMeeting(@PathVariable UUID id) {
        meetingService.deleteMeeting(id);
    }
}

