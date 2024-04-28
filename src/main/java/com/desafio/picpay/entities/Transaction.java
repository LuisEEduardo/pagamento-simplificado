package com.desafio.picpay.entities;

import com.desafio.picpay.config.Zone;
import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Getter
@Entity(name = "tb_transaction")
@Table(name = "tb_transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "payer_id")
    private User payer;

    @ManyToOne
    @JoinColumn(name = "payee_id")
    private User payee;

    public Transaction() {
    }

    public Transaction(BigDecimal amount, User payer, User payee) {
        createdAt = LocalDateTime.now(ZoneId.of(Zone.BRASIL));
        updatedAt = null;
        this.amount = amount;
        this.payer = payer;
        this.payee = payee;
    }
}
