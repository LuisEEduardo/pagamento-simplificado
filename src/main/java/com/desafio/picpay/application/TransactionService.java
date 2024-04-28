package com.desafio.picpay.application;

import com.desafio.picpay.entities.Transaction;
import com.desafio.picpay.repositories.TransationRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransactionService {

    private final UserService userService;
    private final AuthorizationTransationService authorizationTransationService;
    private final TransationRepository transationRepository;
    private final NotificationService notificationService;

    public TransactionService(UserService userService, AuthorizationTransationService authorizationTransationService, TransationRepository transationRepository, NotificationService notificationService) {
        this.userService = userService;
        this.authorizationTransationService = authorizationTransationService;
        this.transationRepository = transationRepository;
        this.notificationService = notificationService;
    }

    public void transfer(Long payerUserId, Long payeeUserId, BigDecimal amount) throws Exception {
        userService.verifyPayerUser(payerUserId, amount);
        userService.verifyPayeeUser(payeeUserId);
        authorizationTransationService.verifyIfTransactionAuthorized();

        var payer = userService.getById(payerUserId);
        var payee = userService.getById(payeeUserId);

        payer.setBalance(payer.getBalance().subtract(amount));
        payee.setBalance(payee.getBalance().add(amount));

        userService.update(payer);
        userService.update(payee);

        var transaction = new Transaction(amount, payer, payee);
        transationRepository.save(transaction);

        notificationService.send();
    }
}
