package com.example.crudcomservico.controllers;

import com.example.crudcomservico.DTOs.BillDTO;
import com.example.crudcomservico.DTOs.StatusDTO;
import com.example.crudcomservico.domain.Bill;
import com.example.crudcomservico.domain.schedules.Schedule;
import com.example.crudcomservico.services.BillServices;
import com.example.crudcomservico.services.ScheduleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BillsController {

    @Autowired
    private BillServices services;

    @Autowired
    private ScheduleServices scheduleServices;

    @PostMapping("/{status}")
    public ResponseEntity<List<Bill>> sendBill(@RequestBody StatusDTO status) throws Exception {


        return new ResponseEntity<>(services.getBillsByStatus(status), HttpStatus.OK);
    }

    @PostMapping("/insert")
    public void sendBill(@RequestBody BillDTO data) throws Exception{
        services.createBill(data);
    }

    @GetMapping
    public ResponseEntity<List<Bill>> getAll(){
        List<Bill> bills = services.getAllBills();

        return new ResponseEntity<>(bills, HttpStatus.OK);
    }




}
