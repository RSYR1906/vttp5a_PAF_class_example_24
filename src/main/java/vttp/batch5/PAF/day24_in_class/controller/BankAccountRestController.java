package vttp.batch5.PAF.day24_in_class.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vttp.batch5.PAF.day24_in_class.model.BankAccount;
import vttp.batch5.PAF.day24_in_class.service.BankAccountService;

@RestController
@RequestMapping("/api/bankaccounts")
public class BankAccountRestController {

    @Autowired
    private BankAccountService bankAccountService;

    @GetMapping("/exists/{account-id}")
    public ResponseEntity<Boolean> checkAccountExists(@PathVariable("account-id") Integer accountId) {

        Boolean isAccountExists = bankAccountService.checkAccountExists(accountId);

        return ResponseEntity.ok().body(isAccountExists);
    }

    @GetMapping("/{account-id}")
    public ResponseEntity<BankAccount> getById(@PathVariable("account-id") Integer accountId){
        BankAccount bankAccount 
    }

}
