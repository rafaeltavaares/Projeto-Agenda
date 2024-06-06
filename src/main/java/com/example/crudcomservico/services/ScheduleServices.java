package com.example.crudcomservico.services;

import com.example.crudcomservico.domain.Bill;
import com.example.crudcomservico.domain.schedules.Schedule;
import com.example.crudcomservico.repositories.ScheduleRepository;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ScheduleServices {

    @Autowired
    private ScheduleRepository repository;



    public List<Schedule> alldata(){
        return repository.findAll();
    }
    public void persistData(Bill data, LocalDate date){
        Schedule newData = new Schedule();
        newData.setBill(data);
        newData.setPaymentDate(date);
        repository.save(newData);

    }




}

