package com.example.stocksystem.presentation.users;

import com.example.stocksystem.domain.model.users.User;
import com.example.stocksystem.domain.model.users.UserResource;
import com.example.stocksystem.domain.model.users.UserValidator;
import com.example.stocksystem.infrastructure.exception.GlobalRequestException;
import com.example.stocksystem.presentation.users.request.UserRegistrationResquest;
import com.example.stocksystem.application.users.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping(value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserValidator userValidator;

    @PostMapping
    @ApiOperation(value = "유저 등록", notes = "유저를 등록합니다.")
    public ResponseEntity createUser(@RequestBody @Valid UserRegistrationResquest userRegistrationResquest, Errors errors) {
        if (errors.hasErrors()) {
            return GlobalRequestException.badRequest(errors);
        }
        userValidator.validate(userRegistrationResquest, errors);
        if (errors.hasErrors()) {
            return GlobalRequestException.badRequest(errors);
        }

        User newUser = userService.createUser(userRegistrationResquest);

        var selfLinkBuilder = linkTo(UserController.class).slash(newUser.getId());
        URI createdUri = selfLinkBuilder.toUri();
        UserResource userResource = new UserResource(newUser);
        userResource.add(linkTo(UserController.class).withRel("query-users"));
        return ResponseEntity.created(createdUri).body(userResource);
    }

    @GetMapping
    @ApiOperation(value = "유저 목록 조회", notes = "유저 목록을 조회합니다.")
    public ResponseEntity queryUsers(Pageable pageable, PagedResourcesAssembler<User> assembler) {
        Page<User> page = userService.queryUsers(pageable);
        PagedModel<UserResource> userResources = assembler.toModel(page, e -> new UserResource(e));

        return ResponseEntity.ok(userResources);
    }
}
