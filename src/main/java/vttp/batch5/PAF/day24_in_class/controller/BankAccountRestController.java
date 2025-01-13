package vttp.batch5.PAF.day24_in_class.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    public ResponseEntity<BankAccount> getById(@PathVariable("account-id") Integer accountId) {
        BankAccount bankAccount = bankAccountService.getAccountById(accountId);

        return ResponseEntity.ok().body(bankAccount);
    }

    @PostMapping("/transfer/from/{account-id}/to/{account-to}/amount/{transfer-amount}")
    public ResponseEntity<Boolean> transferFund(@PathVariable("account-id") Integer accountFromId,
            @PathVariable("account-to") Integer accountToId, @PathVariable("transfer-amount") Float amount) {

        Boolean transferred = bankAccountService.transfer(accountFromId, accountToId, amount);

        return ResponseEntity.ok().body(transferred);
    }

}
