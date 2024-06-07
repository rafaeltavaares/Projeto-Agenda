package com.example.crudcomservico.domain;
import com.example.crudcomservico.DTOs.BillDTO;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Bills")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigDecimal value_of_bills;

    @Column(unique = true)
    private UUID serialNumber;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime timeStamp;

    private boolean active;

    public Bill(BillDTO data){
        this.name = data.name();
        this.value_of_bills = data.value();
        this.status = Status.PENDING;
        this.timeStamp = LocalDateTime.now();
        this.serialNumber = UUID.randomUUID();
        this.active = true;
    }

    public void active(){
        this.active = true;
    }

    public void desactive(){
        this.active = false;
    }



}
