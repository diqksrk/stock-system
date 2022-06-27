package com.example.stocksystem.domain.model.users;

import com.example.stocksystem.presentation.users.UserController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

import java.util.Arrays;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

public class UserResource extends EntityModel<User> {
    public UserResource(User user, Link... links) {
        super(user, Arrays.asList(links));
        add(linkTo(UserController.class).slash(user.getId()).withSelfRel());
    }
}
