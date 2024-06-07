package com.example.crudcomservico.services;

import com.example.crudcomservico.DTOs.BillDTO;
import com.example.crudcomservico.DTOs.BillReturnDTO;
import com.example.crudcomservico.DTOs.BillStatusDetailedDTO;
import com.example.crudcomservico.DTOs.StatusDTO;
import com.example.crudcomservico.domain.Bill;
import com.example.crudcomservico.domain.Status;
import com.example.crudcomservico.domain.schedules.Schedule;
import com.example.crudcomservico.repositories.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BillServices {

    @Autowired
    private BillRepository repository;

    @Autowired
    private ScheduleServices scheduleServices;



    public BillStatusDetailedDTO getBillsSchdule(UUID serialNumber) throws Exception {
        Bill bill = this.getDataFromSerialNumber(serialNumber);
        LocalDate date = scheduleServices.getScheduleDate(bill.getId());
        return new BillStatusDetailedDTO(bill.getSerialNumber(),bill.getName(), bill.getValue_of_bills(), date ,bill.getStatus());
    }


    public Bill getDataFromSerialNumber(UUID serialNumber) throws Exception{
       return repository.findBySerialNumber(serialNumber).orElseThrow(() -> new RuntimeException("Not found"));
    }

    public List<Bill> getBillsByStatus(StatusDTO status) throws Exception{
        return repository.findByStatus(status.status()).orElseThrow(()-> new RuntimeException("Invalid Insert"));
    }

    public List<Bill> getAllBills(){
        return this.repository.findBillByActiveTrue().stream().toList();
    }

    public void saveBill(Bill data){
        this.repository.save(data);
    }

    public BillReturnDTO createBill(BillDTO data){
        Bill newBill = new Bill(data);
        this.saveBill(newBill);
        scheduleServices.persistData(newBill,data.dateTime());
        return new BillReturnDTO(newBill.getSerialNumber());
    }

    public void deleteData(UUID serialNumber) throws Exception {
        Bill data = this.getDataFromSerialNumber(serialNumber);
        if(data.getStatus() == Status.PENDING){
            data.desactive();
            this.saveBill(data);
        }
        throw new RuntimeException("Essa funcionalidade so é suportada para contas que ainda estão pendentes.");
    }

    public void recoverData(UUID serialNumber) throws Exception {
        Bill data = this.getDataFromSerialNumber(serialNumber);
        if(data.getStatus() == Status.PENDING){
            data.active();
            this.saveBill(data);
        }
        throw new RuntimeException("Essa funcionalidade so é suportada para contas que ainda estão pendentes.");

    }





}
