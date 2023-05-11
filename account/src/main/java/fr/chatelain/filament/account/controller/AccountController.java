package fr.chatelain.filament.account.controller;

import fr.chatelain.filament.account.dto.DtoBoolean;
import fr.chatelain.filament.account.service.AccountService;
import fr.chatelain.filament.core.entity.account.Account;
import fr.chatelain.filament.core.entity.account.FactoryAccount;
import fr.chatelain.filament.core.entity.dto.DtoAccount;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    private RestTemplate restTemplate;

    @Autowired
    private ModelMapper modelMapper;

    private HttpHeaders headers;

    public AccountController() {
        headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
    }

    @GetMapping("/alias/{alias}")
    public ResponseEntity<DtoAccount> findByAliasName(@PathVariable("alias") String alias){
        try {
            Account account = accountService.findByAliasName(alias).orElseThrow();
            return new ResponseEntity<>(convertToDto(account),headers, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/alias/{alias}/exists")
    public ResponseEntity<DtoBoolean> existsAccountByAliasName(@PathVariable("alias") String alias){
        return new ResponseEntity<>(new DtoBoolean(accountService.existsAccountByAliasName(alias)),headers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DtoAccount> save(@RequestBody DtoAccount dtoAccount){
        Account account = convertToEntity(dtoAccount);
        account.setId(UUID.randomUUID().toString());
        DtoAccount accountCreated = convertToDto(accountService.save(account));
        return new ResponseEntity<>(accountCreated,headers, HttpStatus.OK);
    }

    private DtoAccount convertToDto(Account account) {
        return modelMapper.map(account, DtoAccount.class);
    }

    private Account convertToEntity(DtoAccount dtoAccount) {
        return modelMapper.map(dtoAccount, Account.class);
    }

    public AccountService getAccountService() {
        return accountService;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
