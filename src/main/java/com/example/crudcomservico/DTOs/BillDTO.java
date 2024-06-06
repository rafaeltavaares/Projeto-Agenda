package com.example.crudcomservico.DTOs;

import com.example.crudcomservico.domain.Status;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record BillDTO(String name, BigDecimal value, LocalDate dateTime) {
}
