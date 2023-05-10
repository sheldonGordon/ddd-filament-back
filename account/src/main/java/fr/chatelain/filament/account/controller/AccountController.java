package fr.chatelain.filament.account.controller;

import fr.chatelain.filament.account.service.AccountService;
import fr.chatelain.filament.core.entity.account.Account;
import fr.chatelain.filament.core.entity.dto.DtoAccount;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    private RestTemplate restTemplate;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/alias/{alias}")
    public DtoAccount findByAlias(@PathVariable("alias") String alias){
        System.out.println("La méthode get a été invoquée");
        Account account = accountService.findByAlias(alias).orElseThrow();
        return convertToDto(account);
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
