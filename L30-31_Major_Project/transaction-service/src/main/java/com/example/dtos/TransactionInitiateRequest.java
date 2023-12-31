package com.example.dtos;


import lombok.*;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionInitiateRequest {

    @NotBlank
    private String receiver; // phone number

    @NotNull
    private Double amount;

    private String purpose;
}
