package vttp.batch5.PAF.day24_in_class.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vttp.batch5.PAF.day24_in_class.model.BankAccount;
import vttp.batch5.PAF.day24_in_class.model.exception.AccountInactiveException;
import vttp.batch5.PAF.day24_in_class.model.exception.InsufficientException;
import vttp.batch5.PAF.day24_in_class.repo.BankAccountRepo;

@Service
public class BankAccountService {

    @Autowired
    private BankAccountRepo bankAccountRepo;

    public Boolean checkAccountExists(int accountId) {
        return bankAccountRepo.accountExists(accountId);
    }

    public BankAccount getAccountById(int accountId) {
        return bankAccountRepo.getAccountById(accountId);
    }

    @Transactional
    public boolean transfer(int transfererAccountId, int transfereeAccountId, float transferAmount) {
        // retrieve both accounts
        BankAccount accountFrom = bankAccountRepo.getAccountById(transfererAccountId);
        BankAccount accountTo = bankAccountRepo.getAccountById(transfereeAccountId);

        // check both accounts active or not
        Boolean isAccountFromActive = checkAccountActive(accountFrom);
        Boolean isAccountToActive = checkAccountActive(accountTo);

        // check transferer has sufficient balance to tranfer the transfer amount
        Boolean isTransfererBalanceSufficient = checkSufficientBalance(accountFrom, transferAmount);

        // logic to decide whether to continue to perform the transaction
        if (isAccountFromActive && isAccountToActive && isTransfererBalanceSufficient) {
            // must be perfrom in transaction
            // perform withdrawal from transferer
            accountFrom.setBalance(accountFrom.getBalance() - transferAmount);
            bankAccountRepo.updateAccountById(accountFrom);
            // perform deposit to transferee
            accountTo.setBalance(accountTo.getBalance() + transferAmount);
            bankAccountRepo.updateAccountById(accountTo);

            return true;
        }
        return false;

    }

    private Boolean checkAccountActive(BankAccount account) {
        if (account.getIsActive().equals(true))
            return true;

        throw new AccountInactiveException(
                "Account ID " + account.getId() + " - " + account.getFullName() + " is inactive.");
    }

    private Boolean checkSufficientBalance(BankAccount account, float transferAmount) {
        Boolean isSufficientFund = ((account.getBalance() - transferAmount) > 0) ? true : false;
        if (isSufficientFund)
            return true;

        throw new InsufficientException(
                "Transferer " + account.getFullName() + " doesn't not have sufficient fund to make the transfer.");
    }
}
