package com.desafio.picpay.application;

import com.desafio.picpay.controllers.Response.UserResponse;
import com.desafio.picpay.controllers.requests.CreateUserRequest;
import com.desafio.picpay.entities.TypeUser;
import com.desafio.picpay.entities.User;
import com.desafio.picpay.infra.exception.NotFoundException;
import com.desafio.picpay.repositories.UserRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void create(CreateUserRequest request) {

        var user = new User(request.name(), request.email(), request.password(),
                request.balance(), request.document(),request.typeDocument(), request.typeUser());

        repository.save(user);
    }

    public User getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("user not found"));
    }

    public List<UserResponse> getAll() {
        var users = repository.findAll();

        List<UserResponse> usersResponse = new ArrayList<>();

        for (User user : users) {
            UserResponse response = new UserResponse(
                    user.getId(),
                    user.getCreatedAt(),
                    user.getUpdatedAt(),
                    user.getActive(),
                    user.getName(),
                    user.getEmail(),
                    user.getPassword(),
                    user.getBalance(),
                    user.getDocument(),
                    user.getTypeDocument(),
                    user.getTypeUser()
            );

            usersResponse.add(response);
        }

        return usersResponse;
    }

    public void verifyPayerUser(Long payerUserId, BigDecimal amount) throws BadRequestException {
        var user = getById(payerUserId);

        if (!user.getActive()) {
            throw new BadRequestException("user disable");
        }

        if (user.getTypeUser().equals(TypeUser.LOJISTA)) {
            throw new BadRequestException("the user cannot transfer");
        }

        if (user.getBalance().compareTo(amount) < 0) {
            throw new BadRequestException("insufficient balance");
        }
    }

    public void verifyPayeeUser(Long payeeUserId) throws BadRequestException {
        var user = getById(payeeUserId);

        if (!user.getActive()) {
            throw new BadRequestException("user disable");
        }
    }

    public void update(User user) {
        repository.save(user);
    }
}
