package com.example.stocksystem.presentation.accounts;

import com.example.stocksystem.infrastructure.exception.GlobalRequestException;
import com.example.stocksystem.application.accounts.AccountService;
import com.example.stocksystem.domain.model.accounts.Entity.Account;
import com.example.stocksystem.domain.model.accounts.Resource.AccountResource;
import com.example.stocksystem.domain.model.accounts.validator.AccountValidator;
import com.example.stocksystem.presentation.accounts.request.AccountRegistrationRequest;
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
@RequestMapping(value = "/api/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class AccountController {
    private final AccountValidator accountValidator;
    private final AccountService accountService;

    @PostMapping
    @ApiOperation(value = "계좌 등록", notes = "계좌를 등록합니다.")
    public ResponseEntity registerAccount(@RequestBody @Valid AccountRegistrationRequest accountRegistrationRequest, Errors errors) {
        if (errors.hasErrors()) {
            return GlobalRequestException.badRequest(errors);
        }
        accountValidator.validate(accountRegistrationRequest, errors);
        if (errors.hasErrors()) {
            return GlobalRequestException.badRequest(errors);
        }

        Account newAccount = accountService.registerAccount(accountRegistrationRequest);

        var selfLinkBuilder = linkTo(AccountController.class).slash(newAccount.getId());
        URI createdUri = selfLinkBuilder.toUri();
        AccountResource accountResource = new AccountResource(newAccount);
        accountResource.add(linkTo(AccountController.class).withRel("query-accounts"));
        return ResponseEntity.created(createdUri).body(accountResource);
    }

    @GetMapping
    @ApiOperation(value = "계좌 조회", notes = "전체 계좌를 조회합니다.")
    public ResponseEntity queryAccounts(Pageable pageable, PagedResourcesAssembler assembler) {
        Page<Account> page = accountService.queryAccounts(pageable);
        PagedModel<AccountResource> userResources = assembler.toModel(page, e -> new AccountResource(e));

        return ResponseEntity.ok(userResources);
    }
}
