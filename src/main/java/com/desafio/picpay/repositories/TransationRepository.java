package com.desafio.picpay.repositories;

import com.desafio.picpay.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransationRepository extends JpaRepository<Transaction, Long> {
}
