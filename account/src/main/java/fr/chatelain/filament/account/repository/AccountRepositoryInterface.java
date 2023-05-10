package fr.chatelain.filament.account.repository;

import fr.chatelain.filament.core.entity.account.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountRepositoryInterface extends CrudRepository<Account, String> {
    Optional<Account> findByAlias(String alias);
}
