package com.example.crudcomservico.controllers;

import com.example.crudcomservico.DTOs.UpdateDateDTO;
import com.example.crudcomservico.domain.schedules.Schedule;
import com.example.crudcomservico.services.BillServices;
import com.example.crudcomservico.services.ScheduleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

    @Autowired
    private BillServices services;

    @Autowired
    private ScheduleServices scheduleServices;

    @PutMapping
    public void updateDate(@RequestBody UpdateDateDTO updateData) throws Exception {
        this.services.updateDate(updateData);
    }


    @GetMapping
    public ResponseEntity<List<Schedule>> getSchedules(){
        return ResponseEntity.ok(scheduleServices.alldata());
    }

}
