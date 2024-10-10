package com.API.schoolAPI.service;

import com.API.schoolAPI.model.HolidayModel;
import com.API.schoolAPI.repository.HolidayRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InMemoryHolidayServiceImpl implements HolidayService{
    private final HolidayRepository holidayRepository;

    public InMemoryHolidayServiceImpl(HolidayRepository holidayRepository) {
        this.holidayRepository = holidayRepository;
    }

    @Override
    public List<HolidayModel> findAllHolidays(){
        return holidayRepository.findAll(Sort.by("id"));
    }

    @Override
    public HolidayModel findHolidayById(UUID id) {
        return holidayRepository.findById(id).orElse(null);
    }

    @Override
    public HolidayModel addHoliday(HolidayModel holiday){
        return holidayRepository.save(holiday);
    }

    @Override
    public HolidayModel updateHoliday(HolidayModel holiday){
        if (holidayRepository.existsById(holiday.getId())) {
            return holidayRepository.save(holiday);
        }
        return null;
    }

    @Override
    public void deleteHoliday(UUID id){
        if (holidayRepository.existsById(id)) {
            holidayRepository.deleteById(id);
        }
    }

}
