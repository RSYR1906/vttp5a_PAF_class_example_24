package vttp.batch5.PAF.day24_in_class.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp.batch5.PAF.day24_in_class.repo.BankAccountRepo;

@Service
public class BankAccountService {
    
    @Autowired
    private BankAccountRepo bankAccountRepo;

    public Boolean checkAccountExists(int accountId){
        return bankAccountRepo.accountExists(accountId);
    }
}
