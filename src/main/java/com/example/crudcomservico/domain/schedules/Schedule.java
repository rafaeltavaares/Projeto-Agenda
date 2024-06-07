package com.example.crudcomservico.domain.schedules;

import com.example.crudcomservico.domain.Bill;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "schedule")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;

    private LocalDate paymentDate;


    public Schedule(Bill data, LocalDate date){
        this.bill = data;
        this.paymentDate = date;
    }


}
