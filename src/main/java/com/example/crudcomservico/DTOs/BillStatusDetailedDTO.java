package com.example.crudcomservico.DTOs;

import com.example.crudcomservico.domain.Status;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record BillStatusDetailedDTO(UUID biils_id, String name, BigDecimal value, LocalDate date, Status status) {



}
