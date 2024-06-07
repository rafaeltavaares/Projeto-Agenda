package com.example.crudcomservico.DTOs;

import java.time.LocalDate;
import java.util.UUID;

public record UpdateDateDTO(LocalDate date, UUID bill_id) {



}
