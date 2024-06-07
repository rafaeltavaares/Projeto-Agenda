package com.example.crudcomservico.controllers;

import com.example.crudcomservico.DTOs.BillDTO;
import com.example.crudcomservico.DTOs.BillReturnDTO;
import com.example.crudcomservico.DTOs.BillStatusDetailedDTO;
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
import java.util.UUID;

@RestController
@RequestMapping("/api/bills")
public class BillsController {

    @Autowired
    private BillServices services;

    @Autowired
    private ScheduleServices scheduleServices;


    @GetMapping
    public ResponseEntity<List<Bill>> getAll(){
        List<Bill> bills = services.getAllBills();
        return new ResponseEntity<>(bills, HttpStatus.OK);
    }


    @PostMapping("/status")
    public ResponseEntity<List<Bill>> sendBill(@RequestBody StatusDTO status) throws Exception {
        return new ResponseEntity<>(services.getBillsByStatus(status), HttpStatus.FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<BillReturnDTO> createBill(@RequestBody BillDTO data) throws Exception{
       return new ResponseEntity<>(services.createBill(data), HttpStatus.CREATED);
    }

    @PostMapping("/exclude")
    public void excludeData(@RequestBody BillReturnDTO serialNumber) throws Exception {
        services.deleteData(serialNumber.bill_id());
    }

    @PostMapping("/recover")
    public void recoverData(@RequestBody BillReturnDTO serialNumber) throws Exception {
        services.recoverData(serialNumber.bill_id());
    }



}
