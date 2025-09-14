package com.dias.payment_stripe.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDTO {
    private long amount;
    private long quantity;
    private String name;
    private String currency;
}
