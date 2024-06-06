package com.example.crudcomservico.services;

import com.example.crudcomservico.DTOs.BillDTO;
import com.example.crudcomservico.DTOs.StatusDTO;
import com.example.crudcomservico.domain.Bill;
import com.example.crudcomservico.repositories.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class BillServices {

    @Autowired
    private BillRepository repository;

    @Autowired
    private ScheduleServices scheduleServices;

    public void saveBill(Bill data){
        this.repository.save(data);
    }

    public void createBill(BillDTO data){
        Bill newBill = new Bill(data);
        this.saveBill(newBill);
        scheduleServices.persistData(newBill,data.dateTime());
    }

    public List<Bill> getBillsByStatus(StatusDTO status) throws Exception{
        return repository.findByStatus(status.status()).orElseThrow(()-> new RuntimeException("Invalid Insert"));
    }

    public List<Bill> getAllBills(){
        return this.repository.findAll();
    }






}
