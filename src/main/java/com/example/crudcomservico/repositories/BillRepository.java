package com.example.crudcomservico.repositories;

import com.example.crudcomservico.domain.Bill;
import com.example.crudcomservico.domain.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BillRepository extends JpaRepository<Bill,Long> {

    Optional<List<Bill>> findByStatus(Status status);

    Optional<Bill> findBySerialNumber(UUID SerialNumber);

    List<Bill> findBillByActiveTrue();



}
