package com.example.crudcomservico.repositories;

import com.example.crudcomservico.domain.Bill;
import com.example.crudcomservico.domain.schedules.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {


}
