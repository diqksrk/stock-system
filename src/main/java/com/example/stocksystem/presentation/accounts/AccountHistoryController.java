package com.example.stocksystem.presentation.accounts;

import com.example.stocksystem.infrastructure.exception.GlobalRequestException;
import com.example.stocksystem.application.accounts.AccountHistoryService;
import com.example.stocksystem.domain.model.accounts.Entity.AccountHistory;
import com.example.stocksystem.domain.model.accounts.Resource.AccountHistoryResource;
import com.example.stocksystem.domain.model.accounts.validator.AccountHistoryValidator;
import com.example.stocksystem.presentation.accounts.request.AccountHistoryRegistrationRequest;
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
@RequestMapping(value = "/api/accounthistorys", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class AccountHistoryController {
    private final AccountHistoryService accountHistoryService;
    private final AccountHistoryValidator accountHistoryValidator;

    @PostMapping
    @ApiOperation(value = "계좌내역 추가", notes = "계좌내역을 추가합니다.")
    public ResponseEntity registerAccountHistory(@RequestBody @Valid AccountHistoryRegistrationRequest accountRegistrationRequest, Errors errors) {
        if (errors.hasErrors()) {
            return GlobalRequestException.badRequest(errors);
        }
        accountHistoryValidator.validate(accountRegistrationRequest, errors);
        if (errors.hasErrors()) {
            return GlobalRequestException.badRequest(errors);
        }

        AccountHistory newAccountHistory = accountHistoryService.registerAccountHistory(accountRegistrationRequest);

        var selfLinkBuilder = linkTo(AccountController.class).slash(newAccountHistory.getId());
        URI createdUri = selfLinkBuilder.toUri();
        AccountHistoryResource accountHistoryResource = new AccountHistoryResource(newAccountHistory);
        accountHistoryResource.add(linkTo(AccountController.class).withRel("query-accounthistorys"));
        return ResponseEntity.created(createdUri).body(accountHistoryResource);
    }

    @GetMapping
    @ApiOperation(value = "계좌내역 목록", notes = "전체 계좌내역 목록을 조회합니다.")
    public ResponseEntity queryAccountHistorys(Pageable pageable, PagedResourcesAssembler<AccountHistory> assembler) {
        Page<AccountHistory> page = accountHistoryService.queryAccountHistorys(pageable);
        Page<AccountHistory> accountHistoryResponses = page.map(m -> {
            m.getAccount().setUser(null);
            return m;
        });

        PagedModel<AccountHistoryResource> userResources = assembler.toModel(page, e -> new AccountHistoryResource(e));
        return ResponseEntity.ok(userResources);
    }
}
