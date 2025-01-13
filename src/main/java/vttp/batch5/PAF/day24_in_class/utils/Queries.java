package vttp.batch5.PAF.day24_in_class.utils;

public class Queries {

    public static final String createAccountSQL = "insert into BankAccount (fullName, isActive, balance) values (?, ?, ?)";

    public static final String selectAllBankAccountSQL = "select * from BankAccount";

    public static final String selectByBankAccountIdSQL = "select * from BankAccount where id = ?";

    public static final String deleteBankAccountByIdSQL = "update BankAccount set isActive = false where id = ?";

    public static final String updateBankAccountByIdSQL = "update BankAccount set balance = ? where id = ?";

    public static final String checkAccountExistsSQL = "select count(*) as cnt from BankAccount where id = ?";

    public static final String createBookSql = "insert into book (title, quantity) values (?, ?)";

    public static final String getBooksSql = "select * from book";

    public static final String getBookById = "select * from book where id = ?";

    public static final String updateBookById = "update book set title = ?, quantity = ? where id = ?";

    public static final String updateBookStatusById = "update book set is_active = ? where id = ?";

    public static final String insertReservation = "insert into reservation(fullName, bookingDate) values (?, ?)";

    public static final String insertReservationDetail = "insert into reservationdetails (book_id, reservation_id) values (?, ?)";

}
