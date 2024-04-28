package com.desafio.picpay.controllers;


import com.desafio.picpay.application.TransactionService;
import com.desafio.picpay.controllers.requests.TransferRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/transaction", produces = {"application/json"})
@Tag(name = "transaction")
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @PostMapping()
    @Operation(summary = "transfer", method = "POST")
    public ResponseEntity<?> transfer(@RequestBody TransferRequest request) throws Exception {
        service.transfer(request.payerUserId(), request.payeeUserId(), request.amount());
        return ResponseEntity.noContent().build();
    }

}
