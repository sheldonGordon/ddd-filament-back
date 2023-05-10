package fr.chatelain.filament.account.service;

import fr.chatelain.filament.account.repository.AccountRepositoryInterface;
import fr.chatelain.filament.core.entity.account.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepositoryInterface accountRepository;

    public Account save(Account account){
        return accountRepository.save(account);
    }

    public Optional<Account> findByAlias(String alias){
        return accountRepository.findByAlias(alias);
    }
}
