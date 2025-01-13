package vttp.batch5.PAF.day24_in_class.utils;

public class Queries {

    public static final String createAccountSQL = "INSERT into BankAccount (fullName,isActive,balance) VALUES(?,?,?)";

    public static final String selectAllBankAccountSQL = "SELECT * FROM BankAccount";

    public static final String selectByBankAccountIdSQL = "SELECT * FROM BankAccount WHERE id = ?";

    public static final String deleteBankAccountByIdSQL = "UPDATE BankAccount SET isActive = false WHERE id = ?";

    public static final String updateBankAccountByIdSQL = "UPDATE BankAccount SET balance = ? WHERE id = ?";

    public static final String checkIfAccountExists = "CHECK count(*) AS cnt WHERE id = ?";

}
