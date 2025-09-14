package com.dias.payment_stripe.controllers;

import com.dias.payment_stripe.dtos.ProductRequestDTO;
import com.dias.payment_stripe.dtos.StripeResponseDTO;
import com.dias.payment_stripe.services.StripeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductCheckoutController {

    private final StripeService stripeService;

    @PostMapping("/checkout")
    public ResponseEntity<StripeResponseDTO> checkoutProducts(@RequestBody ProductRequestDTO productRequestDTO) {
        StripeResponseDTO stripeResponseDTO = stripeService.checkoutProducts(productRequestDTO);

        return ResponseEntity.ok(stripeResponseDTO);
    }
}
