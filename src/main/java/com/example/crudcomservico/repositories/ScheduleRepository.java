package com.example.crudcomservico.repositories;

import com.example.crudcomservico.domain.schedules.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {
}
