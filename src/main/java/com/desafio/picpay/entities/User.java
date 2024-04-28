package com.desafio.picpay.entities;

import com.desafio.picpay.config.Zone;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Getter
@Setter
@Entity(name = "tb_user")
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Setter
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Setter
    @Column(name = "active", nullable = false)
    private Boolean active;

    @Setter
    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Setter
    @Column(name = "email", nullable = false, length = 256, unique = true)
    private String email; // unique

    @Setter
    @Column(nullable = false, length = 200)
    private String password;

    @Column(nullable = false)
    private BigDecimal balance;

    @Column(name = "document", nullable = false, length = 50, unique = true)
    private String document;

    @Column(name = "type_document", nullable = false)
    private TypeDocument typeDocument;

    @Column(name = "type_user", nullable = false)
    private TypeUser typeUser;

    public User() {
    }

    public User(String name, String email, String password, BigDecimal balance, String document, TypeDocument typeDocument, TypeUser typeUser) {
        createdAt = LocalDateTime.now(ZoneId.of(Zone.BRASIL));
        updatedAt = null;
        active = true;
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
        this.document = document;
        this.typeDocument = typeDocument;
        this.typeUser = typeUser;
    }
}
