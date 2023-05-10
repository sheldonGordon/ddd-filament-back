package fr.chatelain.filament.account.controller;

import fr.chatelain.filament.account.service.AccountService;
import fr.chatelain.filament.core.entity.account.Account;
import fr.chatelain.filament.core.entity.dto.DtoAccount;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    private RestTemplate restTemplate;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/alias/{alias}")
    public ResponseEntity<DtoAccount> findByAliasName(@PathVariable("alias") String alias){
        System.out.println("La méthode get a été invoquée");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        try {
            Account account = accountService.findByAliasName(alias).orElseThrow();
            return new ResponseEntity<>(convertToDto(account),headers, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public DtoAccount save(@RequestBody DtoAccount dtoAccount){
        Account account = convertToEntity(dtoAccount);
        DtoAccount accountCreated = convertToDto(accountService.save(account));
        return accountCreated;
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
