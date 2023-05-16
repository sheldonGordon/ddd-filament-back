package fr.chatelain.filament.account.repository;

import fr.chatelain.filament.core.entity.account.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepositoryInterface extends CrudRepository<Account, String> {

    Optional<Account> findByAliasName(String aliasName);
    Optional<Account> findById(String id);
    boolean existsAccountByAliasName(String aliasName);
}
