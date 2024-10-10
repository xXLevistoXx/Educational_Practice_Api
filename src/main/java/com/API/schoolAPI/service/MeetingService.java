package com.API.schoolAPI.service;

import com.API.schoolAPI.model.MeetingModel;

import java.util.List;
import java.util.UUID;

public interface MeetingService {
    List<MeetingModel> findAllMeetings();
    MeetingModel findMeetingById(UUID id);
    MeetingModel addMeeting(MeetingModel meeting);
    MeetingModel updateMeeting(MeetingModel meeting);
    void deleteMeeting(UUID id);
}
