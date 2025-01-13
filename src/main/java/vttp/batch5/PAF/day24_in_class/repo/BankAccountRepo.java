package vttp.batch5.PAF.day24_in_class.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import vttp.batch5.PAF.day24_in_class.model.BankAccount;
import vttp.batch5.PAF.day24_in_class.model.exception.AccountNotFoundException;
import vttp.batch5.PAF.day24_in_class.utils.Queries;

@Repository
public class BankAccountRepo {

    @Autowired
    private JdbcTemplate template;

    public Boolean accountExists(int accountId) {

        try {
            BankAccount bankAccount = template.queryForObject(Queries.selectByBankAccountIdSQL,
                    BeanPropertyRowMapper.newInstance(BankAccount.class), accountId);
            return true;
        } catch (DataAccessException error) {
            throw new AccountNotFoundException("The account you are querying doesn't exist in the database");
        }
    }

    public BankAccount getAccountById(int accountId) {
        try {
            BankAccount account = template.queryForObject(Queries.selectByBankAccountIdSQL,
                    BeanPropertyRowMapper.newInstance(BankAccount.class), accountId);

            return account;
        } catch (DataAccessException ex) {
            throw new AccountNotFoundException("Account with id " + accountId + " does not exist.");
        }
    }

    public Boolean updateAccountById(BankAccount accountToUpdate) {
        int accountUpdated = template.update(Queries.updateBankAccountByIdSQL, accountToUpdate.getBalance(),
                accountToUpdate.getId());

        if (accountUpdated > 0) {
            return true;
        }
        return false;
    }
}
